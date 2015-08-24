package com.example.hp.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/*** Created by GBY9C3HL on 23/08/2015. */
public class SimpleBrowser extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simplebrowser);

        WebView webView = (WebView) findViewById(R.id.wvBrowser);
        webView.loadUrl("http://www.amrkhaled.net");
    }
}
