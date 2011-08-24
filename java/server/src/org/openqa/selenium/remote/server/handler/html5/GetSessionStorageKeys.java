/*
Copyright 2010 WebDriver committers
Copyright 2010 Google Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package org.openqa.selenium.remote.server.handler.html5;

import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.server.Session;
import org.openqa.selenium.remote.server.handler.ResponseAwareWebDriverHandler;
import org.openqa.selenium.remote.server.rest.ResultType;

import java.util.Set;

public class GetSessionStorageKeys extends ResponseAwareWebDriverHandler {

  public GetSessionStorageKeys(Session session) {
    super(session);
  }

  public ResultType call() throws Exception {
    Set<String> keys = ((WebStorage) getUnwrappedDriver()).getSessionStorage().keySet();
    response.setValue(keys);
    return ResultType.SUCCESS;
  }

  @Override
  public String toString() {
    return "[get session storage key set]";
  }
}
