package com.hlabs.myapplication.db;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.hlabs.myapplication.models.UserEntity;

@Database(entities = {
        UserEntity.class,

}, version =  1, exportSchema = false)

public abstract class FmsDataBase extends RoomDatabase {

    private static volatile FmsDataBase INSTANCE;

    public abstract UserDao getMenuDao();

    public static FmsDataBase getInstance(Context context){
        if(INSTANCE==null){

            synchronized (FmsDataBase.class){

                if(INSTANCE==null){
                    INSTANCE = Room.databaseBuilder(context, FmsDataBase.class,"user").allowMainThreadQueries().build();
                }
                return INSTANCE;
            }
        }
        return INSTANCE;
    }
}
