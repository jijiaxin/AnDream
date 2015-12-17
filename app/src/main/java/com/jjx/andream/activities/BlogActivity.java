package com.jjx.andream.activities;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.jjx.andream.R;

public class BlogActivity extends BaseActivity {

    CollapsingToolbarLayout collapsingToolbarLayout;
    WebView webView;
    String url = "http://jijiaxin89.com/2015/09/02/NalanCangyang/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolBar();
        initview();
    }

    private void initview() {
        webView = (WebView) findViewById(R.id.webview_blog);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webView.setHorizontalScrollBarEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDefaultTextEncodingName("UTF-8");
        webView.setHorizontalScrollbarOverlay(true);

        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);

        webView.loadUrl(url);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                super.onReceivedSslError(view, handler, error);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        webView.setWebChromeClient(new WebChromeClient() {

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                //TODO:此处不理想，测试环境80都经常收不到回调，经常卡在50，暂时先70再观察吧
                if (newProgress >= 70) {
//                    setLoadingLayoutVisibility(false);
                }
                super.onProgressChanged(view, newProgress);
            }
        });
    }

    @Override
    public void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setTitle("微凉一季’s Blog");
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getString(R.string.activity_blog_title));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_blog;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_blog, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            webView.loadUrl("http://www.jijiaxin89.com");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
        } else {
            finish();
            setResult(RESULT_OK);
        }
        return true;
    }
}
