package com.example.harvard.adapter;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.harvard.fragment.SigninByMSSVFragment;
import com.example.harvard.fragment.SigninByPhoneFragment;

public class LoginAdapter extends FragmentPagerAdapter {
    private Context context;
    int totalTabs;

    public LoginAdapter(FragmentManager fm, Context context, int totalTabs) {
        super(fm);
        this.context = context;
        this.totalTabs = totalTabs;
    }

    @Override
    public int getCount() {
        return totalTabs;
    }

    public Fragment getItem(int position) {
        switch (position){
            case 0:
                SigninByMSSVFragment signinByMSSVFragment = new SigninByMSSVFragment();
                return  signinByMSSVFragment;
            case 1:
                SigninByPhoneFragment signinByPhoneFragment = new SigninByPhoneFragment();
                return signinByPhoneFragment;
            default:
                return null;
        }
    }
}
