#include <jni.h>
#include <android/log.h>
#include <android/bitmap.h>

#include <GLES2/gl2.h>
#include <GLES2/gl2ext.h>

#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

#define  LOG_TAG    "libgl2jni"
#define  LOGI(...)  __android_log_print(ANDROID_LOG_INFO,LOG_TAG,__VA_ARGS__)
#define  LOGE(...)  __android_log_print(ANDROID_LOG_ERROR,LOG_TAG,__VA_ARGS__)

#include "draw.h"


struct NVGcontext* vg;

float rotation;             // final value
float currentRotation;    	// current animated value
int width, height;
	
namespace abc {}

static void printGLString(const char *name, GLenum s) {
    const char *v = (const char *) glGetString(s);
    LOGI("GL %s = %s\n", name, v);
}

static void checkGlError(const char *op) {
    for (GLint error = glGetError(); error; error = glGetError()) {
        LOGI("after %s() glError (0x%x)\n", op, error);
    }
}

bool setupGraphics(int _w, int _h) {
    width = _w; height = _h;

    printGLString("Version", GL_VERSION);
    printGLString("Vendor", GL_VENDOR);
    printGLString("Renderer", GL_RENDERER);
    printGLString("Extensions", GL_EXTENSIONS);

    LOGI("setupGraphics(%d, %d)", width, height);
	vg = init(width, height);
    return true;
}

void renderFrame() {
    currentRotation = currentRotation*0.9f + rotation * 0.1f;

	drawTriangle(vg, width, height, currentRotation);
}


extern "C" {
    JNIEXPORT void JNICALL Java_com_rtndrawer_GL2JNILib_init(JNIEnv * env, jobject obj,  jint width, jint height);
    JNIEXPORT void JNICALL Java_com_rtndrawer_GL2JNILib_step(JNIEnv * env, jobject obj);
    JNIEXPORT void JNICALL Java_com_rtndrawer_GL2JNILib_setRotation(JNIEnv *env, jclass type, jfloat _rotation);
    JNIEXPORT void JNICALL Java_com_rtndrawer_GL2JNILib_setBackgroundColor(JNIEnv *env, jclass type, jfloat R, jfloat G,
                                                             jfloat B, jfloat A);
    JNIEXPORT void JNICALL Java_com_rtndrawer_GL2JNILib_setTranslation(JNIEnv *env, jclass type, jfloat _x, jfloat _y);
};

JNIEXPORT void JNICALL Java_com_rtndrawer_GL2JNILib_init(JNIEnv * env, jobject obj,  jint width, jint height)
{
    setupGraphics(width, height);
}

JNIEXPORT void JNICALL Java_com_rtndrawer_GL2JNILib_step(JNIEnv * env, jobject obj)
{
    renderFrame();
}

JNIEXPORT void JNICALL
Java_com_rtndrawer_GL2JNILib_setRotation(JNIEnv *env, jclass type, jfloat _rotation) {
    rotation = _rotation;
}

JNIEXPORT void JNICALL
Java_com_rtndrawer_GL2JNILib_setBackgroundColor(JNIEnv *env, jclass type, jfloat R, jfloat G,
                                                     jfloat B, jfloat A) {

    glClearColor(R, G, B, A);  
    checkGlError("glClearColor");
}

JNIEXPORT void JNICALL
Java_com_rtndrawer_GL2JNILib_setTranslation(JNIEnv *env, jclass type, jfloat _x, jfloat _y) {

}

