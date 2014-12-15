package mlv.tp2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Florian on 11/12/2014.
 */
public class BarbouilleView extends View{
    private Paint myPaint;
    private ArrayList<Point> points ;


    public BarbouilleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        myPaint = new Paint();
        points = new ArrayList<Point>();

    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float  x;
        float y;
        switch (event.getAction() & MotionEvent.ACTION_MASK)
        {
            case MotionEvent.ACTION_DOWN :
                points.add(new Point(event.getX(),event.getY(),Color.BLUE));
                break;
            case MotionEvent.ACTION_POINTER_DOWN :
             x  = event.getX();
                 y = event.getY();
                switch (event.getPointerId(event.getActionIndex())){
                    case 1:
                        points.add(new Point(x, y, Color.GREEN));
                        break;
                    case 2:
                        points.add(new Point(x, y, Color.RED));
                        break;
                    default:
                        //ffs
                        break;
                }
                break;
            case MotionEvent.ACTION_MOVE :
                int j = event.getPointerCount();
                for (int i= 0;i<j;i++){

                    int id = event.getPointerId(i);
                    x= event.getX(event.findPointerIndex(id));
                    y = event.getY(event.findPointerIndex(id));
                    switch (id){
                        case 0:
                            points.add(new Point(x, y, Color.BLUE));
                            break;
                        case 1:
                            points.add(new Point(x, y, Color.GREEN));
                            break;
                        case 2:
                            points.add(new Point(x, y, Color.RED));
                            break;
                        default:
                            //ffs
                            break;
                    }
                }
                break;

        }
        invalidate();
        return true;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        for (Point point : points) {
            myPaint.setColor(point.getColor());
            canvas.drawCircle(point.getX(),point.getY(),10,myPaint);
        }

    }


}
