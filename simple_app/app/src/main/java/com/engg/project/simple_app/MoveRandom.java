package com.engg.project.simple_app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by madhushreet on 06-02-2019.
 */

public class MoveRandom extends AppCompatActivity {
    private Game game;
    @SuppressLint("HandlerLeak")
    public Handler updateHandler = new Handler(){
        /** Gets called on every message that is received */
        // @Override
        public void handleMessage(Message msg) {
            game.update();
            game.invalidate();
            super.handleMessage(msg);
        }
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        game = new Game(this);
        setContentView(game);

        Thread myThread = new Thread(new UpdateThread());
        myThread.start();

    }

    public class UpdateThread implements Runnable {

        @Override
        public void run() {

            while(true){
                try {
                    Thread.sleep(100);
                }
                catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                MoveRandom.this.updateHandler.sendEmptyMessage(0);

            }

        }

    }

}


class Game extends View {

    private Bitmap image;
    private Paint paint;
    private int x=0;

    public Game(Context context) {
        super(context);
        image = Bitmap.createBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.dot));
        paint = new Paint();
    }

    // called every Frame
    protected void onDraw(Canvas canvas) {
            canvas.drawBitmap(image, mImagePos.x, mImagePos.y, paint);
    }
    PointF mImagePos = new PointF();
    PointF mImageSource = new PointF();
    PointF mImageTarget = new PointF();
    long mInterpolateTime;
    // called by thread
    public void update() {
        final long INTERPOLATION_LENGTH = 1000;
        long time = SystemClock.uptimeMillis();
        if (time - mInterpolateTime > INTERPOLATION_LENGTH) {
            mImageSource.set(mImageTarget);
            mImageTarget.x = (float)(Math.random()*200);
            mImageTarget.y = (float)(Math.random()*500);
            mInterpolateTime = time;
        }

        float t = (float)(time - mInterpolateTime) / INTERPOLATION_LENGTH;
        t = t * t * (3 - 2 * t);

        mImagePos.x = mImageSource.x + (mImageTarget.x - mImageSource.x) * t;
        mImagePos.y = mImageSource.y + (mImageTarget.y - mImageSource.y) * t;



    }

}



