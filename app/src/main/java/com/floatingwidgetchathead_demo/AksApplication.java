package com.floatingwidgetchathead_demo;

import android.app.Application;

import com.evernote.android.job.JobManager;

public class AksApplication extends Application {
    private int id;

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }
    @Override
    public void onCreate() {
        super.onCreate();

        JobManager.create(this).addJobCreator(new LockScreenJobCreator());

        //TODO: remaing code
    }

}
