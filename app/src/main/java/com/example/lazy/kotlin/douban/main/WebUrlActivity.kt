package com.example.lazy.kotlin.douban.main

import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.lazy.kotlin.R
import kotlinx.android.synthetic.main.activity_web_url.*


class WebUrlActivity : AppCompatActivity() {
    companion object {
        val EXTRA_URL = "url"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_url)
//        val url = intent.getStringExtra(EXTRA_URL)
        val url = "https://mp.weixin.qq.com/s?__biz=MjM5OTk0Njk3NA==&mid=400910881&idx=2&sn=6b633b0265e96b47f2d9f1f2aaed78e8#rd"
        val settings = webView.settings
        settings.javaScriptEnabled = true
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            WebView.setWebContentsDebuggingEnabled(true);
//        }
        webView.webViewClient = object : WebViewClient() {

            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url!!)
                return true
            }
        }

        webView.webChromeClient = object : WebChromeClient() {

        }
        webView.loadUrl(url)
    }

}
