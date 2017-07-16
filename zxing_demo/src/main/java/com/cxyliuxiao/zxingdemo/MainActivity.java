package com.cxyliuxiao.zxingdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cxyliuxiao.zxingdemo.base.BaseActivity;
import com.google.zxing.client.android.CaptureActivity;

public class MainActivity extends BaseActivity {

    public static final int REQUEST_CODE_SCAN = 1001;

    private Button scanBtn;
    private TextView scanTxt;
    private Button generatebtn;
    private ImageView generatedImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void initView() {
        super.initView();
        scanBtn = (Button) findViewById(R.id.btn_scan);
        generatebtn = (Button) findViewById(R.id.btn_generate);
        scanTxt = (TextView) findViewById(R.id.btn_scan);
        generatedImg = (ImageView) findViewById(R.id.img_generate);
    }

    @Override
    public void initEvent() {
        super.initEvent();
        scanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE_SCAN);
            }
        });
        generatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            
        }
    }
}
