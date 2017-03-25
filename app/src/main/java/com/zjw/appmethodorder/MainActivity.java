package com.zjw.appmethodorder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by 二精-霁雪清虹 on 2017/3/25.
 */

public class MainActivity extends BaseActivity implements View.OnClickListener {

    protected MyTextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    protected void onPause() {
        super.onPause();
    }


    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initView() {
        mTv = (MyTextView) findViewById(R.id.tv);
        mTv.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.tv) {
            Intent intent = new Intent();
            intent.setClass(this, SecondActivity.class);
            startActivity(intent);
        }
    }
}
