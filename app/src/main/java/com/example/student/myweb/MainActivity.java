package com.example.student.myweb;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

WebView mb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         mb= (WebView) findViewById(R.id.myweb);

        mb.getSettings().setBuiltInZoomControls(true);
        mb.getSettings().setSupportZoom(true);
        mb.setWebViewClient(new WebViewClient());
        mb.loadUrl("file:///android_asset/web-robot-master/index.html");
        mb.getSettings().setJavaScriptEnabled(true);

        mb.addJavascriptInterface(new WebAppInterface(this),"Android");
        mb.addJavascriptInterface(new MainAppInterface(),"hihi");


    }

    @Override
    public void onBackPressed() {
        if(mb.getUrl().contains("index.html")) {
            super.onBackPressed();
        }
        else{
            mb.goBack();
        }
    }


    public class MainAppInterface{
        Context mContext;

        MainAppInterface (){

        }


        @JavascriptInterface
        public void hihi(){
            Intent it=new Intent(MainActivity.this, Main2Activity.class);
            startActivity(it);

        }

    }



}
