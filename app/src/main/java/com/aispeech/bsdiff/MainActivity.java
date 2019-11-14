package com.aispeech.bsdiff;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.aispeech.bsdiff.utils.ApkUtils;
import com.aispeech.diff.DiffUtil;
import com.aispeech.patch.PathUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this, "zhe is new ", Toast.LENGTH_SHORT).show();
    }

    String old = "/sdcard/app-old.apk";
    String new1 = "/sdcard/app-new.apk";
    String patch = "/sdcard/app.patch";
    public void diff(View view){
        DiffUtil diffUtil = new DiffUtil();
        diffUtil.diff(old,new1,patch);
    }
    String target = "/sdcard/app-target.apk";
    public void patch(View view){
        //PathUtil.patch();
        //Toast.makeText(MainActivity.this, "patch patch patch", Toast.LENGTH_SHORT).show();
        new ApkUpdateTask().execute();
    }

    class ApkUpdateTask extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Void... params) {
            try {
                //1.下载差分包
                Log.d("jason", "开始下载");
                //File patchFile = DownloadUtils.download(Constants.URL_PATCH_DOWNLOAD);

                //获取当前应用的apk文件/data/app/app
                String oldfile = ApkUtils.getSourceApkPath(MainActivity.this, getPackageName());
                //2.合并得到最新版本的APK文件
                String newfile = target;
                String patchfile = patch;
                PathUtil.patch(old, newfile, patchfile);

                Log.d("jason", "oldfile:"+old);
                Log.d("jason", "newfile:"+newfile);
                Log.d("jason", "patchfile:"+patchfile);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }

            return true;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);
            //3.安装
            if(result){
                Toast.makeText(MainActivity.this, "您正在进行无流量更新", Toast.LENGTH_SHORT).show();
                ApkUtils.installApk(MainActivity.this, target);
            }
        }

    }
}
