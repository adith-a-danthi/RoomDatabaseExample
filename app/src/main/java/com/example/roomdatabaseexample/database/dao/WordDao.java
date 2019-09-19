package com.example.roomdatabaseexample.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.roomdatabaseexample.data.Word;

import java.util.List;

@Dao
public interface WordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Word word);

    @Query("SELECT * FROM wordTable ORDER BY word ASC")
    LiveData<List<Word>> getAllWords();


}
