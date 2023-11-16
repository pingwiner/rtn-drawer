#ifdef __cplusplus
#import "../cpp/rnjsisample.h"
#endif

#ifdef RCT_NEW_ARCH_ENABLED
#import "RNRNJSISampleSpec.h"

@interface RNJSISample : NSObject <NativeRNJSISampleSpec>
#else
#import <React/RCTBridgeModule.h>

@interface RNJSISample : NSObject <RCTBridgeModule>
#endif

@end
