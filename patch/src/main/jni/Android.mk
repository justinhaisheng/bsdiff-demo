LOCAL_PATH := $(call my-dir)


include $(CLEAR_VARS)
LOCAL_MODULE:= bspatch
LOCAL_SRC_FILES:= bspatch.c blocksort.c bzip2.c bzip2recover.c bzlib.c compress.c crctable.c decompress.c dlltest.c huffman.c mk251.c randtable.c spewG.c unzcrash.c
##-landroid参数 for native windows
LOCAL_LDLIBS := -llog  -lz -landroid
include $(BUILD_SHARED_LIBRARY)


