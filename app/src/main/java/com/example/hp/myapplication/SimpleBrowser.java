package com.example.hp.myapplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

/*** Created by GBY9C3HL on 23/08/2015. */
public class SimpleBrowser extends Activity implements View.OnClickListener {

    WebView webView;
    EditText url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simplebrowser);

        webView = (WebView) findViewById(R.id.wvBrowser);
        // Enable JavaScripts to run
        webView.getSettings().setJavaScriptEnabled(true);
        // Zoom out the content to fit screen by width
        webView.getSettings().setLoadWithOverviewMode(true);
        // Enable support for the 'viewport' HTML meta tag, like a normal desktop browser
        webView.getSettings().setUseWideViewPort(true);

        // View URLs through my WebView; not through the default browser.
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }
        });

        try {
            webView.loadUrl("http://www.MohammadNassar.tumblr.com");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Button go = (Button) findViewById(R.id.bGo);
        Button back = (Button) findViewById(R.id.bBack);
        Button forward = (Button) findViewById(R.id.bForward);
        Button refresh = (Button) findViewById(R.id.bRefresh);
        Button clearHistory = (Button) findViewById(R.id.bClear);
        url = (EditText) findViewById(R.id.etURL);

        go.setOnClickListener(this);
        back.setOnClickListener(this);
        forward.setOnClickListener(this);
        refresh.setOnClickListener(this);
        clearHistory.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.bGo :
                String urlToVisit = url.getText().toString();
                webView.loadUrl(urlToVisit);
                break;
            case R.id.bBack :
                if (webView.canGoBack())
                    webView.goBack();
                break;
            case R.id.bForward :
                if (webView.canGoForward())
                    webView.goForward();
                break;
            case R.id.bRefresh :
                webView.reload();
                break;
            case R.id.bClear :
                webView.clearHistory();
                break;
        }
    }
}
