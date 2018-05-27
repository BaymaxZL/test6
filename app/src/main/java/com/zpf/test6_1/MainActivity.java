package com.zpf.test6_1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.URISyntaxException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText urlText;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        urlText = findViewById(R.id.urlText);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == btn.getId()) {
            String url = urlText.getText().toString();
            //Intent intent = new Intent(Intent.ACTION_VIEW);    //为Intent设置Action属性
            Intent intent = null;
            try {
                /*intent =  new Intent("android.intent.action.VIEW2", Uri.parse(url));

                //intent.setAction(Intent.ACTION_VIEW);
               // intent.setData(Uri.parse(url)); //为Intent设置DATA属性　　
                intent.addCategory("android.intent.category.DEFAULT");
                intent.addCategory("android.intent.category.BROWSABLE");*/

                Uri uri=Uri.parse(url);
                intent = new Intent(Intent.ACTION_VIEW,uri);

                /*intent = new Intent();
                intent.setAction("com.demoBActivity.action");
                intent.addCategory("android.intent.category.DEFAULT");*/
                startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
