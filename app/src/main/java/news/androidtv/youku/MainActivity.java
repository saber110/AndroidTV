package news.androidtv.youku;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;

import news.androidtv.libs.player.YouTubePlayerView;

/**
 * Created by Nick on 10/27/2016.
 */
public class MainActivity extends Activity {
    private YouTubePlayerView mPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_youtube);
        mPlayer = ((YouTubePlayerView) findViewById(R.id.player_youtube));
        mPlayer.loadVideo(this,"kjEmkdrdRtI", getString(R.string.website_url));
//        mPlayer.registerCallback(new TvPlayer.Callback() {
//            @Override
//            public void onCompleted() {
//                super.onCompleted();
//                mPlayer.loadVideo("kjEmkdrdRtI");
//            }
//        });

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == android.view.KeyEvent.KEYCODE_BACK && mPlayer.canGoBack()) {
            mPlayer.goBack();// 返回前一个页面
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
