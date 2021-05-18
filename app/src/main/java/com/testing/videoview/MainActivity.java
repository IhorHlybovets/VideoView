package com.testing.videoview;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private VideoView videoView;
    boolean isPlaying = true;
    int stopPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = (VideoView) findViewById(R.id.videoView);

        Uri video = Uri.parse("https://instagram.fiev9-1.fna.fbcdn.net/v/t50.2886-16/187504039_195453325759221_5613081090017499284_n.mp4?_nc_ht=instagram.fiev9-1.fna.fbcdn.net&_nc_cat=109&_nc_ohc=CcTlY4lm6boAX9vH5BI&edm=AABBvjUBAAAA&ccb=7-4&oe=60A634EF&oh=7e8c1b79400fb8c15dd6b3993ca7c04b&_nc_sid=83d603");
        videoView.setVideoURI(video);
        RelativeLayout relativeLayout = findViewById(R.id.pause);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPlaying) {
                    isPlaying = false;
                    stopPosition = videoView.getCurrentPosition();
                    Log.e("posit", stopPosition+"  ");
                    videoView.pause();
                } else {
                    isPlaying = true;
                    videoView.seekTo(stopPosition);
                    Log.e("posiqt", stopPosition+"  ");
                    videoView.start();
                }
            }
        });
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
                videoView.start();
            }
        });
    }
}