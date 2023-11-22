package com.rnjsisample;

import android.util.Log;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.bridge.ReactMethod;
import androidx.annotation.Nullable;

@ReactModule(name = RNJSISampleModule.NAME)
public class RNJSISampleModule extends ReactContextBaseJavaModule {
  public static final String NAME = "RNJSISample";


  public RNJSISampleModule(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;
  }

  public void install(JavaScriptContextHolder jsContext) {
    try {
      System.loadLibrary("cpp");

      nativeInstall(jsContext.get());
      Log.i(NAME, "RNJSISampleModule::nativeInstall");
    } catch (Exception exception) {
      Log.e(NAME, "Failed to install JSI Bindings!", exception);
    }

  }

  @Override    
  public boolean canOverrideExistingModule() {        
    return true;    
  }

  private static native void nativeInstall(long jsi);
}
