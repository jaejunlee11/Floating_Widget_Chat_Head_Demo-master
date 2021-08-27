package com.floatingwidgetchathead_demo;

import android.app.Application;

import com.evernote.android.job.JobManager;

public class AksApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        JobManager.create(this).addJobCreator(new LockScreenJobCreator());

        //TODO: remaing code
    }

}
