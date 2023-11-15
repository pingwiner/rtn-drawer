package com.mytestapp;

import android.util.Log;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class DrawModule extends ReactContextBaseJavaModule {
   DrawModule(ReactApplicationContext context) {
      super(context);
   }

   @NonNull
   @Override
   public String getName() {
      return "DrawModule";
   }

   @ReactMethod
   public void drawTriangle(int angle) {
      Log.d("DrawModule", "drawTriangle: " + angle);
   }
}