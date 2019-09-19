package com.example.roomdatabaseexample.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.roomdatabaseexample.data.Word;
import com.example.roomdatabaseexample.database.WordRoomDatabase;
import com.example.roomdatabaseexample.database.dao.WordDao;

import java.util.List;

public class WordRepository {

    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    public WordRepository(Application application){
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAllWords();
    }

    public LiveData<List<Word>> getAllWords(){
        return mAllWords;
    }

    public void insert (Word word){
        new insertAsyncTask(mWordDao, word).execute();
    }

    public void deleteAll(){
        new deleteAllAsyncTask(mWordDao);
    }
    public void deleteWord(Word word){
        new deleteWordAsyncTask(mWordDao).execute(word);
    }

    private class deleteWordAsyncTask extends AsyncTask<Word,Void,Void>{

        private WordDao mAsyncTaskDao;

        deleteWordAsyncTask(WordDao dao){
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Word... words) {
            mAsyncTaskDao.deleteWord(words[0]);
            return null;
        }
    }

    private class deleteAllAsyncTask extends AsyncTask<Void,Void,Void>{

        private WordDao mAsyncTaskDao;

        deleteAllAsyncTask(WordDao dao){
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mAsyncTaskDao.deleteAll();
            return null;
        }
    }

    private class insertAsyncTask extends AsyncTask<Void,Void,Void> {

        private WordDao mAsyncTaskDao;
        private Word word;

        insertAsyncTask(WordDao dao, Word word){
            mAsyncTaskDao = dao;
            this.word = word;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mAsyncTaskDao.insert(word);
            return null;
        }
    }
}
