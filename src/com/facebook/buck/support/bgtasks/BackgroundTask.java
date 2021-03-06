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

package com.facebook.buck.support.bgtasks;

import org.immutables.value.Value;

/**
 * Abstract class for background tasks to be run after build, e.g. cleanup/logging. Tasks take an
 * action (e.g. close an event listener) and the arguments for that action. Tasks should be run by a
 * {@link BackgroundTaskManager}.
 */
@Value.Immutable
@Value.Style(init = "set*")
public abstract class BackgroundTask<T> {

  @Value.Parameter
  public abstract String getName();

  @Value.Parameter
  public abstract TaskAction<T> getAction();

  @Value.Parameter
  protected abstract T getActionArgs();

  public void run() throws Exception {
    getAction().run(getActionArgs());
  }
}
