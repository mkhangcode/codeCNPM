package com.example.harvard.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.example.harvard.R;
import com.example.harvard.adapter.IntroAdapter;
import com.example.harvard.oop.Intro;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class IntroActivity extends AppCompatActivity {
    private List<Intro> imageList;
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    Button btn_nextIntro , btn_getStart;
    Animation btnAim;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        AnhXa();
        btnAim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.btn_animation);
        // xử lý slide intro
        imageList = getListPhoto();
        IntroAdapter adapter = new IntroAdapter(imageList);
        viewPager.setAdapter(adapter);
        circleIndicator.setViewPager(viewPager);
        btn_nextIntro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                position = viewPager.getCurrentItem();
                if(position < imageList.size()){
                    position++;
                    viewPager.setCurrentItem(position);
                }
                if(position == imageList.size() - 1){
                    loadLastScreen();
                }
            }
        });
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(position == imageList.size() - 1){
                    loadLastScreen();
                }

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        btn_getStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntroActivity.this, SigninActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loadLastScreen() {
        btn_nextIntro.setVisibility(View.INVISIBLE);
        btn_getStart.setVisibility(View.VISIBLE);
        circleIndicator.setVisibility(View.INVISIBLE);
        btn_getStart.setAnimation(btnAim);
    }

    private void AnhXa() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        circleIndicator = (CircleIndicator) findViewById(R.id.indicator);
        btn_nextIntro = (Button) findViewById(R.id.btn_nextIntro);
        btn_getStart = (Button) findViewById(R.id.btn_getStart);
    }
    private List<Intro> getListPhoto(){
        List<Intro> list = new ArrayList<>();
        list.add(new Intro(R.drawable.intro_book,"Triết lý giáo dục","Mưu cầu hạnh phúc và tự do \n Dựa trên nền tảng đạo đức và trí tuệ"));
        list.add(new Intro(R.drawable.intro_eyeglass, "Giá trị cốt lõi","Đoàn kết - Hợp tác - Kỷ cương - Chất lượng - Phát triển"));
        list.add(new Intro(R.drawable.intro_lightbulb,"Khẩu hiệu hành động","Chính trực - hợp tác - trách nhiệm"));
        return list;
    }
}