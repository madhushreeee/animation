package com.engg.project.simple_app;
// test
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    float x,y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onTouchEvent(MotionEvent event) {
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        x=event.getRawX();
        y=event.getRawY();
       Animation animation = new TranslateAnimation(x,event.getRawX(), y,event.getRawY());
        animation.setFillAfter(true);
        imageView.startAnimation(animation);
        return super.onTouchEvent(event);
    }
    }




