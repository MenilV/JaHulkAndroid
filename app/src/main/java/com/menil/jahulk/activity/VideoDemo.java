package com.menil.jahulk.activity;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.menil.jahulk.R;

/**
 * Created by Menil V. on 22.1.2016 at com.menil.jahulk.activity.
 */
public class VideoDemo extends Activity {

    private static final String path ="http://videocdn.bodybuilding.com/video/mp4/38000/38091m.mp4";
    private VideoView video;
    private MediaController ctlr;
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        setContentView(R.layout.videoview);

        video = (VideoView) findViewById(R.id.video);
        video.setVideoPath(path);

        ctlr = new MediaController(this);
        ctlr.setMediaPlayer(video);
        video.setMediaController(ctlr);
        video.requestFocus();
        video.start();
    }
}
