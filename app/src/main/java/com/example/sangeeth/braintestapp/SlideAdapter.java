package com.example.sangeeth.braintestapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Sangeeth on 3/5/18.
 */

public class SlideAdapter extends PagerAdapter{

    Context context;
    LayoutInflater layoutInflater;


    public SlideAdapter(Context context){

        this.context = context;

    }

    //Array

    public int[] slide_image = {

            R.drawable.h1,
            R.drawable.h2,
            R.drawable.h3

    };

    public String[] slide_heading ={

            "EAT",
            "SLEEP",
            "CODE"

    };

    public String[] slide_descs = {

            "this is first description... here write the description about application and rules "+" what is the name of the rule. ",
            "this is second description...here write the description about application and rules"+" what is the name of the rule. ",
            "this is third description...here write the description about application and rules"+" what is the name of the rule. "
    };


    @Override
    public int getCount() {
        return slide_heading.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {

        return view == (RelativeLayout) o;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);


        ImageView iv1 = (ImageView) view.findViewById(R.id.iv1);
        TextView tv1 = (TextView) view.findViewById(R.id.tv1);
        TextView tv2 = (TextView) view.findViewById(R.id.tv2);


        iv1.setImageResource(slide_image[position]);
        tv1.setText(slide_heading[position]);
        tv2.setText(slide_descs[position]);

        container.addView(view);


        return view;

    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((RelativeLayout)object);

    }
}
