package com.example.harvard.admin.teacher.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.harvard.R;
import com.example.harvard.activity.ScheduleActivity;
import com.example.harvard.admin.teacher.fragment.DayOfSchedule.FridayTeacherFragment;
import com.example.harvard.admin.teacher.fragment.DayOfSchedule.MondayTeacherFragment;
import com.example.harvard.admin.teacher.fragment.DayOfSchedule.SaturdayTeacherFragment;
import com.example.harvard.admin.teacher.fragment.DayOfSchedule.SundayTeacherFragment;
import com.example.harvard.admin.teacher.fragment.DayOfSchedule.ThursdayTeacherFragment;
import com.example.harvard.admin.teacher.fragment.DayOfSchedule.TuesdayTeacherFragment;
import com.example.harvard.admin.teacher.fragment.DayOfSchedule.WednesdayTeacherFragment;
import com.example.harvard.fragment.FridayFragment;
import com.example.harvard.fragment.MondayFragment;
import com.example.harvard.fragment.SaturdayFragment;
import com.example.harvard.fragment.SundayFragment;
import com.example.harvard.fragment.ThursdayFragment;
import com.example.harvard.fragment.TuesdayFragment;
import com.example.harvard.fragment.WednesdayFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class ScheduleFragment extends Fragment {
    public final String[] PAGES_TITTLES = new String[]{
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
    public final Fragment[] PAGES = new Fragment[]{
            new MondayTeacherFragment(),
            new TuesdayTeacherFragment(),
            new WednesdayTeacherFragment(),
            new ThursdayTeacherFragment(),
            new FridayTeacherFragment(),
            new SaturdayTeacherFragment(),
            new SundayTeacherFragment()
    };
    private ViewPager viewPagerSchedule;
    private TabLayout tabLayoutSchedule;
    ImageButton imageButtonBack;
    ScheduleAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule_teacher, container, false);
        viewPagerSchedule = (ViewPager) view.findViewById(R.id.viewPagerSchedule);
        tabLayoutSchedule = (TabLayout) view.findViewById(R.id.tabLayoutSchedule);
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        adapter = new ScheduleAdapter(fragmentManager);
        viewPagerSchedule.setAdapter(adapter);
        tabLayoutSchedule.setupWithViewPager(viewPagerSchedule);
        return view;
    }
    public class ScheduleAdapter extends FragmentPagerAdapter {

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