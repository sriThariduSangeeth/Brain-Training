package com.example.sangeeth.braintestapp;

import android.content.Intent;
import  android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class WelcomePage extends AppCompatActivity {

    LinearLayout uLay , dLay;
    Button buttonsub;
    Animation uptodown;
    Animation downtoup;
    private static int sTimeOut = 4000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        buttonsub = (Button)findViewById(R.id.buttonsub);
        uLay = (LinearLayout)findViewById(R.id.uLay);
        dLay = (LinearLayout)findViewById(R.id.dLay);
        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);
        uLay.setAnimation(uptodown);
        dLay.setAnimation(downtoup);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent  homeIntent = new Intent(WelcomePage.this, onBoard.class);
                startActivity(homeIntent);
                finish();

            }
        },sTimeOut);


    }
}
