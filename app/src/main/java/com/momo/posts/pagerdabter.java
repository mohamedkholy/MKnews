package com.momo.posts;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class pagerdabter extends FragmentStatePagerAdapter {


    ArrayList<mttab> l=new ArrayList<>();

    public pagerdabter(@NonNull FragmentManager fm) {
        super(fm);

        l.add(new mttab(new localnews(),"Headlines"));
        l.add(new mttab(new sports(),"Sports"));
        l.add(new mttab(new economy(),"Economy"));
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
