package com.engg.project.simple_app;
// test
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.PathMeasure;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation);

        ImageView imageView = findViewById(R.id.imageView);
        Display display = getWindowManager().getDefaultDisplay();
        float height = display.getHeight();
        float i;
        /*AnimationSet snowMov1 = new AnimationSet(true);

        RotateAnimation rotate1 = new RotateAnimation(0, 45,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        rotate1.setStartOffset(50);
        rotate1.setDuration(1000);
        rotate1.setRepeatCount(0);
        snowMov1.addAnimation(rotate1);
        snowMov1.setFillAfter(true);*/

       for(i=0;i<height;i++) {
            TranslateAnimation trans1 = new TranslateAnimation(
                    Animation.RELATIVE_TO_PARENT, 0f+imageView.getX(),
                    Animation.RELATIVE_TO_PARENT, (-0.1f+i),
                    Animation.RELATIVE_TO_PARENT, 0f+imageView.getY(),
                    Animation.RELATIVE_TO_PARENT, -0.1f+i);
            trans1.setDuration(1000);
            trans1.setRepeatCount(0);
            //snowMov1.addAnimation(trans1);
            trans1.setFillAfter(true);
            imageView.startAnimation(trans1);

        }

    }
}

















