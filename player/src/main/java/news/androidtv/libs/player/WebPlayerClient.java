package news.androidtv.libs.player;

import android.os.Handler;
import android.os.Looper;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Nick on 10/27/2016.
 */

public class WebPlayerClient extends WebViewClient {
    private AbstractWebPlayer.WebEventsListener mListener;

    public WebPlayerClient(WebView webView, AbstractWebPlayer.WebEventsListener listener) {
        mListener = listener;
    }

    @Override
    public void onPageFinished(WebView v, String url) {
        super.onPageFinished(v, url);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                mListener.onWindowLoad();
            }
        }, 1000);
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url); // 在当前的webview中跳转到新的url
        //获取cookies
        CookieManager cm = CookieManager.getInstance();
        String cookies = cm.getCookie(url);
        AbstractWebPlayer.sp.edit().putString("cook", cookies).apply();
        return true;
    }

}
