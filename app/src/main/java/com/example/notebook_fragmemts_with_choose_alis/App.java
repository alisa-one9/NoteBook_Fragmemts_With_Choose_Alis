package com.example.notebook_fragmemts_with_choose_alis;

import android.app.Application;
import androidx.room.Room;

import com.example.notebook_fragmemts_with_choose_alis.room.AppDataBase;

public class App extends Application {
    private static AppDataBase appDatabase;

    @Override
    public void onCreate() {
        super.onCreate();

        appDatabase = Room
                .databaseBuilder(this, AppDataBase.class, "database")
                .allowMainThreadQueries()

                .build();
    }
    public static AppDataBase getAppDatabase() {
        return appDatabase;
    }
}
