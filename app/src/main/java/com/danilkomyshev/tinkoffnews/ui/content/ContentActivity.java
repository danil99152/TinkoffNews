package com.danilkomyshev.tinkoffnews.ui.content;


import androidx.fragment.app.Fragment;

import com.danilkomyshev.tinkoffnews.common.SingleFragmentActivity;

public class ContentActivity extends SingleFragmentActivity {

    public static final String ID_KEY = "ID_KEY";

    @Override
    protected Fragment getFragment() {
        if (getIntent() != null) {
            return ContentFragment.newInstance(getIntent().getBundleExtra(ID_KEY));
        }
        throw new IllegalStateException("getIntent can't be null");
    }
}