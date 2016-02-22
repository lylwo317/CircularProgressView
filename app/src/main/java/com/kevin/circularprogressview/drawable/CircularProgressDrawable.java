package com.kevin.circularprogressview.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

import com.kevin.circularprogressview.R;

/**
 * Created by XieJiaHua on 2016/2/22.
 * Company:PeanutRun Ltd.
 * Email:lylwo317@gmail.com
 */
public class CircularProgressDrawable extends Drawable {

    private int mPadding;
    private int mMinSweepAngle;
    private int mMaxSweepAngle;
    private int mStrokeSize;
    private int mStrokeColor;
    private int mInitialAngle;
    private int mRotateDuration;
    private int mTransformDuration;
    private int mKeepDuration;
    private Interpolator mTransformInterpolator;

    private Paint mPaint;

    private CircularProgressDrawable(int padding,int minSweepAngle,int maxSweepAngle,int strokeSize,int strokeColor, int initialAngle,int rotateDuration,int transformDuration, int keepDuration, Interpolator transformInterpolator){
        mPadding = padding;
        mMinSweepAngle = minSweepAngle;
        mMaxSweepAngle = maxSweepAngle;
        mStrokeSize = strokeSize;
        mStrokeColor = strokeColor;
        mInitialAngle = initialAngle;
        mRotateDuration = rotateDuration;
        mTransformDuration = transformDuration;
        mKeepDuration = keepDuration;
        mTransformInterpolator = transformInterpolator;

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
    }


    @Override
    public void draw(Canvas canvas) {
        drawIndeterminate(canvas);
    }

    private void drawIndeterminate(Canvas canvas) {

    }

    @Override
    public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        mPaint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    public static class Build{
        private int mPadding;
        private int mMinSweepAngle;
        private int mMaxSweepAngle;
        private int mStrokeSize;
        private int mStrokeColor;
        private int mInitialAngle;
        private int mRotateDuration;
        private int mTransformDuration;
        private int mKeepDuration;
        private Interpolator mTransformInterpolator;

        public Build() {

        }

        public Build(Context context, int defStyleRes) {

        }

        public Build(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CircularProgressDrawable, defStyleAttr, defStyleRes);
            setPadding(a.getDimensionPixelSize(R.styleable.CircularProgressDrawable_cpd_padding, 0));
            setMinSweepAngle(a.getInteger(R.styleable.CircularProgressDrawable_cpd_minSweepAngle, 1));
            setMaxSweepAngle(a.getInteger(R.styleable.CircularProgressDrawable_cpd_maxSweepAngle, 270));
            setInitialAngle(a.getInteger(R.styleable.CircularProgressDrawable_cpd_initialAngle, 0));
            setKeepDuration(a.getInteger(R.styleable.CircularProgressDrawable_cpd_keepDuration, context.getResources().getInteger(android.R.integer.config_shortAnimTime)));
            setRotateDuration(a.getInteger(R.styleable.CircularProgressDrawable_cpd_rotateDuration, context.getResources().getInteger(android.R.integer.config_longAnimTime)));
            setTransformDuration(a.getInteger(R.styleable.CircularProgressDrawable_cpd_transformDuration, context.getResources().getInteger(android.R.integer.config_mediumAnimTime)));

        }

        public CircularProgressDrawable build() {
            if (mTransformInterpolator == null) {
                mTransformInterpolator = new DecelerateInterpolator();
            }

            return new CircularProgressDrawable(mPadding,
                    mMinSweepAngle,
                    mMaxSweepAngle,
                    mStrokeSize,
                    mStrokeColor,
                    mInitialAngle,
                    mRotateDuration,
                    mTransformDuration,
                    mKeepDuration,mTransformInterpolator);
        }

        public Build setMaxSweepAngle(int mMaxSweepAngle) {
            this.mMaxSweepAngle = mMaxSweepAngle;
            return this;
        }

        public Build setPadding(int mPadding) {
            this.mPadding = mPadding;
            return this;
        }

        public Build setMinSweepAngle(int mMinSweepAngle) {
            this.mMinSweepAngle = mMinSweepAngle;
            return this;
        }

        public Build setStrokeSize(int mStrokeSize) {
            this.mStrokeSize = mStrokeSize;
            return this;
        }

        public Build setStrokeColor(int mStrokeColor) {
            this.mStrokeColor = mStrokeColor;
            return this;
        }

        public Build setInitialAngle(int mInitialAngle) {
            this.mInitialAngle = mInitialAngle;
            return this;
        }

        public Build setRotateDuration(int mRotateDuration) {
            this.mRotateDuration = mRotateDuration;
            return this;
        }

        public Build setTransformDuration(int mTransformDuration) {
            this.mTransformDuration = mTransformDuration;
            return this;
        }

        public Build setKeepDuration(int mKeepDuration) {
            this.mKeepDuration = mKeepDuration;
            return this;
        }

        public Build setmTransformInterpolator(Interpolator mTransformInterpolator) {
            this.mTransformInterpolator = mTransformInterpolator;
            return this;
        }
    }

}
