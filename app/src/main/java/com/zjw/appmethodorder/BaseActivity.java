package com.zjw.appmethodorder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by 二精-霁雪清虹 on 2017/3/25.
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        baseOnCreate();
    }


    @Override
    protected void onResume() {
        super.onResume();
        baseOnResume();
    }


    @Override
    protected void onPause() {
        super.onPause();
        baseOnPause();
    }


    @Override
    protected void onStop() {
        super.onStop();
        baseOnStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        baseOnDestroy();
    }


    private void baseOnCreate() {
        System.out.println();
    }

    private void baseOnResume() {
        System.out.println("");
    }


    private void baseOnPause() {
        System.out.println();
    }

    private void baseOnStop() {
        System.out.println();
    }

    private void baseOnDestroy() {
        System.out.println();
    }
}
