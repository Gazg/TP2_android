package mlv.tp2;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.MotionEvent;

/**
 * Created by Florian on 11/12/2014.
 */
public class Barbouille extends Activity {

    private Bitmap save=null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.barbouille_layout);
        BarbouilleView t = (BarbouilleView) findViewById(R.id.view);
        t.setDrawingCacheEnabled(true);
    }

    @Override
    protected void onPause() {
        super.onPause();
        BarbouilleView t = (BarbouilleView) findViewById(R.id.view);
       save = t.getDrawingCache();
    }


    @Override
    protected void onResume() {
        super.onResume();
        if(save!=null) {
            final BarbouilleView t = (BarbouilleView) findViewById(R.id.view);
            Canvas c = new Canvas(save);
            t.draw(c);
        }

    }
}