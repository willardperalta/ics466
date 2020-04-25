package com.example.onecheck;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class CheckRepository {
    private CheckDao mCheckDao;
    private LiveData<List<Check>> mAllChecks;

    CheckRepository(Application application) {
        CheckRoomDatabase db = CheckRoomDatabase.getDatabase(application);
        mCheckDao = db.checkDao();
        mAllChecks = mCheckDao.getAllChecks();
    }

    LiveData<List<Check>> getAllChecks() {
        return mAllChecks;
    }

    public void insert (Check check) {
        new insertAsyncTask(mCheckDao).execute(check);
    }

    private static class insertAsyncTask extends AsyncTask<Check, Void, Void> {

        private CheckDao mAsyncTaskDao;

        insertAsyncTask(CheckDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Check... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
