package com.engg.project.simple_app;

import android.animation.Animator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import java.util.Random;

/**
 * Created by madhushreet on 01-02-2019.
 */

public class Animate extends AppCompatActivity {
    int x,y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imageView = findViewById(R.id.imageView);
      Random random = new Random();

        x= random.nextInt();


        imageView.setX(x);
        imageView.setY(y);



        TranslateAnimation tAnimation = new TranslateAnimation(x,0,y,0);
        tAnimation.setDuration(5000);
        tAnimation.setRepeatCount(0);
        tAnimation.setInterpolator(new LinearInterpolator());
        tAnimation.setFillAfter(true);

        tAnimation.setAnimationListener(new Animation.AnimationListener() {


            public void onAnimationStart(Animation animation) {


            }


            public void onAnimationRepeat(Animation animation) {


            }


            public void onAnimationEnd(Animation animation) {

                imageView.setVisibility(View.GONE);
            }
        });

        imageView.startAnimation(tAnimation);
    }



}
