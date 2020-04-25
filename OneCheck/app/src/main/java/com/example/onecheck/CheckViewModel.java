package com.example.onecheck;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class CheckViewModel extends AndroidViewModel {
    private CheckRepository mRepository;
    private LiveData<List<Check>> mAllChecks;

    public CheckViewModel (Application application) {
        super(application);
        mRepository = new CheckRepository(application);
        mAllChecks = mRepository.getAllChecks();
    }

    LiveData<List<Check>> getAllChecks() {
        return mAllChecks;
    }

    public void insert(Check check) {
        mRepository.insert(check);
    }


}
