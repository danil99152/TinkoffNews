package com.danilkomyshev.tinkoffnews.ui.news;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.danilkomyshev.tinkoffnews.R;
import com.danilkomyshev.tinkoffnews.data.model.news.Note;
import com.danilkomyshev.tinkoffnews.utils.DateUtils;

class NewsHolder extends RecyclerView.ViewHolder {

    private TextView mText;
    private TextView mPublicationDate;

    NewsHolder(@NonNull View itemView) {
        super(itemView);
        mText = itemView.findViewById(R.id.tv_text);
        mPublicationDate = itemView.findViewById(R.id.tv_publicaton);
    }

    void bind(Note item, NewsAdapter.OnItemClickListener onItemClickListener) {
        mText.setText(item.getText());
        mPublicationDate.setText(DateUtils.format(item.getPublicationDate()));
        if (onItemClickListener != null) {
            itemView.setOnClickListener(v->onItemClickListener.OnItemClick(
                    item.getId()
            ));
        }
    }
}
