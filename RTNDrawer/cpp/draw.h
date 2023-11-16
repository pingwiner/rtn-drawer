#ifndef __DRAW_H__
#define __DRAW_H__

#include "nanovg/nanovg.h"

extern "C" {

  void drawTriangle(NVGcontext* vg, double width, double height, float angle);
  NVGcontext* init(int width, int height);

}
#endif