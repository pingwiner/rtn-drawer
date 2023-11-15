#import <React/RCTLog.h>
#import <React/RCTUIManager.h>
#import <React/RCTViewManager.h>

@interface RTNDrawerManager : RCTViewManager
@end

@implementation RTNDrawerManager

RCT_EXPORT_MODULE(RTNDrawer)

RCT_EXPORT_VIEW_PROPERTY(angle, NSNumber)

@end