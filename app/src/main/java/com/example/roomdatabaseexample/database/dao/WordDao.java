package com.example.roomdatabaseexample.database.dao;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roomdatabaseexample.data.Word;

import java.util.List;

@Dao
public interface WordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Word word);

    @Query("SELECT * FROM wordTable ORDER BY word ASC")
    LiveData<List<Word>> getAllWords();

    @Query("SELECT * FROM wordTable ORDER BY word ASC")
    DataSource.Factory<Integer,Word> getAllPagedWords();

    @Query("DELETE FROM wordTable")
    void deleteAll();

    @Delete
    void deleteWord(Word word);

    @Update
    void updateWord(Word word);

    @Query("SELECT * FROM wordTable LIMIT 1")
    Word[] getAnyWord();
}
