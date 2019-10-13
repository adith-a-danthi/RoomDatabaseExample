package com.example.roomdatabaseexample.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;

import com.example.roomdatabaseexample.R;
import com.example.roomdatabaseexample.data.Word;
import com.example.roomdatabaseexample.holders.WordViewHolder;

public class WordPagingAdapter extends PagedListAdapter<Word, WordViewHolder> {

    public WordPagingAdapter(){
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater mLayoutInflator = LayoutInflater.from(parent.getContext());
        View mItemView = mLayoutInflator.inflate(R.layout.recyclerview_item,parent,false);
        return new WordViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        final Word currentWord = getItem(position);
        if(currentWord != null){
            holder.bind(currentWord);
        }
    }

    private static DiffUtil.ItemCallback<Word> DIFF_CALLBACK = new DiffUtil.ItemCallback<Word>() {
        @Override
        public boolean areItemsTheSame(@NonNull Word oldItem, @NonNull Word newItem) {
            return oldItem.getWordId() == newItem.getWordId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Word oldItem, @NonNull Word newItem) {
            return oldItem.equals(newItem);
        }
    };
}
