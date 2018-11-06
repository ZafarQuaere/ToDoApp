package com.roomdbdemo.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.content.Context;

public class DatabaseClient {

    private Context mContext;
    private static DatabaseClient mClient;

    //app DB object
    private AppDatabase appDatabase;

    private DatabaseClient(Context context){
        mContext = context;

        //creating the app database with Room database builder
        //MyToDos is the name of the database
        appDatabase = Room.databaseBuilder(mContext,AppDatabase.class,"MyTodos").build();


    }

    public static synchronized DatabaseClient getInstance(Context context){
        if (mClient == null){
            mClient = new DatabaseClient(context);
        }
        return mClient;
    }

    public AppDatabase getAppDatabase(){
        return appDatabase;
    }
}
