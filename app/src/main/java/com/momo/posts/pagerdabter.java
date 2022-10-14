package com.momo.posts;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class pagerdabter extends FragmentStatePagerAdapter {


    ArrayList<mttab> l=new ArrayList<>();

    public pagerdabter(@NonNull FragmentManager fm, Context c) {
        super(fm);

        l.add(new mttab(new localnews(),c.getString(R.string.HEADLINES)));
        l.add(new mttab(new sports(),c.getString(R.string.SPORTS)));
        l.add(new mttab(new economy(),c.getString(R.string.BUSINESS)));
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return l.get(position).getFragment();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return l.get(position).getName();

    }

    @Override
    public int getCount() {
        return l.size();
    }
}
