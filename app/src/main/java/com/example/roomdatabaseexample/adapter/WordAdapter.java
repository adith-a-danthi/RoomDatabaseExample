package com.example.roomdatabaseexample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdatabaseexample.R;
import com.example.roomdatabaseexample.data.Word;

import java.util.ArrayList;
import java.util.List;


public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordViewHolder> {

    private ClickListener clickListener;

    class WordViewHolder extends RecyclerView.ViewHolder{
        private final TextView wordItemView;

        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.wordTv);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.onItemClick(v,getAdapterPosition());
                }
            });
        }

        public void  bind(Word word) {
            wordItemView.setText(word.getWord());
        }
    }

    private final LayoutInflater mInflater;
    private List<Word> mWords = new ArrayList<>();

    public WordAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item,parent,false);
        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
            Word current = mWords.get(position);
            holder.bind(current);
    }

    public void setWords(List<Word> words){
        mWords = words;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mWords.size();
    }

    public Word getWordAtPostion(int postion){
        return mWords.get(postion);
    }

    public void setItemOnClickListener(ClickListener clickListener){
        this.clickListener = clickListener;
    }
    public interface ClickListener{
        void onItemClick(View v,int position);
    }

}
