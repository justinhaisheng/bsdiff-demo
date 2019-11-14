package com.aispeech.patch;

/**
 * @创建者 luhaisheng
 * @创建时间 2019/11/14 20:17
 * @描述 ${TOO}
 */
public class PathUtil {


    /**
     * 合并
     *
     * @param oldfile
     * @param newfile
     * @param patchfile
     */
    public native static void patch(String oldfile, String newfile, String patchfile);

    static{
        System.loadLibrary("bspatch");
    }

}
