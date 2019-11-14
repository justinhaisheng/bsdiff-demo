LOCAL_PATH := $(call my-dir)


include $(CLEAR_VARS)
LOCAL_MODULE:= bsdiff
LOCAL_SRC_FILES:= bsdiff.c blocksort.c bzlib.c compress.c crctable.c decompress.c huffman.c randtable.c
##-landroid参数 for native windows
LOCAL_LDLIBS := -llog  -lz -landroid
include $(BUILD_SHARED_LIBRARY)


