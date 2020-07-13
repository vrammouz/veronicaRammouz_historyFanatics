package com.example.veronica.historyfanatics;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Veronica on 4/28/2019.
 */
public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter
{
    public SimpleFragmentPagerAdapter(FragmentManager fm){ super(fm); }

    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new SavedStoriesFragment();
        } else if(position == 1) {
            return  new WatchListFragment();
        }
        else {
            return  new AboutFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0){
            return "Saved Stories";
        } else if(position == 1){
            return "Watch List";
        } else {
            return "About";
        }
    }
}
