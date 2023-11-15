package com.rtndrawer;

// Wrapper for native library

public class GL2JNILib {

     static {
         System.loadLibrary("gl2jni");
     }

    public static native void setBackgroundColor(float R, float G, float B, float A);
    public static native void setRotation(float rotation);
    public static native void setTranslation(float x, float y);

    /**
     * @param width the current view width
     * @param height the current view height
     */
    public static native void init(int width, int height);
    public static native void step();
}
