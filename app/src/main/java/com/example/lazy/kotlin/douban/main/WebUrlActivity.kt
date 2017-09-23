package com.example.lazy.kotlin.douban.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.lazy.kotlin.R
import kotlinx.android.synthetic.main.activity_web_url.*

class WebUrlActivity : AppCompatActivity() {
    companion object {
        val EXTRA_URL = "url"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_url)
        val url = intent.getStringExtra(EXTRA_URL)
        val settings = webView.settings
        settings.javaScriptEnabled = true
        webView.webViewClient = object : WebViewClient() {

            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }

        webView.webChromeClient = object : WebChromeClient() {

        }
        webView.loadUrl(url)
    }

}
