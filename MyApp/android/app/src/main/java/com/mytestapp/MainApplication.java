package com.mytestapp;

import android.app.Application;
import com.facebook.react.PackageList;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint;
import com.facebook.react.defaults.DefaultReactNativeHost;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.soloader.SoLoader;
import com.facebook.react.bridge.JSIModulePackage;
import com.rnjsisample.RNJSISampleModulePackage;
import com.rnjsisample.RNJSISamplePackage;
import com.facebook.react.bridge.JSIModuleSpec;
import com.facebook.react.bridge.JavaScriptContextHolder;
import java.util.ArrayList;
import java.util.List;
import com.mytestapp.MyAppPackage;

public class MainApplication extends Application implements ReactApplication {

  private final ReactNativeHost mReactNativeHost =
      new DefaultReactNativeHost(this) {
        @Override
        public boolean getUseDeveloperSupport() {
          return BuildConfig.DEBUG;
        }

        @Override
        protected List<ReactPackage> getPackages() {
          @SuppressWarnings("UnnecessaryLocalVariable")
          List<ReactPackage> packages = new PackageList(this).getPackages();
          // Packages that cannot be autolinked yet can be added manually here, for example:
          // packages.add(new MyReactNativePackage());
          packages.add(new MyAppPackage());
          //packages.add(new RNJSISamplePackage());
          return packages;
        }

		private JSIModulePackage mPackage;

        @Override
        protected JSIModulePackage getJSIModulePackage() {
		   mPackage = super.getJSIModulePackage();

		  return new JSIModulePackage() {
	         @Override
	         public List<JSIModuleSpec> getJSIModules(
	           final ReactApplicationContext reactApplicationContext,
	           final JavaScriptContextHolder jsContext
	         ) {
	           final List<JSIModuleSpec> specs = new ArrayList<>();
	           specs.addAll(new RNJSISampleModulePackage().getJSIModules(reactApplicationContext, jsContext));
			   specs.addAll(mPackage.getJSIModules(reactApplicationContext, jsContext));
	           return specs;
	         }
          };

        }

        @Override
        protected String getJSMainModuleName() {
          return "index";
        }

        @Override
        protected boolean isNewArchEnabled() {
          return BuildConfig.IS_NEW_ARCHITECTURE_ENABLED;
        }

        @Override
        protected Boolean isHermesEnabled() {
          return BuildConfig.IS_HERMES_ENABLED;
        }

      };

  @Override
  public ReactNativeHost getReactNativeHost() {
    return mReactNativeHost;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    SoLoader.init(this, /* native exopackage */ false);
    if (BuildConfig.IS_NEW_ARCHITECTURE_ENABLED) {
      // If you opted-in for the New Architecture, we load the native entry point for this app.
      DefaultNewArchitectureEntryPoint.load();
    }
    ReactNativeFlipper.initializeFlipper(this, getReactNativeHost().getReactInstanceManager());
  }

}
