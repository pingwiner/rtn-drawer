cmake_minimum_required(VERSION 3.9.0)
set(CMAKE_VERBOSE_MAKEFILE ON)
set(CMAKE_CXX_STANDARD 17)

add_library(
	cpp
	SHARED
	../cpp/rnjsisample.cpp
	./cpp-adapter.cpp
)

include_directories(
            ../../react-native/React
            ../../react-native/React/Base
            ../../react-native/ReactCommon/jsi
            ../cpp
)

set_target_properties(
        cpp PROPERTIES
        CXX_STANDARD 17
        CXX_EXTENSIONS OFF
        POSITION_INDEPENDENT_CODE ON
)

add_library(jsi
        ../../react-native/ReactCommon/jsi/jsi/jsi.cpp)



target_link_libraries(
        cpp
        android
        jsi 
)


