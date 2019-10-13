package com.example.roomdatabaseexample.viewModel;

import android.app.Application;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.example.roomdatabaseexample.data.Word;
import com.example.roomdatabaseexample.repository.WordRepository;

import java.util.List;

public class WordViewModel extends AndroidViewModel {
    private int PAGE_SIZE = 15;
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

    public void deleteAll(){
        mRepository.deleteAll();
    }

    public void deleteWord(Word word){
        mRepository.deleteWord(word);
    }

    public void updateWord(Word word){
        mRepository.updateWord(word);
    }

    public LiveData<PagedList<Word>> getAllPagedWords(){
        LiveData<PagedList<Word>> mPagedList =
                new LivePagedListBuilder<>(
                        mRepository.getAllPagedWords(),
                        PAGE_SIZE
                ).build();
        return  mPagedList;
    }
}
