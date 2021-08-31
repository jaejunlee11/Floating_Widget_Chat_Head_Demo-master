package com.floatingwidgetchathead_demo;


import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.media.Image;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintSet;

import java.util.Timer;
import java.util.TimerTask;

import static java.lang.Thread.sleep;

public class FlowerService extends Service {
    private TimerTask second;
    private TextView timer_text;
    private Handler handler = new Handler();
    Handler handle=new Handler();
    int timer_sec = 0;
    int count = 0;
    WindowManager wm;
    private View mView;
    private View mView1;
    private View mView2;
    private View mView3;
    private View mView4;
    private View mView5;
    Timer timer = new Timer();
    protected void Update() {
        Runnable updater = new Runnable() {
            public void run() {
                Toast.makeText(getApplicationContext(),timer_sec + "초 사용" , Toast.LENGTH_SHORT).show();
                if(((AksApplication) getApplicationContext()).getId()==1){

                }

            }
        };
        handler.post(updater);
    }
    public void testStart() {
        second = new TimerTask() {
            @Override
            public void run() {
                Log.i("Test", "Timer start"+timer_sec);
                Update();
                timer_sec++;
//                if(timer_sec%10==0){
//                    mView.setVisibility(View.GONE);
//                }
                if(count==1){
                    second.cancel();
                }

            }
        };
        timer.schedule(second, 0, 1000);

    }

    @Override
    public IBinder onBind(Intent intent) { return null; }

    @Override
    public void onCreate() {
        super.onCreate();
        //시간 측정기
        testStart();



        LayoutInflater inflate = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        wm = (WindowManager) getSystemService(WINDOW_SERVICE);

        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                /*ViewGroup.LayoutParams.MATCH_PARENT*/300,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY, //여기 수정필요
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                        |WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                        |WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH,
                PixelFormat.TRANSLUCENT);

        params.gravity = Gravity.LEFT ;
        mView = inflate.inflate(R.layout.view_in, null);
        final ImageButton bt =  (ImageButton) mView.findViewById(R.id.bt);


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.cut);
                final ImageView iv = (ImageView) mView.findViewById(R.id.bt);
                iv.startAnimation(anim);

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mView.setVisibility(View.GONE);
                        }
                    },3000);
            }
        });
        wm.addView(mView, params);



        params.gravity = Gravity.RIGHT | Gravity.BOTTOM ;
        mView1 = inflate.inflate(R.layout.view_in_r, null);
        final ImageButton bt1 =  (ImageButton) mView1.findViewById(R.id.bt);


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.cut);
                final ImageView iv = (ImageView) mView1.findViewById(R.id.bt);
                iv.startAnimation(anim);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mView1.setVisibility(View.GONE);
                    }
                },3000);
            }
        });
        wm.addView(mView1, params);

        params.gravity = Gravity.RIGHT  ;
        mView2 = inflate.inflate(R.layout.view_in_r, null);
        final ImageButton bt2 =  (ImageButton) mView2.findViewById(R.id.bt);


        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.cut);
                final ImageView iv = (ImageView) mView2.findViewById(R.id.bt);
                iv.startAnimation(anim);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mView2.setVisibility(View.GONE);
                    }
                },3000);
            }
        });
        wm.addView(mView2, params);

        params.gravity = Gravity.LEFT |Gravity.BOTTOM  ;
        mView3 = inflate.inflate(R.layout.view_in, null);
        final ImageButton bt3 =  (ImageButton) mView3.findViewById(R.id.bt);


        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.cut);
                final ImageView iv = (ImageView) mView3.findViewById(R.id.bt);
                iv.startAnimation(anim);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mView3.setVisibility(View.GONE);
                    }
                },3000);
            }
        });
        wm.addView(mView3, params);

        params.gravity = Gravity.LEFT | Gravity.TOP  ;
        mView4 = inflate.inflate(R.layout.view_in, null);
        final ImageButton bt4 =  (ImageButton) mView4.findViewById(R.id.bt);


        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.cut);
                final ImageView iv = (ImageView) mView4.findViewById(R.id.bt);
                iv.startAnimation(anim);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mView4.setVisibility(View.GONE);
                    }
                },3000);
            }
        });
        wm.addView(mView4, params);

        params.gravity = Gravity.RIGHT |Gravity.TOP  ;
        mView5 = inflate.inflate(R.layout.view_in_r, null);
        final ImageButton bt5=  (ImageButton) mView5.findViewById(R.id.bt);


        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.cut);
                final ImageView iv = (ImageView) mView5.findViewById(R.id.bt);
                iv.startAnimation(anim);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mView5.setVisibility(View.GONE);
                    }
                },3000);
            }
        });
        wm.addView(mView5, params);
        mView.setVisibility(View.GONE);
        mView1.setVisibility(View.GONE);
        mView2.setVisibility(View.GONE);
        mView3.setVisibility(View.GONE);
        mView4.setVisibility(View.GONE);
        mView5.setVisibility(View.GONE);

        for(int i=1;i<1000;i++){
            if(i==2){
                handle.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Animation anim=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.make);
                        final ImageView iv = (ImageView) mView.findViewById(R.id.bt);
                        iv.startAnimation(anim);
                        mView.setVisibility(View.VISIBLE);
                    }
                },10000*i);
            }else if(i==4){
                handle.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Animation anim=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.make);
                        final ImageView iv = (ImageView) mView4.findViewById(R.id.bt);
                        final ImageView iv1 = (ImageView) mView1.findViewById(R.id.bt);
                        iv.startAnimation(anim);
                        iv1.startAnimation(anim);

                        mView4.setVisibility(View.VISIBLE);
                        mView1.setVisibility(View.VISIBLE);
                    }
                },10000*i);
            }else if(i==6){
                handle.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Animation anim=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.make);
                        final ImageView iv = (ImageView) mView5.findViewById(R.id.bt);
                        final ImageView iv1 = (ImageView) mView3.findViewById(R.id.bt);
                        final ImageView iv2 = (ImageView) mView2.findViewById(R.id.bt);
                        iv.startAnimation(anim);
                        iv1.startAnimation(anim);
                        iv2.startAnimation(anim);

                        mView5.setVisibility(View.VISIBLE);
                        mView3.setVisibility(View.VISIBLE);
                        mView2.setVisibility(View.VISIBLE);
                    }
                },10000*i);
            }else if(i==8){
                handle.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Animation anim=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.make);
                        final ImageView iv = (ImageView) mView.findViewById(R.id.bt);
                        final ImageView iv1 = (ImageView) mView1.findViewById(R.id.bt);
                        final ImageView iv2 = (ImageView) mView2.findViewById(R.id.bt);
                        final ImageView iv3 = (ImageView) mView4.findViewById(R.id.bt);
                        iv.startAnimation(anim);
                        iv1.startAnimation(anim);
                        iv2.startAnimation(anim);
                        iv3.startAnimation(anim);

                        mView.setVisibility(View.VISIBLE);
                        mView1.setVisibility(View.VISIBLE);
                        mView4.setVisibility(View.VISIBLE);
                        mView2.setVisibility(View.VISIBLE);
                    }
                },10000*i);

            }else if(i==10){
                handle.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Animation anim=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.make);
                        final ImageView iv = (ImageView) mView5.findViewById(R.id.bt);
                        final ImageView iv1 = (ImageView) mView1.findViewById(R.id.bt);
                        final ImageView iv2 = (ImageView) mView2.findViewById(R.id.bt);
                        final ImageView iv3 = (ImageView) mView3.findViewById(R.id.bt);
                        final ImageView iv4 = (ImageView) mView4.findViewById(R.id.bt);
                        iv.startAnimation(anim);
                        iv1.startAnimation(anim);
                        iv2.startAnimation(anim);
                        iv3.startAnimation(anim);
                        iv4.startAnimation(anim);

                        mView5.setVisibility(View.VISIBLE);
                        mView1.setVisibility(View.VISIBLE);
                        mView2.setVisibility(View.VISIBLE);
                        mView3.setVisibility(View.VISIBLE);
                        mView4.setVisibility(View.VISIBLE);
                    }
                },10000*i);

            }else if(i>=12){
                handle.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Animation anim=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.make);
                        final ImageView iv = (ImageView) mView5.findViewById(R.id.bt);
                        final ImageView iv1 = (ImageView) mView1.findViewById(R.id.bt);
                        final ImageView iv2 = (ImageView) mView2.findViewById(R.id.bt);
                        final ImageView iv3 = (ImageView) mView3.findViewById(R.id.bt);
                        final ImageView iv4 = (ImageView) mView4.findViewById(R.id.bt);
                        final ImageView iv5 = (ImageView) mView.findViewById(R.id.bt);
                        iv.startAnimation(anim);
                        iv1.startAnimation(anim);
                        iv2.startAnimation(anim);
                        iv3.startAnimation(anim);
                        iv4.startAnimation(anim);
                        iv5.startAnimation(anim);

                        mView.setVisibility(View.VISIBLE);
                        mView1.setVisibility(View.VISIBLE);
                        mView2.setVisibility(View.VISIBLE);
                        mView3.setVisibility(View.VISIBLE);
                        mView4.setVisibility(View.VISIBLE);
                        mView5.setVisibility(View.VISIBLE);
                    }
                },10000*i);

            }

        }

//        public static void main(String[] args) {
//            HangeulClock hangeulClock = new HangeulClock();
//            Timer scheduler = new Timer();
//            TimerTask task = new TimerTask() {
//                @Override
//                public void run() {
//                    String[][] clockResult = hangeulClock.showHourMinute();
//                    hangeulClock.printHangeulClock(clockResult);
//                }
//            };
//            scheduler.scheduleAtFixedRate(task, 1000, 60000); // 1초 뒤 1분마다 반복실행
//        }






    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeMessages(0);
        handle.removeMessages(0);
        mView.setVisibility(View.GONE);
        mView1.setVisibility(View.GONE);
        mView2.setVisibility(View.GONE);
        mView3.setVisibility(View.GONE);
        mView4.setVisibility(View.GONE);
        mView5.setVisibility(View.GONE);
        timer.cancel();
//        if(wm != null) {
//            if(mView != null) {
//                wm.removeView(mView);
//                mView = null;
//            }
//            wm = null;
//        }
        //지우면 영원히 안없어짐 이걸 응용해봐야 할듯?
    }
}