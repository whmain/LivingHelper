package com.ahern.livinghelper.recreation.turingchat.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.ahern.livinghelper.R;
import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ChatWebActivity extends AppCompatActivity {

    @BindView(R.id.web_view_chat)
    WebView mWebView;
    @BindView(R.id.toolbar_chat_web)
    Toolbar mToolbar;

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_web);
        unbinder = ButterKnife.bind(this);
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.color_tabbar_default), 0);

        initView();
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        initWebview(url);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    public void initView(){
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(mClickListener);
//                去掉默认title
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

    }

    private void initWebview(String url) {
        mWebView.setWebViewClient(new MyWebViewClient());
        mWebView.loadUrl(url);
    }

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ChatWebActivity.this.finish();
        }
    };

    /**
     * 按键响应，在WebView中查看网页时，按返回键的时候按浏览历史退回,如果不做此项处理则整个WebView返回退出
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Check if the key event was the Back button and if there's history
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
            /*
             * 　canGoBack() 方法在网页可以后退时返回true。
             * 　类似的，canGoForward()方法可以检查是否有可以前进的历史记录。
             */
            // 这个是前进
            // myWebView.goForward();
            // 返回键退回
            mWebView.goBack();
            return true;
        }
        // If it wasn't the Back key or there's no web page history, bubble up
        // to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }


    private class MyWebViewClient extends WebViewClient {
        private final String TAG = MyWebViewClient.class.getSimpleName();

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.e(TAG, url + "  getHost:" + Uri.parse(url).getHost());
            if (Uri.parse(url).getHost().equals("m.baidu.com")) {
                // This is my web site, so do not override; let my WebView load
                // the page。在webview中加载网页
                return false;
            }
            // Otherwise, the link is not for a page on my site, so launch
            // another Activity that handles URLs.使用浏览器加载网页
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
            return true;
        }
    }
}
