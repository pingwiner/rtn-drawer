#include "rnjsisample.h"

namespace rnjsisample {

using namespace std;
using namespace facebook::jsi;

void install(Runtime& jsiRuntime) {

      auto helloWorld = Function::createFromHostFunction(jsiRuntime, PropNameID::forUtf8(jsiRuntime, "helloWorld"), 
          0, 
          [](Runtime& runtime,
          const Value& thisValue,
          const Value* arguments, 
          size_t count) -> Value {
            string helloworld = "helloworld";
            return String::createFromUtf8(runtime, helloworld);
      });

      jsiRuntime.global().setProperty(jsiRuntime, "helloWorld", move(helloWorld));

}

}
