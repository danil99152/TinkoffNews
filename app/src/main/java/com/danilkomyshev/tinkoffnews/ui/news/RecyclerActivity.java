package com.danilkomyshev.tinkoffnews.ui.news;

import androidx.fragment.app.Fragment;

import com.danilkomyshev.tinkoffnews.common.SingleFragmentActivity;

public class RecyclerActivity extends SingleFragmentActivity {

    @Override
    protected Fragment getFragment() {
        return RecyclerFragment.newInstance();
    }
}
