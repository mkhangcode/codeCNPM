package com.example.harvard.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.TaskStackBuilder;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.harvard.R;
import com.example.harvard.common.Common;
import com.example.harvard.fragment.HomeFragment;
import com.example.harvard.fragment.MauDonFragment;
import com.example.harvard.fragment.MyInfoFragment;
import com.example.harvard.fragment.NoiQuyFragment;
import com.example.harvard.fragment.ThoiGianBieuFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputLayout;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    NavigationView navigationView;
    private DrawerLayout drawerLayout;
    LinearLayout Schedule;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        navigationView.setNavigationItemSelectedListener(this);
        toggle.syncState();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment(), "home_fragment").commit();
            navigationView.setCheckedItem(R.id.nav_Home);
        }
        View view = LayoutInflater.from(this).inflate(R.layout.layout_navheader, null);
        TextView txtName = (TextView) view.findViewById(R.id.txtName);
        TextView txtID = (TextView) view.findViewById(R.id.txtID);
        TextView txtNganh = (TextView) view.findViewById(R.id.txtNganh);
        txtName.setText(Common.currentUser.getFirstName() + " " + Common.currentUser.getLastName());
        txtNganh.setText(Common.currentUser.getCourseInfo().getChuyenNganh());
        txtID.setText(Common.currentUser.getStudentID());

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
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

                break;
            case R.id.nav_info:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MyInfoFragment()).commit();
                break;
            case R.id.nav_regulations:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new NoiQuyFragment()).commit();
                break;
            case R.id.nav_logOut:
                Intent signIn = new Intent(MainActivity.this, SigninActivity.class);
                signIn.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(signIn);
                break;
            case R.id.nav_times:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ThoiGianBieuFragment()).commit();
                break;
            case R.id.nav_creaWord:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MauDonFragment()).commit();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}