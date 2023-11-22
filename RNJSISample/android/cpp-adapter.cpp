#include <jni.h>
#include <sys/types.h>
#include "rnjsisample.h"
#include "pthread.h"
#include <jsi/jsi.h>
#include <android/log.h>

#define  LOG_TAG    "rnjsisample"

using namespace facebook::jsi;
using namespace std;

extern "C"
JNIEXPORT void JNICALL
Java_com_rnjsisample_RNJSISampleModule_nativeInstall(JNIEnv *env, jobject thiz, jlong jsi) {

    auto runtime = reinterpret_cast<facebook::jsi::Runtime*>(jsi);

    if (runtime) {
        rnjsisample::install(*runtime);
    }

}



