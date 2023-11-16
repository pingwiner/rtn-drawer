package com.rnjsisample;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = RNJSISampleModule.NAME)
public class RNJSISampleModule extends NativeRNJSISampleSpec {
  public static final String NAME = "RNJSISample";

  public RNJSISampleModule(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;
  }

  static {
    System.loadLibrary("cpp");
  }

  private static native String nativeHello();

  @Override
  public String hello() {
    return nativeHello();
  }
}
