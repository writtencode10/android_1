package com.example.testnew1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView w1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        w1=findViewById(R.id.w1);
        w1.loadUrl("https://www.google.com/");
        WebSettings ws=w1.getSettings();
        ws.setJavaScriptEnabled(true);
        w1.setWebViewClient(new WebViewClient());

    }

    @Override
    public void onBackPressed() {
        if(w1.canGoBack())
        {
            w1.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
}
