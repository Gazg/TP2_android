package mlv.tp2;

import android.content.Context;
import android.graphics.*;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Florian on 10/12/2014.
 */
public class MyClockView extends View {
   int timePass;
    Paint myPaint;
    int width=0;
    int height=0;

    private Drawable superclock;

  public MyClockView(Context context,AttributeSet attrs){

      super(context,attrs);
      timePass=0;
      myPaint = new Paint();
      myPaint.setColor(Color.RED);

      superclock = getResources().getDrawable(R.drawable.cadran);



  }



    public void setElapsedTime(int time){
        timePass=time;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width=MeasureSpec.getSize(widthMeasureSpec);
        height=MeasureSpec.getSize(heightMeasureSpec);
        superclock.setBounds(0,0,width,height);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int angle = ((timePass * 360) / 60000)%360;
        superclock.draw(canvas);
        canvas.save();
        canvas.translate((width/2),height/2);
        canvas.rotate(angle);
        canvas.drawRect(-2,(-height/2)+height/10,2,0,myPaint);
        canvas.restore();
    }
}
