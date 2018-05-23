package com.example.sangeeth.braintestapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class onBoard extends AppCompatActivity {

    private ViewPager view1;
    private LinearLayout len1;
    private TextView [] tv3;
    private Button butBac, butNex , butSta;
    private int currentPag;
    private int val;

    private SlideAdapter slideAdapter;
    private static int sTimeOut = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_board);

        view1 = (ViewPager)findViewById(R.id.view1);
        len1 = (LinearLayout)findViewById(R.id.len1);

        butBac = (Button) findViewById(R.id.but1);
        butNex = (Button) findViewById(R.id.but2);
        butSta = findViewById(R.id.but3);


        slideAdapter = new SlideAdapter(this);
        view1.setAdapter(slideAdapter);

        addDotsIndicator(0);

        view1.addOnPageChangeListener(viewListener);

        //onClick Listener

        butNex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                view1.setCurrentItem(currentPag + 1);

            }
        });


        butBac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                view1.setCurrentItem(currentPag - 1);
            }
        });


        butSta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent  homeIntent = new Intent(onBoard.this, HomePage.class);
                startActivity(homeIntent);
                finish();

            }
        });
    }


    public void addDotsIndicator(int position){

        tv3 = new TextView[3];
        len1.removeAllViews();

        for (int i = 0 ; i < tv3.length ; i++){
            tv3[i] = new TextView(this);
            tv3[i].setText(Html.fromHtml("&#8226;"));
            tv3[i].setTextSize(35);
            tv3[i].setTextColor(getResources().getColor(R.color.transparentwhite));

            len1.addView(tv3[i]);

        }



        if (tv3.length > 0){

            tv3[position].setTextColor(getResources().getColor(R.color.colorwhite));

        }
    }


    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {

            addDotsIndicator(i);
            currentPag = i;


            if ( i == 0){

                butNex.setEnabled(true);
                butBac.setEnabled(false);
                butBac.setVisibility(View.INVISIBLE);
                butSta.setEnabled(false);
                butSta.setVisibility(View.INVISIBLE);
                butNex.setVisibility(View.VISIBLE);

                butNex.setText("NEXT");
                butBac.setText("");

            }else if ( i == tv3.length - 1){

                butNex.setEnabled(false);
                butSta.setEnabled(true);
                butBac.setEnabled(true);
                butBac.setVisibility(View.VISIBLE);
                butSta.setVisibility(View.VISIBLE);
                butNex.setVisibility(View.INVISIBLE);

                butSta.setText("Get Started");
                butBac.setText("BACK");



            } else {

                butNex.setEnabled(true);
                butBac.setEnabled(true);
                butBac.setVisibility(View.VISIBLE);
                butSta.setEnabled(false);
                butSta.setVisibility(View.INVISIBLE);
                butNex.setVisibility(View.VISIBLE);

                butNex.setText("NEXT");
                butBac.setText("BACK");

            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}
