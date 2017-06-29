package com.xxh.thinkertest;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.tencent.tinker.lib.tinker.TinkerInstaller;

import java.io.File;

/**
 * Tinker 的使用初体验
 */

public class MainActivity extends AppCompatActivity {

    private TextView test_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test_main = (TextView) findViewById(R.id.test_main);

        test_main.setText("I am In Path Apk");
    }

    public void loadPath(View view) {
        String path = Environment.getExternalStoragePublicDirectory(DOWNLOAD_SERVICE).getAbsolutePath() + "/patch_signed_7zip.apk";
        File file = new File(path);
        if (file.exists()) {
            Toast.makeText(this, "补丁存在", Toast.LENGTH_SHORT).show();
            TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(), path);
        } else {
            Toast.makeText(this, "补丁不存在", Toast.LENGTH_SHORT).show();
        }
    }
}
