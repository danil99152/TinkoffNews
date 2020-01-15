package com.danilkomyshev.tinkoffnews.ui.news;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.danilkomyshev.tinkoffnews.R;
import com.danilkomyshev.tinkoffnews.data.model.news.Note;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsHolder> {

    private final List<Note> mNews = new ArrayList<>();
    private final OnItemClickListener mOnItemClickListener;

    NewsAdapter(RecyclerFragment onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.news_item, viewGroup, false);
        return new NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder newsHolder, int position) {
        Note note = mNews.get(position);
        newsHolder.bind(note, (OnItemClickListener) mOnItemClickListener);
    }

    @Override
    public int getItemCount() {
        return mNews.size();
    }

    void addData(List<Note> data) {
        mNews.clear();
        mNews.addAll(data);
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void OnItemClick(int id);
    }
}
