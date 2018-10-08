package liziqiang.bawei.com.liziqiang20181008;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.lang.reflect.GenericArrayType;


public class WaertView extends View{
    private Paint mTopPaint,mBottomPaint;
    private int color_01,color_02;
    private Path mTopPath,mBottomPath;
    private float φ;
    public WaertView(Context context) {
        super(context);
        initData(context);
    }

    public WaertView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray ty = context.obtainStyledAttributes(attrs, R.styleable.WaertView);
         color_01 =ty.getColor(R.styleable.WaertView_color_01,0);
         color_02 =ty.getColor(R.styleable.WaertView_color_02,0);
        ty.recycle();
        initData(context);
    }

    public WaertView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData(context);
    }
   private Context context;
    private void initData(Context context) {
    // 添加画笔  第一个
          mTopPaint = new Paint();
          mTopPaint.setColor(color_01);
          mTopPaint.setAntiAlias(true);
     // 第二个
         mBottomPaint = new Paint();
        mBottomPaint.setAntiAlias(true);
        mBottomPaint.setColor(color_02);
        mBottomPaint.setAlpha(60);

        // 设置路径
         mTopPath = new Path();
         mBottomPath = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
      mTopPath.reset();
      mBottomPath.reset();

      // 设置波浪开始位置
     mTopPath.lineTo(getLeft(),getBottom());
     mBottomPath.lineTo(getLeft(),getBottom());

     // 获取每个宽度的度数
        double my = Math.PI*2/getWidth();

        φ-= 0.1f;
        for (int x = 0; x <=getWidth() ; x+=20) {
            float y = (float) (10*Math.cos(my*x+φ)+10);
            mTopPath.lineTo(x,y);
            mBottomPath.lineTo(x, (float) (10*Math.sin(my*x+φ)));
        }
       // 路径 终止位置
        mTopPath.moveTo(getRight(),getBottom());
        mBottomPath.moveTo(getRight(),getBottom());

        canvas.drawPath(mTopPath,mTopPaint);
        canvas.drawPath(mBottomPath,mBottomPaint);

        // 刷新
        postInvalidateDelayed(20);
    }


}
