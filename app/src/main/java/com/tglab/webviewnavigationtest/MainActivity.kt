package com.tglab.webviewnavigationtest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import java.nio.charset.StandardCharsets.UTF_8

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

        val html = this.assets.open("kambi.html").bufferedReader().use { it.readText() }


        webview.loadDataWithBaseURL(
            "https://scooore.be",
            html,
            "text/html",
            UTF_8.name(),
            null
        )
    }

    private fun createWebClient() =
        object : WebViewClient() {
        }
}