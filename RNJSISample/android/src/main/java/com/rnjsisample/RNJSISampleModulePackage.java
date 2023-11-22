package com.rnjsisample;

import com.facebook.react.bridge.JSIModulePackage;
import com.facebook.react.bridge.JSIModuleSpec;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.UIManagerModule;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import android.util.Log;

public class RNJSISampleModulePackage implements JSIModulePackage {
  @Override
  public List<JSIModuleSpec> getJSIModules(
    ReactApplicationContext reactApplicationContext, 
    JavaScriptContextHolder jsContext) {

		reactApplicationContext.getNativeModule(RNJSISampleModule.class).install(jsContext);
    	return Collections.emptyList();
    }
} 