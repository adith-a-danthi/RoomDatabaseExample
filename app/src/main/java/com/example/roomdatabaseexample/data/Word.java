package com.example.roomdatabaseexample.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "wordTable")
public class Word {

    //@PrimaryKey(autoGenerate = true)
    //private int wordId;
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    private String mWord;

    public Word(String word) {
        this.mWord = word;
    }

//    public int getWordId() {
//        return wordId;
//    }

    public String getWord() {
        return this.mWord;
    }

}
