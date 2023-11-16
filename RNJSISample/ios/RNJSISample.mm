#import "RNJSISample.h"

@implementation RNJSISample
RCT_EXPORT_MODULE()

// Don't compile this code when we build for the old architecture.
#ifdef RCT_NEW_ARCH_ENABLED
- (NSString *)hello {
    const char* message = rnjsisample::hello();
    NSString *result = [NSString stringWithCString:message 
                                  encoding:[NSString defaultCStringEncoding]];
    return result;
}

- (std::shared_ptr<facebook::react::TurboModule>)getTurboModule:
    (const facebook::react::ObjCTurboModule::InitParams &)params
{
    return std::make_shared<facebook::react::NativeRNJSISampleSpecJSI>(params);
}
#endif

@end
