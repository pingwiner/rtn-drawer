#ifndef RNJSISAMPLE_H
#define RNJSISAMPLE_H

#include <jsi/jsi.h>

namespace facebook {
namespace jsi {
class Runtime;
}
}

namespace rnjsisample {
  void install(facebook::jsi::Runtime &jsiRuntime);
}

#endif /* RNJSISAMPLE_H */
