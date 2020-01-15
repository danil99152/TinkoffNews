package com.danilkomyshev.tinkoffnews.ui.content;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.danilkomyshev.tinkoffnews.R;
import com.danilkomyshev.tinkoffnews.data.model.content.Content;
import com.danilkomyshev.tinkoffnews.utils.ApiUtils;
import com.danilkomyshev.tinkoffnews.utils.DateUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

import static io.reactivex.schedulers.Schedulers.io;

public class ContentFragment extends Fragment {

    public static final String CONTENT_KEY = "CONTENT_KEY";

    private int mId;
    private TextView mTitle;
    private TextView mContent;
    private TextView mCreationDate;
    private TextView mLastModificationDate;

    private Disposable mDisposable;

    public static ContentFragment newInstance(Bundle args) {

        ContentFragment fragment = new ContentFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fr_content, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTitle = view.findViewById(R.id.tv_title);
        mContent = view.findViewById(R.id.tv_content);
        mCreationDate = view.findViewById(R.id.tv_creation_date);
        mLastModificationDate = view.findViewById(R.id.tv_last_modificaton_date);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getActivity() != null) {
            getActivity().setTitle("Content");
        }

        if (getArguments() != null) {
            mId = getArguments().getInt(CONTENT_KEY);
        }
        getContent();
    }

    private void getContent() {
        mDisposable = ApiUtils.getNewsApi().getContent(mId)
                .subscribeOn(io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        response -> bind(response.getContent())
                );
    }

    private void bind(Content content) {
        mTitle.setText(content.getTitle().getText());
        mContent.setText(Html.fromHtml(content.getContent()));
        mCreationDate.setText(DateUtils.format(content.getCreationDate().getMilliseconds()));
        mLastModificationDate.setText(DateUtils.format(content.getLastModificationDate().getMilliseconds()));

    }

    @Override
    public void onDetach() {
        if (mDisposable != null) {
            mDisposable.dispose();
        }
        super.onDetach();
    }
}