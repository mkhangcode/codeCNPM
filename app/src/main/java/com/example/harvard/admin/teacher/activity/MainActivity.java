package com.example.harvard.admin.teacher.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.example.harvard.R;
import com.example.harvard.admin.teacher.fragment.HomeTeacherFragment;
import com.example.harvard.admin.teacher.fragment.ListStudentFragment;
import com.example.harvard.admin.teacher.fragment.ScheduleFragment;
import com.example.harvard.fragment.HomeFragment;
import com.example.harvard.fragment.MyInfoFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    NavigationView navigationView;
    private DrawerLayout drawerLayout;
    LinearLayout Schedule;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        AnhXa();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        navigationView.setNavigationItemSelectedListener(this);
        toggle.syncState();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeTeacherFragment(), "home_teacher_fragment").commit();
            navigationView.setCheckedItem(R.id.nav_Home);
        }
    }
    private void AnhXa() {
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        Schedule = (LinearLayout) findViewById(R.id.Schedule);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_Home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeTeacherFragment()).commit();
                break;
            case R.id.nav_times:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ScheduleFragment()).commit();
                break;
            case R.id.nav_listClass:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ListStudentFragment()).commit();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}