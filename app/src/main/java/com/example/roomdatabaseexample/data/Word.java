package com.example.roomdatabaseexample.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "wordTable")
public class Word {



    @PrimaryKey(autoGenerate = true)
    private int mWordId;

    @NonNull
    @ColumnInfo(name = "word")
    private String mWord;

    public Word(String word){
        this.mWord = word;
    }

    @Ignore
    public Word(String word,int id) {
        this.mWord = word;
        this.mWordId = id;
    }

    public String getWord() {
        return this.mWord;
    }

    public int getWordId(){
        return mWordId;
    }

    public void setWordId(int mWordId) {
        this.mWordId = mWordId;
    }

    public boolean equals(Word w2){
        return (mWordId == w2.getWordId() && mWord == w2.getWord());
    }
}
