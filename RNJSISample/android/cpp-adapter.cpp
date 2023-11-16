#include <jni.h>
#include "rnjsisample.h"

extern "C"
JNIEXPORT jstring JNICALL
Java_com_rnjsisample_RNJSISampleModule_nativeHello(JNIEnv *env, jclass type) {
    return env->NewStringUTF(rnjsisample::hello());
}
