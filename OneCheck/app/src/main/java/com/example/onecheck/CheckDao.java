package com.example.onecheck;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CheckDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Check name);

    @Query("DELETE FROM check_table")
    void deleteAll();

    @Delete
    void deleteWord(Check name);

    @Query("SELECT * from check_table LIMIT 1")
    Check[] getAnyWord();

    @Query("SELECT * from check_table ORDER BY name ASC")
    LiveData<List<Check>> getAllWords();

}
