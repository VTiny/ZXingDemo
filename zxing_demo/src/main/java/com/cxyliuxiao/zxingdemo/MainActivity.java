package com.cxyliuxiao.zxingdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cxyliuxiao.zxingdemo.base.BaseActivity;
import com.google.zxing.client.android.CaptureActivity;
import com.google.zxing.client.android.Contents;
import com.google.zxing.client.android.Intents;
import com.google.zxing.client.android.encode.EncodeActivity;

public class MainActivity extends BaseActivity {

    public static final int REQUEST_CODE_SCAN = 1001;
    public static final int REQUEST_CODE_GENERATE = 1002;

    private Button scanBtn;
    private TextView scanResultTxt;
    private Button generatebtn;
    private ImageView generateResultImg;

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
        scanResultTxt = (TextView) findViewById(R.id.txt_scan_result);
        generateResultImg = (ImageView) findViewById(R.id.img_generate);
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
                Intent intent = new Intent(view.getContext(), EncodeActivity.class);
                intent.setAction(Intents.Encode.ACTION);
                intent.putExtra(Intents.Encode.TYPE, Contents.Type.TEXT);
                intent.putExtra(Intents.Encode.DATA, "asdfasdfads");
                startActivityForResult(intent, REQUEST_CODE_GENERATE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_CODE_SCAN:
                if (resultCode == RESULT_OK) {
                    String result = data.getStringExtra("scan_result");
                    scanResultTxt.setText(result);
                } else {
                    scanResultTxt.setText("error");
                }
                break;

        }
    }
}
