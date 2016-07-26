package com.example.student.myweb;

import android.content.Context;
import android.content.Intent;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class WebAppInterface{
    Context mContext;

    WebAppInterface (Context c){
        mContext=c;
    }
    @JavascriptInterface
    public void showToast(String toast){
        toast=" change hi";
        Toast.makeText(mContext,toast,Toast.LENGTH_SHORT).show();

    }






}
