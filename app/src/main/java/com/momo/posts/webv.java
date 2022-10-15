package com.momo.posts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.momo.posts.databinding.ActivityWebvBinding;

public class webv extends AppCompatActivity {
    ActivityWebvBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityWebvBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.webv.setWebViewClient(new WebViewClient());
        binding.webv.loadUrl(getIntent().getStringExtra("url"));
        WebSettings webSettings=binding.webv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.getAllowContentAccess();
    }

    @Override
    public void onBackPressed() {
        if(binding.webv.canGoBack())
        binding.webv.goBack();
        else{
        super.onBackPressed();

        }
  }
}