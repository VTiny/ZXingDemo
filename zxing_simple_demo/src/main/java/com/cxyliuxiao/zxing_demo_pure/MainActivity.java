package com.cxyliuxiao.zxing_demo_pure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.zxing.client.android.CaptureActivity;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_SCAN = 1001;
    private Button scanBtn;
    private TextView scanResultTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scanBtn = (Button) findViewById(R.id.btn_scan);
        scanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE_SCAN);
            }
        });
        scanResultTxt = (TextView) findViewById(R.id.txt_scan_result);
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
