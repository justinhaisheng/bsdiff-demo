package com.aispeech.diff;

/**
 * @创建者 luhaisheng
 * @创建时间 2019/11/14 19:44
 * @描述 ${TOO}
 */
public class DiffUtil {

    static {
        System.loadLibrary("bsdiff");
    }

    public native void diff(String oldfile,String newfile,String pathchfile);


}
