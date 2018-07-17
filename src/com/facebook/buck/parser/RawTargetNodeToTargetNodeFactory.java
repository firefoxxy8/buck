/*
 * Copyright 2018-present Facebook, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.facebook.buck.parser;

import com.facebook.buck.core.cell.Cell;
import com.facebook.buck.core.exceptions.HumanReadableException;
import com.facebook.buck.core.model.BuildTarget;
import com.facebook.buck.core.model.targetgraph.DescriptionWithTargetGraph;
import com.facebook.buck.core.model.targetgraph.RawTargetNode;
import com.facebook.buck.core.model.targetgraph.TargetNode;
import com.facebook.buck.core.model.targetgraph.impl.TargetNodeFactory;
import com.facebook.buck.core.rules.knowntypes.KnownBuildRuleTypes;
import com.facebook.buck.core.select.SelectorList;
import com.facebook.buck.core.select.SelectorListResolver;
import com.facebook.buck.event.PerfEventId;
import com.facebook.buck.event.SimplePerfEvent.Scope;
import com.facebook.buck.rules.coercer.ConstructorArgMarshaller;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.function.Function;

/** Creates {@link TargetNode} from {@link RawTargetNode}. */
public class RawTargetNodeToTargetNodeFactory implements ParserTargetNodeFactory<RawTargetNode> {

  private final ConstructorArgMarshaller marshaller;
  private final TargetNodeFactory targetNodeFactory;
  private final PackageBoundaryChecker packageBoundaryChecker;
  private final TargetNodeListener<TargetNode<?, ?>> nodeListener;
  private final SelectorListResolver selectorListResolver;

  public RawTargetNodeToTargetNodeFactory(
      ConstructorArgMarshaller marshaller,
      TargetNodeFactory targetNodeFactory,
      PackageBoundaryChecker packageBoundaryChecker,
      TargetNodeListener<TargetNode<?, ?>> nodeListener,
      SelectorListResolver selectorListResolver) {
    this.marshaller = marshaller;
    this.targetNodeFactory = targetNodeFactory;
    this.packageBoundaryChecker = packageBoundaryChecker;
    this.nodeListener = nodeListener;
    this.selectorListResolver = selectorListResolver;
  }

  @Override
  public TargetNode<?, ?> createTargetNode(
      Cell cell,
      KnownBuildRuleTypes knownBuildRuleTypes,
      Path buildFile,
      BuildTarget target,
      RawTargetNode rawTargetNode,
      Function<PerfEventId, Scope> perfEventScope) {

    DescriptionWithTargetGraph<?> description =
        knownBuildRuleTypes.getDescription(rawTargetNode.getBuildRuleType());
    Cell targetCell = cell.getCell(target);
    ImmutableSet.Builder<BuildTarget> declaredDeps = ImmutableSet.builder();

    Object constructorArg =
        marshaller.populateFromConfiguredAttributes(
            cell.getCellPathResolver(),
            target,
            description.getConstructorArgType(),
            declaredDeps,
            configureRawTargetNodeAttributes(
                selectorListResolver, target, rawTargetNode.getAttributes().getAll()));

    TargetNode<?, ?> targetNode =
        targetNodeFactory.createFromObject(
            rawTargetNode.getHashCode(),
            description,
            constructorArg,
            targetCell.getFilesystem(),
            target,
            declaredDeps.build(),
            rawTargetNode.getVisibilityPatterns(),
            rawTargetNode.getWithinViewPatterns(),
            targetCell.getCellPathResolver());

    packageBoundaryChecker.enforceBuckPackageBoundaries(targetCell, target, targetNode.getInputs());

    try {
      nodeListener.onCreate(buildFile, targetNode);
    } catch (IOException e) {
      throw new HumanReadableException(e.getMessage(), e);
    }

    return targetNode;
  }

  private ImmutableMap<String, Object> configureRawTargetNodeAttributes(
      SelectorListResolver selectorListResolver,
      BuildTarget buildTarget,
      ImmutableMap<String, Object> rawTargetNodeAttributes) {
    ImmutableMap.Builder<String, Object> configuredAttributes = ImmutableMap.builder();

    for (Map.Entry<String, ?> entry : rawTargetNodeAttributes.entrySet()) {
      Object value =
          configureAttributeValue(
              selectorListResolver, buildTarget, entry.getKey(), entry.getValue());
      if (value != null) {
        configuredAttributes.put(entry.getKey(), value);
      }
    }

    return configuredAttributes.build();
  }

  @SuppressWarnings("unchecked")
  private <T> T configureAttributeValue(
      SelectorListResolver selectorListResolver,
      BuildTarget buildTarget,
      String attributeName,
      Object rawAttributeValue) {
    T value;
    if (rawAttributeValue instanceof SelectorList) {
      SelectorList<T> selectorList = (SelectorList<T>) rawAttributeValue;
      value = selectorListResolver.resolveList(buildTarget, attributeName, selectorList);
    } else {
      value = (T) rawAttributeValue;
    }
    return value;
  }
}
