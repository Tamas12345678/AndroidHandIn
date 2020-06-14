package com.example.navbarzzleep.ui.FireBase;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.navbarzzleep.Mine.MineFragment;
import com.example.navbarzzleep.R;
import com.example.navbarzzleep.Shop.ListFragment;
import com.example.navbarzzleep.pokemonProfil.ProfileFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.Mine, R.string.Shop, R.string.List};
    private static final String[] titles = {"Hello", "Hi", "Csumi"};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position)
        {
            case 0:
                fragment = new MineFragment();
                break;
            case 1:
                fragment = new ListFragment();
                break;
            case 2:
                fragment = new ProfileFragment();
                break;

        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 3;
    }
}