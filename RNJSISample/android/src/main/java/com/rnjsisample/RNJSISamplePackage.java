package com.rnjsisample;

import androidx.annotation.NonNull;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.bridge.JavaScriptContextHolder;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import androidx.annotation.Nullable;


public class RNJSISamplePackage implements ReactPackage {  

  @NonNull
  @Override
  public List<NativeModule> createNativeModules(@NonNull ReactApplicationContext reactContext) {    
    Log.i("RNJSISample", "createNativeModules " + reactContext.toString());
    return Collections.singletonList(new RNJSISampleModule(reactContext));
  }

  @NonNull
  @Override
  public List<ViewManager> createViewManagers(@NonNull ReactApplicationContext reactContext) {
    return Collections.emptyList();
  }

}
