package com.danilkomyshev.tinkoffnews.common;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.danilkomyshev.tinkoffnews.App;
import com.danilkomyshev.tinkoffnews.R;
import com.danilkomyshev.tinkoffnews.data.database.Storage;

public abstract class SingleFragmentActivity extends AppCompatActivity implements Storage.StorageOwner{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_single_fragment);

        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, getFragment())
                    .addToBackStack(getFragment().getClass().getSimpleName())
                    .commit();
        }
    }

    protected abstract Fragment getFragment();

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.getBackStackEntryCount() == 1) {
            finish();
        } else {
            fragmentManager.popBackStack();
        }
    }

    @Override
    public Storage obtainStorage() {
        return ((App) getApplicationContext()).getStorage();
    }
}
