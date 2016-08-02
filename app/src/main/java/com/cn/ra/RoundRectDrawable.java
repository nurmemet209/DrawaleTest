package com.cn.ra;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/**
 * Created by nurmemet on 8/1/2016.
 */
public class RoundRectDrawable extends Drawable {
    private Paint mPaint;
    private Bitmap mBitmap;
    private RectF mRectF;

    public RoundRectDrawable(Bitmap bitmap) {
        this.mBitmap = bitmap;
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        Shader shader = new BitmapShader(mBitmap, Shader.TileMode.CLAMP,
                Shader.TileMode.CLAMP);
        mPaint.setShader(shader);
        mRectF=new RectF();
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRoundRect(mRectF, 30, 30, mPaint);
    }

    @Override
    public void setAlpha(int i) {
        mPaint.setAlpha(i);
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {

        mPaint.setColorFilter(colorFilter);
    }

    @Override
    public void setBounds(Rect bounds) {
        super.setBounds(bounds);
        mRectF.set(bounds);
    }

    /**
     * 如果此drawable被设置为视图背景，此方法会被调用,注意区分
     * @param left
     * @param top
     * @param right
     * @param bottom
     */
    @Override
    public void setBounds(int left, int top, int right, int bottom) {
        super.setBounds(left, top, right, bottom);
        mRectF.set(left,top,right,bottom);
    }

    @Override
    public int getOpacity()
    {
        return PixelFormat.TRANSLUCENT;
    }

    @Override
    public int getIntrinsicWidth() {
        return mBitmap.getWidth();
    }

    @Override
    public int getIntrinsicHeight() {
        return mBitmap.getHeight();
    }
}
