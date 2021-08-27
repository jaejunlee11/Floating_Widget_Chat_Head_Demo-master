package com.floatingwidgetchathead_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity2 extends AppCompatActivity {

    VideoView vv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        vv= findViewById(R.id.videoViewRelative);
        final Vibrator vib= (Vibrator) getSystemService(VIBRATOR_SERVICE);
        //Video Uri
//        Uri videoUri= Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.hearth);
        Uri videoUri= Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.test);


//        //비디오뷰의 재생, 일시정지 등을 할 수 있는 '컨트롤바'를 붙여주는 작업
//        vv.setMediaController(new MediaController(this));

        //VideoView가 보여줄 동영상의 경로 주소(Uri) 설정하기
        vv.setVideoURI(videoUri);

        //동영상을 읽어오는데 시간이 걸리므로..
        //비디오 로딩 준비가 끝났을 때 실행하도록..
        //리스너 설정
        vv.start();

        Handler handle=new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                vib.vibrate(500);
            }
        },1200);
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                vib.vibrate(500);
            }
        },2200);
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                vib.vibrate(500);
            }
        },3200);
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                vib.vibrate(500);
            }
        },4200);
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                vib.vibrate(500);
            }
        },5200);


        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
                finish();
            }
        },10500);


//        vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mediaPlayer) {
//                //비디오 시작
//                vv.start();
//            }
//        });
//vv.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//    @Override
//    public void onCompletion(MediaPlayer mediaPlayer) {
//        mediaPlayer.release();
//        vv.start();
//    }
//});
    }
    @Override
    protected void onPause() {
        super.onPause();

        //비디오 일시 정지
        if(vv!=null && vv.isPlaying()) vv.pause();
    }
    //액티비티가 메모리에서 사라질때..
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //
        if(vv!=null) vv.stopPlayback();
    }
}