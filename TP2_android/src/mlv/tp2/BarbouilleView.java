package mlv.tp2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Florian on 11/12/2014.
 */
public class BarbouilleView extends View{
    private Paint firstFinger;
    private Paint secondFinger;
    private Paint thirdFinger;

    private HashMap<Map.Entry<Integer,Integer>,Integer> grid;
    public BarbouilleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        firstFinger = new Paint();
        secondFinger = new Paint();
        thirdFinger=new Paint();

        firstFinger.setColor(Color.BLUE);
        secondFinger.setColor(Color.GREEN);
        thirdFinger.setColor(Color.RED);
       grid = new HashMap<Map.Entry<Integer, Integer>, Integer>();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction() & MotionEvent.ACTION_MASK)
        {
            case MotionEvent.ACTION_DOWN :
                grid.put(new AbstractMap.SimpleEntry<Integer, Integer>((int)event.getX(),(int)event.getY()),event.getPointerId(event.getActionIndex()));
                invalidate((int)event.getX(),(int)event.getY(),(int)event.getX(),(int)event.getY());
                break;
            case MotionEvent.ACTION_POINTER_DOWN :
                grid.put(new AbstractMap.SimpleEntry<Integer, Integer>((int)event.getX(),(int)event.getY()),event.getPointerId(event.getActionIndex()));
                break;
            case MotionEvent.ACTION_MOVE :
                int x = event.getPointerCount();
                for (int i= 0;i<x;i++){
                    int index = event.getPointerId(i);
                    grid.put(new AbstractMap.SimpleEntry<Integer, Integer>((int)event.getX(index),(int)event.getY(index)),index);
                }
                break;
            case MotionEvent.ACTION_POINTER_UP :

            case MotionEvent.ACTION_UP :

        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int left,right,top,bot;
        left = canvas.getClipBounds().left;
        right = canvas.getClipBounds().right;
        top = canvas.getClipBounds().top;
        bot = canvas.getClipBounds().bottom;


        Integer index = grid.get(new AbstractMap.SimpleEntry<Integer, Integer>(top,right));
        if(index!=null){
            //draw

        }

    }
}
