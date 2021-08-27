package com.floatingwidgetchathead_demo;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import android.util.Log;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobManager;
import com.evernote.android.job.JobRequest;

import java.util.concurrent.TimeUnit;


public class LockScreenJob extends Job {

    private static final String TAG = LockScreenJob.class.getSimpleName();

    public static final String TAG_P = "periodic_job_tag";
    public static final String TAG_I = "immediate_job_tag";

    //Used static refrence of broadcast receiver for ensuring if it's already register or not NULL
    // then first unregister it and set to null before registering it again.
    public static UnlockReceiver aks_Receiver = null;

    @Override
    @NonNull
    protected Result onRunJob(Params params) {
        // run your job here

        String jobTag = params.getTag();

        if (BuildConfig.DEBUG) {
            Log.i(TAG, "Job started! " + jobTag);
        }

        PowerManager pm = (PowerManager) getContext().getSystemService(Context.POWER_SERVICE);

        boolean isInteractive = false;
        // Here we check current status of device screen, If it's Interactive then device screen is ON.
        if (Build.VERSION.SDK_INT >= 20) {
            isInteractive = pm.isInteractive();
        } else {
            isInteractive = pm.isScreenOn();
        }

        try {
            if (aks_Receiver != null) {
                getContext().getApplicationContext().unregisterReceiver(aks_Receiver); //Use 'Application Context'.
            }
        } catch (Exception e) {
            if (BuildConfig.DEBUG) {
                e.printStackTrace();
            }
        } finally {
            aks_Receiver = null;
        }

        try {
            //Register receiver for listen "SCREEN_OFF" and "SCREEN_ON" action.

            IntentFilter filter = new IntentFilter("android.intent.action.SCREEN_OFF");
            filter.addAction("android.intent.action.SCREEN_ON");
            aks_Receiver = new UnlockReceiver();
            getContext().getApplicationContext().registerReceiver(aks_Receiver, filter); //use 'Application context' for listen brodcast in background while app is not running, otherwise it may throw an exception.
        } catch (Exception e) {
            if (BuildConfig.DEBUG) {
                e.printStackTrace();
            }
        }

        if (isInteractive)
        {
            //TODO:: Can perform required action based on current status of screen.
        }

        return Result.SUCCESS;
    }
    /**
     * scheduleJobPeriodic: Added a periodic Job scheduler which run on every 15 minute and register receiver if it's unregister. So by this hack broadcast receiver registered for almost every time w.o. running any foreground/ background service.
     * @return
     */
    public static int scheduleJobPeriodic() {
        int jobId = new JobRequest.Builder(TAG_P)
                .setPeriodic(TimeUnit.MINUTES.toMillis(15), TimeUnit.MINUTES.toMillis(5))
                .setRequiredNetworkType(JobRequest.NetworkType.ANY)
                .build()
                .schedule();

        return jobId;
    }

    /**
     * runJobImmediately: run job scheduler immediately so that broadcasr receiver also register immediately
     * @return
     */
    public static int runJobImmediately() {
        int jobId = new JobRequest.Builder(TAG_I)
                .startNow()
                .build()
                .schedule();

        return jobId;
    }

    /**
     * cancelJob: used for cancel any running job by their jobId.
     * @param jobId
     */
    public static void cancelJob(int jobId) {
        JobManager.instance().cancel(jobId);
    }
}
