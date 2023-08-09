package com.example.harvard.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.harvard.R;
import com.example.harvard.common.Common;
import com.example.harvard.fragment.FridayFragment;
import com.example.harvard.fragment.MondayFragment;
import com.example.harvard.fragment.SaturdayFragment;
import com.example.harvard.fragment.SundayFragment;
import com.example.harvard.fragment.ThursdayFragment;
import com.example.harvard.fragment.TuesdayFragment;
import com.example.harvard.fragment.WednesdayFragment;
import com.example.harvard.oop.Result;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ScheduleActivity extends AppCompatActivity {
    public static final String[] PAGES_TITTLES = new String[]{
            "Thứ 2",
            "Thứ 3",
            "Thứ 4",
            "Thứ 5",
            "Thứ 6",
            "Thứ 7",
            "Chủ nhật"
    };
    Spinner spinnerAcademicYear, spinnerSemester;
    List<String> AcademicYear, Semester;
    private String Nam, HocKi;
    public static final Fragment[] PAGES = new Fragment[]{
            new MondayFragment(),
            new TuesdayFragment(),
            new WednesdayFragment(),
            new ThursdayFragment(),
            new FridayFragment(),
            new SaturdayFragment(),
            new SundayFragment()
    };
    private ViewPager viewPagerSchedule;
    private TabLayout tabLayoutSchedule;
    ImageButton imageButtonBack;
    ScheduleAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        AnhXa();
        adapter = new ScheduleAdapter(getSupportFragmentManager());
        viewPagerSchedule.setAdapter(adapter);
        tabLayoutSchedule.setupWithViewPager(viewPagerSchedule);
        InsertDataToSpinner();
        spinnerAcademicYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView1, View view, int i, long l) {
                if (!adapterView1.getItemAtPosition(i).equals("Chọn năm")) {
                    spinnerSemester.setSelection(0);
                    Nam = adapterView1.getSelectedItem().toString();
                    Common.Nam = Nam;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinnerSemester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView2, View view, int i, long l) {
                if (!adapterView2.getItemAtPosition(i).equals("Chọn học kì")) {
                    HocKi = adapterView2.getSelectedItem().toString();
                    Common.HocKy = HocKi;
                    viewPagerSchedule.setAdapter(adapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        imageButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Common.Nam = "";
                Common.HocKy = "";
            }
        });

    }
    private void InsertDataToSpinner() {
        AcademicYear = new ArrayList<>();
        AcademicYear.add(0, "Chọn năm");
        AcademicYear.add("2021 - 2022");
        AcademicYear.add("2022 - 2023");
        AcademicYear.add("2023 - 2024");
        AcademicYear.add("2024 - 2025");
        ArrayAdapter<String> dataAdapter1;
        dataAdapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, AcademicYear);
        spinnerAcademicYear.setAdapter(dataAdapter1);
        Semester = new ArrayList<>();
        Semester.add(0, "Chọn học kì");
        Semester.add("Học kì 1");
        Semester.add("Học kì 2");
        Semester.add("Học kì 3");
        ArrayAdapter<String> dataAdapter2;
        dataAdapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Semester);
        spinnerSemester.setAdapter(dataAdapter2);
    }

    private void AnhXa() {
        viewPagerSchedule = (ViewPager) findViewById(R.id.viewPagerSchedule);
        tabLayoutSchedule = (TabLayout) findViewById(R.id.tabLayoutSchedule);
        imageButtonBack = (ImageButton) findViewById(R.id.imageButtonBack);
        spinnerAcademicYear = (Spinner) findViewById(R.id.spinnerAcademicYear);
        spinnerSemester = (Spinner) findViewById(R.id.spinnerSemester);
    }

    public static class ScheduleAdapter extends FragmentPagerAdapter {

        public ScheduleAdapter(@NonNull FragmentManager fm) {
            super(fm);
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {

            return PAGES[position];
        }

        @Override
        public int getCount() {
            return PAGES.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return PAGES_TITTLES[position];
        }
    }
}