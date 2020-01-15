package com.danilkomyshev.tinkoffnews.ui.news;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.danilkomyshev.tinkoffnews.R;
import com.danilkomyshev.tinkoffnews.data.database.Storage;
import com.danilkomyshev.tinkoffnews.ui.content.ContentActivity;
import com.danilkomyshev.tinkoffnews.ui.content.ContentFragment;
import com.danilkomyshev.tinkoffnews.utils.ApiUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RecyclerFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, NewsAdapter.OnItemClickListener {

    private NewsAdapter mNewsAdapter;
    private SwipeRefreshLayout mRefresher;
    private CompositeDisposable mDisposables = new CompositeDisposable();
    private RecyclerView mRecyclerView;
    private Storage mStorage;

    static RecyclerFragment newInstance() {
        Bundle args = new Bundle();
        RecyclerFragment fragment = new RecyclerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Storage.StorageOwner) {
            mStorage = ((Storage.StorageOwner) context).obtainStorage();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fr_recycler, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRefresher = view.findViewById(R.id.newslist_refresher);
        mRecyclerView = view.findViewById(R.id.news_recycler_view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getActivity() != null) {
            getActivity().setTitle(R.string.screen_title);

        }
        mRefresher.setOnRefreshListener(this);
        mNewsAdapter = new NewsAdapter(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mNewsAdapter);
        onRefresh();

    }

    @Override
    public void onRefresh() {
        loadNews();
    }

    private void loadNews() {

        Disposable request = ApiUtils.getNewsApi()
                .getNews()
                .doOnSuccess(response -> mStorage.insertNews(response))
                .onErrorReturn(throwable ->
                        ApiUtils.NETWORK_EXCEPTIONS.contains(throwable.getClass()) ? mStorage.getNews() : null)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> mRefresher.setRefreshing(true))
                .doFinally(() -> mRefresher.setRefreshing(false))
                .subscribe(news -> {
                    mNewsAdapter.addData(news.getNews());
                    toastMessage(getString(R.string.news_loaded));
                }, throwable -> toastMessage("Downloading error"));

        mDisposables.add(request);
    }

    private void toastMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mStorage = null;
        mDisposables.dispose();
    }

    @Override
    public void OnItemClick(int id) {
        Intent intent = new Intent(getActivity(), ContentActivity.class);
        Bundle args = new Bundle();
        args.putInt(ContentFragment.CONTENT_KEY, id);
        intent.putExtra(ContentActivity.ID_KEY, args);
        startActivity(intent);
    }
}
