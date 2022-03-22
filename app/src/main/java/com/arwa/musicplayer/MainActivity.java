package com.arwa.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button play, pause, stop;
    MediaPlayer mediaPlayer;
    int current;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = (Button) findViewById(R.id.btn_play);
        pause = (Button) findViewById(R.id.btn_pause);
        stop = (Button) findViewById(R.id.btn_stop);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_play:
                if (mediaPlayer == null) {
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.tune);
                    mediaPlayer.start();
                    Toast.makeText(MainActivity.this,"Playing Sound", Toast.LENGTH_SHORT).show();
                } else if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.seekTo(current);
                    mediaPlayer.start();
                    Toast.makeText(MainActivity.this,"Playing Sound", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btn_pause:
                if (mediaPlayer != null) {
                    mediaPlayer.pause();
                    current = mediaPlayer.getCurrentPosition();
                    Toast.makeText(MainActivity.this,"Sound Pause", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btn_stop:
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer = null;
                    Toast.makeText(MainActivity.this,"Sound Stop", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}

