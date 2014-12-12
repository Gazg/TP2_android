package mlv.tp2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by Florian on 10/12/2014.
 */
public class Chrono extends Activity {

    private int startTime;
    //   private Long time;
    private Runnable run;
    private boolean isStart;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chrono);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        startTime = 0;
        isStart=false;
    }

    public void startChrono(final View view) {
        if(!isStart) {
            run = new Runnable() {
                @Override
                public void run() {
                    startTime += 100;
                    MyClockView t = (MyClockView) findViewById(R.id.view);
                    t.setElapsedTime(startTime);
                    t.invalidate();
                    view.postDelayed(this, 100);
                }
            };
            view.postDelayed(run, 100);
            isStart = true;
        }
        /*
        startTime =System.nanoTime();
        run = new Runnable() {
            @Override
            public void run() {
                while(true){
                    TextView t = (TextView) findViewById(R.id.textView);
                    t.setText(String.valueOf(System.nanoTime() - startTime));
                }
            }
        };

        Thread t = new Thread(run);
        t.start();
        */
    }


    public void resetChrono(View view) {
        startTime = 0;
        MyClockView t = (MyClockView) findViewById(R.id.view);
        t.setElapsedTime(startTime);
        t.invalidate();
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:

                break;
            case R.id.reset:
                resetChrono(null);
                break;
            case R.id.start:
                startChrono(findViewById(id));
                break;
            case R.id.stop:
                stopChrono(findViewById(id));
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);

    }


    public void stopChrono(View view) {
        view.removeCallbacks(run);isStart=false;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.chrono,menu);
        return true;
    }
}