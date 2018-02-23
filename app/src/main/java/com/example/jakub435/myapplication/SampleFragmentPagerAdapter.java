package com.example.jakub435.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


/**
 * Created by Jakub435 on 2018-02-12.
 */


public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {
    String[] tabTitles = createTitle();
    private int PAGE_COUNT = tabTitles.length;


    public SampleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        return PageFragment.newInstance(position + 1);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }

    public String[] createTitle(){
        String[] titles = new String[6];
        for(int i = 0; i < 6; i++){
            long oneDay = 86400000; // one day in milisecond
            long milisec = new Date().getTime();
            String date = new SimpleDateFormat("dd-MM-yyyy",
                    Locale.getDefault()).
                    format(new Date(milisec + oneDay*i));
            titles[i]= date;
        }
        return titles;
    }


}