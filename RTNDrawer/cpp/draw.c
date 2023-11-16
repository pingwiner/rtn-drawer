#ifdef ANDROID_BUILD
#include <GLES2/gl2.h>
#include <GLES2/gl2ext.h>
#endif
#ifndef ANDROID_BUILD
#include <OpenGLES/ES2/glext.h>
#endif

#include "nanovg/nanovg.h"
#define NANOVG_GLES2_IMPLEMENTATION
#include "nanovg/nanovg_gl.h"
#include "nanovg/nanovg_gl_utils.h"

#include <math.h>


float len(int w, int h) {
    return sqrt(0.25f * w * w + 0.25f * h * h) * 0.5f;
}

float verticeX(int w, int h, float angle) {
    return w/2.0f + cos(nvgDegToRad(angle) ) * len(w, h);
}

float verticeY(int w, int h, float angle) {
    return h/2.0f - sin(nvgDegToRad(angle) ) * len(w, h);
}

NVGcontext* init(int width, int height) {
    NVGcontext* vg = nvgCreateGLES2(NVG_ANTIALIAS | NVG_STENCIL_STROKES | NVG_DEBUG);
    glViewport(0, 0, width, height);
    glClearColor(0.f, 0.f, 0.f, 0.f);
    glClear(GL_DEPTH_BUFFER_BIT | GL_COLOR_BUFFER_BIT | GL_STENCIL_BUFFER_BIT);
	return vg;
}

void drawTriangle(NVGcontext* vg, double width, double height, float angle) {
	glClearColor(0.f, 0.f, 0.f, 0.f);
    glClear( GL_DEPTH_BUFFER_BIT | GL_COLOR_BUFFER_BIT | GL_STENCIL_BUFFER_BIT);

    nvgBeginFrame(vg, width, height, width/height);
    nvgBeginPath(vg);
    nvgMoveTo(vg, verticeX(width, height, 90.f + angle), verticeY(width, height, 90.f + angle));
    nvgLineTo(vg, verticeX(width, height, 90.f + 120.0f + angle), verticeY(width, height, 90.0f + 120.0f + angle));
    nvgLineTo(vg, verticeX(width, height, 90.f + 240.f + angle), verticeY(width, height, 90.0f + 240.0f + angle));
    nvgClosePath(vg);
    nvgFillColor(vg, nvgRGBA(255,192,0,255));
    nvgFill(vg);
    nvgFillColor(vg, nvgRGBA(255,192,0,255));
    nvgEndFrame(vg);
}