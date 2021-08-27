package com.floatingwidgetchathead_demo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobCreator;

public class LockScreenJobCreator implements JobCreator {

    @Override
    @Nullable
    public Job create(@NonNull String tag) {
        switch (tag) {
            case LockScreenJob.TAG_I:
                return new LockScreenJob();
            case LockScreenJob.TAG_P:
                return new LockScreenJob();
            default:
                return null;
        }
    }
}
