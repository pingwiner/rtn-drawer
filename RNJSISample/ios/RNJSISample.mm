#import "RNJSISample.h"

#import <React/RCTBridge+Private.h>
#import <React/RCTUtils.h>
#import <jsi/jsi.h>
#import <ReactCommon/CallInvoker.h>
#import <memory>

#include "../cpp/rnjsisample.h"

@implementation RNJSISample

@synthesize bridge = _bridge;
@synthesize methodQueue = _methodQueue;

RCT_EXPORT_MODULE()

+ (BOOL)requiresMainQueueSetup {
    return YES;
}

- (void)setBridge:(RCTBridge *)bridge {
    _bridge = bridge;
    _setBridgeOnMainQueue = RCTIsMainQueue();
    [self installLibrary];
}

- (void)installLibrary {

    RCTCxxBridge *cxxBridge = (RCTCxxBridge *)self.bridge;

    if (cxxBridge.runtime) {
       rnjsisample::install(*(facebook::jsi::Runtime *)cxxBridge.runtime);
    }
}


@end
