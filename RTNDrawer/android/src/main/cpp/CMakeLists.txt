cmake_minimum_required(VERSION 3.4.1)

add_compile_definitions(ANDROID_BUILD=1)

# now build app's shared lib
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11 -Wall")

add_library(gl2jni SHARED
            wrapper.cpp ../../../../cpp/nanovg/nanovg.c ../../../../cpp/draw.c)

# add lib dependencies
target_link_libraries(gl2jni
                      android
                      jnigraphics
                      log 
                      EGL
                      GLESv2)