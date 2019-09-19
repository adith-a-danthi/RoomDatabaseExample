package com.example.roomdatabaseexample.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.roomdatabaseexample.data.Word;
import com.example.roomdatabaseexample.repository.WordRepository;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private WordRepository mRepository;
    private LiveData<List<Word>> mAllWords;

    public WordViewModel(@NonNull Application application) {
        super(application);
        mRepository = new WordRepository(application);
        mAllWords = mRepository.getAllWords();
    }

    public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public void insert(Word word){
        mRepository.insert(word);
    }


}
