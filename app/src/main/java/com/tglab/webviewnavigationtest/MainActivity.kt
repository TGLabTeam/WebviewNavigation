package com.tglab.webviewnavigationtest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val webview = findViewById<WebView>(R.id.webView)
        webview.settings.javaScriptEnabled = true
        webview.settings.domStorageEnabled = true
        webview.settings.cacheMode = WebSettings.LOAD_NO_CACHE
        WebView.setWebContentsDebuggingEnabled(true)

        webview.webViewClient = createWebClient()

        webview.loadUrl("https://google.com")
    }

    private fun createWebClient() =
        object : WebViewClient() {
        }
}