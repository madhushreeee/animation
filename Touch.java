package com.engg.project.anim;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

/**
 * Created by madhushreet on 01-02-2019.
 */

public class Touch extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public boolean onTouchEvent(MotionEvent event) {
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        Animation animation = new TranslateAnimation(0, event.getX(), 0, event.getY());
        animation.setDuration(1000);
       // animation.setFillAfter(true);
        imageView.startAnimation(animation);

       return super.onTouchEvent(event);
    }
}
