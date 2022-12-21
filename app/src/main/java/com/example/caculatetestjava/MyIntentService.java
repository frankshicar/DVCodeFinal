package com.example.caculatetestjava;

import android.app.IntentService;
import android.content.Intent;
import android.media.MediaPlayer;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class MyIntentService extends IntentService {

    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    public static final String ACTION_FOO = "com.example.caculatetestjava.action.FOO";
    public static final String ACTION_BAZ = "com.example.caculatetestjava.action.BAZ";

    public static final String ACTION_MUSIC = "com.example.zouqi.bgmusicdemo.action.musicd";

    // TODO: Rename parameters
    public static final String EXTRA_PARAM1 = "com.example.caculatetestjava.extra.PARAM1";
    public static final String EXTRA_PARAM2 = "com.example.caculatetestjava.extra.PARAM2";

    private MediaPlayer mediaPlayer;
    public  MyIntentService(){
        super("myIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_FOO.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionFoo(param1, param2);
            } else if (ACTION_BAZ.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionBaz(param1, param2);
            }

            if(ACTION_MUSIC.equals(action)){
                handleActionMusic();
            }
        }
    }

    private void handleActionMusic(){

        if(mediaPlayer == null){
            mediaPlayer = MediaPlayer.create(this,R.raw.backgroundmusic);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
        }
    }
    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo(String param1, String param2) {
        // TODO: Handle action Foo
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }
}