package com.example.onecheck;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Check.class}, version = 1, exportSchema = false)
public abstract class CheckRoomDatabase extends RoomDatabase {
    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
        private final CheckDao mDao;
        String[] names = {"Bob", "Kelly", "Bill"};
        String[] prices = {"20", "25", "15"};

        PopulateDbAsync(CheckRoomDatabase db) {
            mDao = db.checkDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            mDao.deleteAll();

            for (int i = 0; i <= names.length - 1; i++) {
                Check check = new Check(names[i], prices[i]);
                mDao.insert(check);
            }
            return null;
        }
    }

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
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
