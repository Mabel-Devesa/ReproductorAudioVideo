package com.mdevesa.activitats.reproductorvideoaudio;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton videoBtn;
    ImageButton audioBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Elements del layout
        videoBtn = (ImageButton) findViewById(R.id.videoButton);
        audioBtn = (ImageButton) findViewById(R.id.audioButton);


        //Els onClicks per a cada boto i envia un intent
        videoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent videoIntent = new Intent(MainActivity.this,VideoActivity.class);
                startActivity(videoIntent);
            }
        });

        audioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent audioIntent = new Intent(MainActivity.this, AudioActivity.class);
                startActivity(audioIntent);
            }
        });

    }
}
