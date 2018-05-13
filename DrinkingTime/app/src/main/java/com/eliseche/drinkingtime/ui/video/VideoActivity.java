package com.eliseche.drinkingtime.ui.video;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.eliseche.drinkingtime.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_video)
public class VideoActivity extends AppCompatActivity {
    @Extra
    String videoUrl;

    @ViewById(R.id.activity_video_videoview)
    VideoView videoView;

    @AfterViews
    void afterViews() {
        loadVideo();
    }

    private void loadVideo() {
        try {
            videoView.setVideoURI(Uri.parse(videoUrl));
            videoView.setMediaController(new MediaController(this));
            videoView.requestFocus();
            videoView.start();
        } catch (Exception e) {
            Log.e(getClass().getName(), e.getMessage(), e);
            Toast.makeText(getBaseContext(), getResources().getString(R.string.video_error), Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
