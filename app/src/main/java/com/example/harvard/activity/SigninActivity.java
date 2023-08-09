package com.example.harvard.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.harvard.R;
import com.example.harvard.adapter.LoginAdapter;
import com.google.android.material.tabs.TabLayout;

public class SigninActivity extends AppCompatActivity {
    ViewPager viewPagerSignin;
    TabLayout tabLayoutSignin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        AnhXa();
        tabLayoutSignin.addTab(tabLayoutSignin.newTab().setText("Mã SV"));
        tabLayoutSignin.addTab(tabLayoutSignin.newTab().setText("Điện thoại"));
        tabLayoutSignin.setTabGravity(TabLayout.GRAVITY_FILL);
        final LoginAdapter adapter = new LoginAdapter(getSupportFragmentManager(), this, tabLayoutSignin.getTabCount());
        viewPagerSignin.setAdapter(adapter);
        viewPagerSignin.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayoutSignin));
        tabLayoutSignin.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPagerSignin.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        tabLayoutSignin.setTranslationX(300);
        tabLayoutSignin.setAlpha(0);
        tabLayoutSignin.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(800).start();
    }

    private void AnhXa() {
        viewPagerSignin = (ViewPager) findViewById(R.id.viewPagerSignin);
        tabLayoutSignin = (TabLayout) findViewById(R.id.tabLayoutSignin);
    }

}