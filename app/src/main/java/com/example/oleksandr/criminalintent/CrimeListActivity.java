package com.example.oleksandr.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by Oleksandr on 24.11.2016.
 */

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    public Fragment createFragment() {
        return new CrimeListFragment();
    }
}
