package com.example.myview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

class FanshapedView extends View  {
    //矩形，画扇形的时候需要传入的参数
    private RectF rectf;
    //此view的高度
    private int higth;
    //此view的宽度
    private int wide;

    private int absy;
    private int absx;
    //按下时的x,y的值
    private int downy;
    private int downx;
    //抬起时的x,y的值
    private int upx;
    private int upy;
    //用于计算点击处的角度
    private int tanx;
    private int tany;
    //中心点
    private int centerx;
    private int centery;
    //按下时x,y相对于中心点的坐标
    private int coordinatex;
    private int coordinatey;
    //扇形的半径
    private int radius;
    //监听器

    //扇形的弧度
    private ArrayList<Integer> arraydegrees;
    //扇形的颜色
    private  ArrayList<Integer>  arraycolor;
    public FanshapedView(Context context) {
        super(context);
        rectf = new RectF(0, 0, 500, 500);
    }

    @SuppressLint("ClickableViewAccessibility")
    public FanshapedView(Context context, AttributeSet attrs) {
        super(context, attrs);

        arraydegrees=new ArrayList<Integer>();
        arraycolor=new ArrayList<Integer>();

        arraydegrees.add(45);
        arraycolor.add(Color.BLACK);

        arraydegrees.add(45);
        arraycolor.add(Color.BLUE);

        arraydegrees.add(90);
        arraycolor.add(Color.CYAN);

        arraydegrees.add(90);
        arraycolor.add(Color.DKGRAY);

        arraydegrees.add(60);
        arraycolor.add(Color.GREEN);

        arraydegrees.add(30);
        arraycolor.add(Color.LTGRAY);
    }


    /*这里多说一点，得到view的宽高，不能在构造函数中得到， 因为在构造函数中还不知道view的大小，所以得不到，在onMeasure与onLayout中都可以得到
     * getMeasuredHeight和getHeight两个都可以得到高度，至于有什么区别  百度一下吧。
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
    @SuppressLint("DrawAllocation")
    @Override
    protected void onLayout(boolean changed, int left, int top, int right,int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (changed) {
            //得到这个view的宽高；
            higth = this.getMeasuredHeight();
            wide = this.getMeasuredWidth();
            //算出中心点与半径
            centerx=radius=wide/2;
            centery=higth/2;
            //创建矩形
            rectf = new RectF(0, 0, higth, wide);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 创建画笔
        Paint p = new Paint();
        int degree=0;
        for (int i = 0; i < arraydegrees.size(); i++){
            // 设置红色
            p.setColor(arraycolor.get(i));
            // 画弧，第一个参数是RectF：该类是第二个参数是角度的开始，第三个参数是多少度，第四个参数是真的时候画扇形，是假的时候画弧线，第五个是画笔
            canvas.drawArc(rectf, degree, arraydegrees.get(i), true, p);
            degree=arraydegrees.get(i)+degree;
        }
    }
   }