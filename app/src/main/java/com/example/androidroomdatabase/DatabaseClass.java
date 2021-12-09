package com.example.androidroomdatabase;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.androidroomdatabase.Dao.UserDao;
import com.example.androidroomdatabase.EntityClass.EntityUserModel;

@Database(entities = {EntityUserModel.class}, version = 1)
public abstract class DatabaseClass extends RoomDatabase {


    public abstract UserDao getDao();

    private static DatabaseClass databaseClass;


    static DatabaseClass getDatabaseClass(final Context context){

        if (databaseClass == null){
            synchronized (DatabaseClass.class){
                databaseClass = Room.databaseBuilder(context,DatabaseClass.class,"DATABASE").allowMainThreadQueries().build();
            }
        }
        return databaseClass;
    }



}
