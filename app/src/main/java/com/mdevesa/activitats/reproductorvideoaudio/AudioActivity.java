package com.mdevesa.activitats.reproductorvideoaudio;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;

public class AudioActivity extends AppCompatActivity implements MediaController.MediaPlayerControl{

    MediaController controls;
    MediaPlayer so;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        //Definir elementos en java
        ImageButton btn1 = (ImageButton) findViewById(R.id.audio1Btn);
        ImageButton btn2 = (ImageButton) findViewById(R.id.audio2Btn);
        ImageButton btn3 = (ImageButton) findViewById(R.id.melodyBtn);
        view = (View) findViewById(R.id.audioControllerView);



        //Els onClickListeners
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                so = MediaPlayer.create(AudioActivity.this,R.raw.marimba);
                so.start();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                so = MediaPlayer.create(AudioActivity.this,R.raw.africantribalcircle);
                so.start();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                so = MediaPlayer.create(AudioActivity.this,R.raw.ritmicmelody);

                //Media player control para la tercera melodia
                controls = new MediaController(AudioActivity.this);
                controls.setMediaPlayer(AudioActivity.this);
                controls.setAnchorView(view);
                so.start();
            }
        });
    }

    @Override
    public void start() {
        so.start();
    }

    @Override
    public void pause() {
        so.pause();
    }

    @Override
    public int getDuration() {
        return so.getDuration();
    }

    @Override
    public int getCurrentPosition() {
        return so.getCurrentPosition();
    }

    @Override
    public void seekTo(int pos) {
        so.seekTo(pos);
    }

    @Override
    public boolean isPlaying() {
        return so.isPlaying();
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
        return true;
    }

    @Override
    public boolean canSeekForward() {
        return true;
    }

    @Override
    public int getAudioSessionId() {
        return 0;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        controls.show();
        return false;
    }
}
