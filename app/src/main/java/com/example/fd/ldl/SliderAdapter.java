package com.example.fd.ldl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.fd.ldl.R;

public class SliderAdapter extends PagerAdapter {


    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context)
    {

        this.context=context;
    }

    public int[] slide_images = {
//change for intro slides
        R.drawable.ic_donate,
        R.drawable.ic_camps,
        R.drawable.ic_home

    };

    public  String[] slide_text = {

            "DONATE TO OUR CAUSE",
            "CAMPS",
            "HOME"
    };

    public  String[] slide_extra_text = {

            "BANK INFO etc",
            "CAMPS",
            "HOME"
    };



    @Override
    public int getCount() {


        return slide_text.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (RelativeLayout) o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater= (LayoutInflater)  context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View view= layoutInflater.inflate(R.layout.slider_lay, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);

        TextView  slideHeadView = (TextView)  view.findViewById(R.id.slide_head);

        TextView  slideText = (TextView)  view.findViewById((R.id.slide_extra_text));

        slideImageView.setImageResource(slide_images[position]);

        slideHeadView.setText(slide_text[position]);

        slideText.setText(slide_extra_text[position]);


        container.addView(view);


        return view;
    };

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((RelativeLayout)object);


    }
}

