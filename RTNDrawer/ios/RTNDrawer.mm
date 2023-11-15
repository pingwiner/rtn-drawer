#import "RTNDrawer.h"

#import <react/renderer/components/RTNDrawerSpecs/ComponentDescriptors.h>
#import <react/renderer/components/RTNDrawerSpecs/EventEmitters.h>
#import <react/renderer/components/RTNDrawerSpecs/Props.h>
#import <react/renderer/components/RTNDrawerSpecs/RCTComponentViewHelpers.h>

#import "RCTFabricComponentsPlugins.h"
#import <QuartzCore/QuartzCore.h>

#import <OpenGLES/ES2/glext.h>
#include "draw.h"

using namespace facebook::react;

@interface RTNDrawer () <RCTRTNDrawerViewProtocol>
@end

@implementation RTNDrawer {
  UIView *_view;
  GLKView *_glView;
  NVGcontext* vg;	
  CGFloat width;
  CGFloat height;
  int rotation;
}

+ (ComponentDescriptorProvider)componentDescriptorProvider
{
  return concreteComponentDescriptorProvider<RTNDrawerComponentDescriptor>();
}

- (instancetype)initWithFrame:(CGRect)frame
{
  if (self = [super initWithFrame:frame]) {
	width = frame.size.width;
    height = frame.size.height;

    static const auto defaultProps = std::make_shared<const RTNDrawerProps>();
    _props = defaultProps;

    _view = [[UIView alloc] init];
    _view.backgroundColor = [UIColor redColor];

	_glView = [[GLKView alloc] init];
	_glView.delegate = self;
    _glView.drawableDepthFormat = GLKViewDrawableDepthFormat24;
    _glView.drawableStencilFormat = GLKViewDrawableStencilFormat8;

	_glView.backgroundColor = [UIColor greenColor];	
    [_view addSubview:_glView];

	_glView.translatesAutoresizingMaskIntoConstraints = false;
    [NSLayoutConstraint activateConstraints:@[
      [_glView.leadingAnchor constraintEqualToAnchor:_view.leadingAnchor],
      [_glView.topAnchor constraintEqualToAnchor:_view.topAnchor],
      [_glView.trailingAnchor constraintEqualToAnchor:_view.trailingAnchor],
	  [_glView.bottomAnchor constraintEqualToAnchor:_view.bottomAnchor],
    ]];
                 
    self.contentView = _view;

	_glView.context = [[EAGLContext alloc] initWithAPI:kEAGLRenderingAPIOpenGLES2]; 
	[EAGLContext setCurrentContext:_glView.context];

  	vg = init(width, height);
  }

  return self;
}

- (void)updateProps:(Props::Shared const &)props oldProps:(Props::Shared const &)oldProps
{
  const auto &oldViewProps = *std::static_pointer_cast<RTNDrawerProps const>(_props);
  const auto &newViewProps = *std::static_pointer_cast<RTNDrawerProps const>(props);

  if (oldViewProps.angle != newViewProps.angle) {
	rotation = newViewProps.angle;
	[_glView setNeedsDisplay];
  }

  [super updateProps:props oldProps:oldProps];
}

#pragma mark - GLKViewDelegate

- (void)glkView:(GLKView *)view drawInRect:(CGRect)rect {

    EAGLContext *context = [EAGLContext currentContext];
    [EAGLContext setCurrentContext:_glView.context];
    
	drawTriangle(vg, width, height, (float) rotation);
    
    [EAGLContext setCurrentContext:context];
}

@end

Class<RCTComponentViewProtocol> RTNDrawerCls(void)
{
  return RTNDrawer.class;
}


