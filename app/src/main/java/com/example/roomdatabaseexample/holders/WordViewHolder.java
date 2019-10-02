package com.example.roomdatabaseexample.holders;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdatabaseexample.R;

import com.example.roomdatabaseexample.data.Word;

public class WordViewHolder extends RecyclerView.ViewHolder {

    public LinearLayout rootItem;

    private final TextView wordItemView;

    public WordViewHolder(@NonNull View itemView) {
        super(itemView);
        wordItemView = itemView.findViewById(R.id.wordTv);
        rootItem = itemView.findViewById(R.id.rootItem);
    }

    public void bind(Word word){
        wordItemView.setText(word.getWord());

    }

}
