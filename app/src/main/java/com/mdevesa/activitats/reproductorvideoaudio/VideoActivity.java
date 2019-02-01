package com.mdevesa.activitats.reproductorvideoaudio;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity implements MediaController.MediaPlayerControl{
    Uri video;
    VideoView visor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        //Definir elementos en java
        ImageButton btn1 = (ImageButton) findViewById(R.id.video1Btn);
        ImageButton btn2 = (ImageButton) findViewById(R.id.video2Btn);
        visor = (VideoView) findViewById(R.id.videoView);


        //Els onClickListeners
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri video = Uri.parse("android.resource://" +getPackageName()+ "/" + R.raw.bcntimelapse);
                VideoView visor = (VideoView) findViewById(R.id.videoView);
                visor.setVideoURI(video);
                visor.setMediaController(new MediaController(VideoActivity.this));
                visor.start();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri video = Uri.parse("android.resource://" +getPackageName()+ "/" + R.raw.nyctimelapse);
                VideoView visor = (VideoView) findViewById(R.id.videoView);
                visor.setVideoURI(video);
                visor.setMediaController(new MediaController(VideoActivity.this));
                visor.start();
            }
        });
    }

    @Override
    public void start() {
        visor.start();
    }

    @Override
    public void pause() {
        visor.pause();
    }

    @Override
    public int getDuration() {
        return visor.getDuration();
    }

    @Override
    public int getCurrentPosition() {
        return visor.getCurrentPosition();
    }

    @Override
    public void seekTo(int pos) {
        visor.seekTo(pos);
    }

    @Override
    public boolean isPlaying() {
        return visor.isPlaying();
    }

    @Override
    public int getBufferPercentage() {
        return 0;
    }

    @Override
    public boolean canPause() {
        return true;
    }

    @Override
    public boolean canSeekBackward() {
        return false;
    }

    @Override
    public boolean canSeekForward() {
        return false;
    }

    @Override
    public int getAudioSessionId() {
        return 0;
    }

}
