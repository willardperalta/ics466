package com.example.onecheck;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Check.class}, version = 1, exportSchema = false)
public abstract class CheckRoomDatabase extends RoomDatabase {
    public abstract CheckDao checkDao();

    private static CheckRoomDatabase INSTANCE;

    public static CheckRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CheckRoomDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            CheckRoomDatabase.class, "check_database")
                            // Wipes and rebuilds instead of migrating
                            // if no Migration object.
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
