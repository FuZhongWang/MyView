package com.example.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MyYuan extends View {
    private Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            index++;
            Log.e("fzw","s="+degree+"");
            for (int i = 0; i < listdeg.size(); i++) {
                Log.e("fzw","a="+degree+"");
                int six = (i+index);
                paint.setColor(Colors.get(six%listdeg.size()));
                Log.e("fzw","q="+degree+"");
                canvas.drawArc(rectF,degree,listdeg.get(i),true,paint);
                Log.e("fzw","w="+degree+"");
                degree=listdeg.get(i)+degree;
                if (degree==360){

                    degree=0;
                }
                
            }
        }
    };

    int naocan = 0;
    int degree=0;
    int index=0;
    private ArrayList<Integer> listdeg;
    private ArrayList<Integer> Colors;
    private RectF rectF;
    private Paint paint;
    private Canvas canvas;
    private ArrayList<Integer> listadd;
    private float measuredWidth;
    private float measuredHeight;
    private int six;

    public MyYuan(Context context) {
        this(context,null);
    }

    public MyYuan(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyYuan(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        intiView();
    }
    public void intiView(){

        listadd = new ArrayList<>();
        listdeg = new ArrayList<>();
        listdeg.add(60);
        listdeg.add(60);
        listdeg.add(60);
        listdeg.add(60);
        listdeg.add(60);
        listdeg.add(60);
        listadd.addAll(listdeg);
        Colors = new ArrayList<>();
        Colors.add(Color.BLACK);
        Colors.add(Color.BLUE);
        Colors.add(Color.CYAN);
        Colors.add(Color.DKGRAY);
        Colors.add(Color.GREEN);
        Colors.add(Color.LTGRAY);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas=canvas;
        rectF = new RectF(-200, -200, 200, 200);
        paint = new Paint();
        six = 6;
       /* if (six ==6){
        canvas.translate(measuredWidth/2,measuredHeight/2);}else{
            canvas.translate(measuredWidth,measuredHeight);

        }*/
        canvas.translate(measuredWidth,measuredHeight);
        canvas.rotate(naocan);
        for (int i = 0; i < listdeg.size(); i++) {
            paint.setColor(Colors.get(i));
            canvas.drawArc(rectF,degree,listdeg.get(i),true,paint);
            degree=listdeg.get(i)+degree;
            if (degree==360){

                degree=0;
            }
        }




    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measuredWidth = getMeasuredWidth();
        measuredHeight = getMeasuredHeight();
    }


    @Override
        public boolean onTouchEvent(MotionEvent event) {

            switch (event.getAction())
            {
                case MotionEvent.ACTION_DOWN:
                    Log.e("你瞅啥，谁愁谁脑残", "onTouchEvent: "+ event.getRawX());
                  /*  xuanzhuan();*/

                    ;break;
                case MotionEvent.ACTION_UP:
                    Log.e("你瞅啥，谁愁谁脑残", "ACTION_UP: ");
                    ;break;
                case MotionEvent.ACTION_MOVE:
                    Log.e("你瞅啥，谁愁谁脑残", "ACTION_HOVER_MOVE: ");
                    float rawX = event.getRawX();
                    float rawY = event.getRawY();
                    six=5;
                    measuredWidth=rawX;
                    measuredHeight=rawY;
                    invalidate();
                    break;

            }
            return true;
        }
        public void xuanzhuan(){
            Timer timer = new Timer();
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    naocan+=60;
                    postInvalidate();
                }
            };
            timer.schedule(timerTask,2000,50);
        }
        public void tuodong(){

            float y = getY();
            float x = getX();

        }

}
