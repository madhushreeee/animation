package com.engg.project.simple_app;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import java.util.Random;

/**
 * Created by madhushreet on 04-02-2019.
 */

public class MoveUp extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.imageView);


        AnimationSet snowMov1 = new AnimationSet(true);

        RotateAnimation rotate1 = new RotateAnimation(0, 140,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        rotate1.setStartOffset(0);
        rotate1.setDuration(300);
        rotate1.setRepeatCount(0);
        snowMov1.addAnimation(rotate1);

        TranslateAnimation trans1 = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0.1f,
                Animation.RELATIVE_TO_PARENT, -0.1f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, -0.1f);
        trans1.setDuration(2000);
        trans1.setRepeatCount(0);
        snowMov1.addAnimation(trans1);

        RotateAnimation rotate2 = new RotateAnimation(140,0,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        rotate1.setStartOffset(50);
        rotate1.setDuration(300);
        rotate1.setRepeatCount(0);
        snowMov1.addAnimation(rotate2);

        TranslateAnimation trans2 = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, -0.1f,
                Animation.RELATIVE_TO_PARENT, -0.2f,
                Animation.RELATIVE_TO_PARENT, -0.1f,
                Animation.RELATIVE_TO_PARENT, -0.2f);
        trans1.setDuration(2000);
        trans1.setRepeatCount(0);
        snowMov1.addAnimation(trans2);


        snowMov1.setFillAfter(true);
        imageView.startAnimation(snowMov1);

    }
}