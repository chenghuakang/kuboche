package com.orm;

import android.app.Application;

public class SugarApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(this);
        SugarDb db = new SugarDb();
        db.onCreate(db.getDB());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        SugarContext.terminate();
    }

}
