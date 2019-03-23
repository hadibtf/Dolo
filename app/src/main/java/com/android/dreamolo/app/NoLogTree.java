package com.android.dreamolo.app;

import timber.log.Timber;

public class NoLogTree extends Timber.Tree {
    @Override
    protected void log(int priority, String tag, String message, Throwable t) {
    }
}
