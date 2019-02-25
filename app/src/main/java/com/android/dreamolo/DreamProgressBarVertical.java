package com.android.dreamolo;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.*;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

public class DreamProgressBarVertical extends View {
    private OnProgressChangeListener onProgressChangeListener;


    private float circleCenterX;
    private float circleCenterY;
    private float radius;
    private int backgroundColor;
    private String text;
    private int textColor;
    private float textSize;
    private String textFontName;
    private Bitmap progressBitmap;
    private float progress = 50;
    private float maxProgress = 100;
    private int textWidth;
    private int progressLayerWidth;
    private int endLineColor;
    private String progresText;
    private int progressTextColor;
    private float progressTextSize;


    public DreamProgressBarVertical(Context context) {
        super(context);
        init(null);
    }

    public DreamProgressBarVertical(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public DreamProgressBarVertical(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public DreamProgressBarVertical(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(@Nullable AttributeSet set) {

        if (set == null) {
            return;
        }

        TypedArray ta = getContext().obtainStyledAttributes(set, R.styleable.DreamProgressBarHorozontal);
        backgroundColor = ta.getColor(R.styleable.DreamProgressBarHorozontal_progress_backgroundColor, 0);
        radius = ta.getDimension(R.styleable.DreamProgressBarHorozontal_radius, 0);
        text = ta.getString(R.styleable.DreamProgressBarHorozontal_text);
        textColor = ta.getColor(R.styleable.DreamProgressBarHorozontal_textColor, 0);
        textSize = ta.getDimension(R.styleable.DreamProgressBarHorozontal_textSize, 30);
        textFontName = ta.getString(R.styleable.DreamProgressBarHorozontal_textFont);
        progress = ta.getFloat(R.styleable.DreamProgressBarHorozontal_progress, 0);
        maxProgress = ta.getFloat(R.styleable.DreamProgressBarHorozontal_maxProgress, 100);
        endLineColor = ta.getColor(R.styleable.DreamProgressBarHorozontal_endLineColor, 0);
        progressTextColor = ta.getColor(R.styleable.DreamProgressBarHorozontal_progressTextColor, 0);
        progressTextSize = ta.getDimension(R.styleable.DreamProgressBarHorozontal_progressTextSize, 20);


//        setOnTouchListener(this);
    }


    public void setOnProgressChangeListener(OnProgressChangeListener onProgressChangeListener) {
        this.onProgressChangeListener = onProgressChangeListener;
    }

    public void setText(String text) {
        this.text = text;
        invalidate();
    }

    public void setProgresText(String progresText) {
        this.progresText = progresText;
    }


    public String getProgresText() {
        return progresText;
    }

    public int getProgress() {
        return (int) progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
        if (onProgressChangeListener != null) {
            onProgressChangeListener.onProgressChange((int) progress);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
        progressBitmap = createProgressGradient();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawBackground(canvas);
        drawProgress(canvas);
        drawTexts(canvas);
        drawEndLine(canvas);
        drawProgressText(canvas);
    }

    private void drawBackground(Canvas canvas) {
        Paint p = new Paint();
        p.setColor(backgroundColor);

        canvas.drawPath(getRoundPath(), p);
    }

    private void drawTexts(Canvas canvas) {

        Paint paint = new Paint();
        paint.setColor(textColor);
        paint.setTextSize(textSize);
        textWidth = (int) paint.measureText(text);


        if (textFontName != null) {
            Typeface typeface = Typeface.createFromAsset(getResources().getAssets(), textFontName);
            paint.setTypeface(typeface);
        }


        int y = (int) ((getMeasuredHeight() / 2) - ((paint.descent() + paint.ascent()) / 2));
        canvas.drawText(text, 30, y, paint);
    }

    private void drawProgress(Canvas canvas) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        progressLayerWidth = (int) ((progress * getMeasuredWidth()) / maxProgress);
        Rect rect = new Rect(0, 0, progressLayerWidth, getMeasuredHeight());

        canvas.drawBitmap(progressBitmap, rect, rect, paint);
    }


    private void drawEndLine(Canvas canvas) {
        if (progressLayerWidth > textWidth + 30 + 40 && progressLayerWidth < getMeasuredWidth() - radius) // 30 is distance between text and left edge, 40 is saving space for end line
        {
            Paint paint = new Paint();
            paint.setColor(endLineColor);
            int lineWidth = (int) dpToPx(1);

            canvas.drawRect(progressLayerWidth - dpToPx(8), dpToPx(8),
                    (progressLayerWidth - dpToPx(8)) + lineWidth, getMeasuredHeight() - dpToPx(8),
                    paint);
        }
    }


    private void drawProgressText(Canvas canvas) {
        if(progresText == null || progresText.length() == 0)
        {
            return;
        }

        Paint paint = new Paint();
        paint.setColor(progressTextColor);
        paint.setTextSize(progressTextSize);
        int textWidth = (int) paint.measureText(progresText);

        if (textFontName != null) {
            Typeface typeface = Typeface.createFromAsset(getResources().getAssets(), textFontName);
            paint.setTypeface(typeface);
        }

        int x = (getMeasuredWidth() - textWidth) / 2;
        int y = (int) ((getMeasuredHeight() / 2) - ((paint.descent() + paint.ascent()) / 2));
        canvas.drawText(progresText, x, y, paint);
    }


    private Path getRoundPath() {
        RectF rect = new RectF(0, 0, getMeasuredWidth(), getMeasuredHeight());
        final float[] arrayRadius = {radius, radius, radius, radius, radius, radius, radius, radius};

        Path path = new Path();
        path.addRoundRect(rect, arrayRadius, Path.Direction.CW);

        return path;
    }


    private Bitmap createProgressGradient() {
        LinearGradient gradient = new LinearGradient(0, getMeasuredHeight() / 2,
                getMeasuredWidth(), getMeasuredHeight() / 2,
                new int[]{Color.parseColor("#FF004790"),
                        Color.parseColor("#FF0071bc")},
                null, Shader.TileMode.CLAMP);
        Paint p = new Paint();
        p.setDither(true);
        p.setShader(gradient);

        Bitmap bitmap = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawPath(getRoundPath(), p);

        return bitmap;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                setProgress((maxProgress * event.getX()) / getMeasuredWidth());
                if (progress > maxProgress) setProgress(maxProgress);
                if (progress < 0) setProgress(progress = 0);
                invalidate();
                break;
        }
        return true;
    }


    private float dpToPx(int dp) {
        Resources r = getResources();
        return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp,
                r.getDisplayMetrics()
        );
    }


    public interface OnProgressChangeListener {
        void onProgressChange(int progress);
    }
}
