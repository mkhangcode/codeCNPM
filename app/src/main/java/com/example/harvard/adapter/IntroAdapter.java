package com.example.harvard.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.harvard.R;
import com.example.harvard.oop.Intro;

import java.util.List;

public class IntroAdapter extends PagerAdapter {
    private List<Intro> imageList;

    public IntroAdapter(List<Intro> imageList) {
        this.imageList = imageList;
    }

    @Override
    public int getCount() {
        if(imageList != null){
            return imageList.size();
        }
        return 0;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.layout_intro,container,false);
        ImageView imgIntro = view.findViewById(R.id.imgIntro);
        TextView txtTittle = view.findViewById(R.id.txtTittle);
        TextView txtDescription = view.findViewById(R.id.txtDescription);
        Intro image = imageList.get(position);
        imgIntro.setImageResource(image.getResourceID());
        txtTittle.setText(image.gettxtTittle());
        txtDescription.setText(image.gettxtDescription());
        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
