package com.example.portfolio_app

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class WebViewActivity : AppCompatActivity() {
    
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        val url = intent.getStringExtra("EXTRA_URL") ?: "https://www.google.com"
        
        val webView = findViewById<WebView>(R.id.webView)
        webView.webViewClient = WebViewClient() // Keeps navigation inside the app
        webView.webChromeClient = android.webkit.WebChromeClient() // Better media handling
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.loadUrl(url)
    }
}
