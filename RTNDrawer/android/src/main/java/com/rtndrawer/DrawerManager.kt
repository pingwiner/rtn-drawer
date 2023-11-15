package com.rtndrawer

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.annotations.ReactModule
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewManagerDelegate
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.viewmanagers.RTNDrawerManagerInterface
import com.facebook.react.viewmanagers.RTNDrawerManagerDelegate
import android.util.Log
@ReactModule(name = DrawerManager.NAME)
class DrawerManager(context: ReactApplicationContext) : SimpleViewManager<GL2JNIView>(), RTNDrawerManagerInterface<GL2JNIView> {
  private val delegate = RTNDrawerManagerDelegate(this)

  override fun getDelegate(): ViewManagerDelegate<GL2JNIView> = delegate

  override fun getName(): String = NAME

  override fun createViewInstance(context: ThemedReactContext): GL2JNIView = GL2JNIView(context)

  @ReactProp(name = "angle")
  override fun setAngle(view: GL2JNIView, value: Int) {
	Log.d("DrawerManager", "angle: $value\n")
	view.setRotation(value.toFloat());
  }

  companion object {
    const val NAME = "RTNDrawer"
  }

}
