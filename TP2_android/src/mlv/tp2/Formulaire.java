package mlv.tp2;

import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class Formulaire extends Activity {

    boolean hpa = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulaire);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        refreshData();
    }
    
    
    public void refreshData(){

    	Calendar c = Calendar.getInstance(); 
    	TextView tv = (TextView)this.findViewById(R.id.editText1);
    	tv.setText(c.get(Calendar.DAY_OF_MONTH) + "/" + (c.get(Calendar.MONTH)+1) +"/" + c.get(Calendar.YEAR));
    	TextView tv2 = (TextView)this.findViewById(R.id.editText2);
    	tv2.setText(c.get(Calendar.HOUR)+":"+c.get(Calendar.MINUTE));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.formulaire, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
		case R.id.action_settings:
			
			break;
		case R.id.refresh:
			refreshData();
			break;
		default:
			break;
		}
        return super.onOptionsItemSelected(item);
    }
    
    public void sendData(View v){
    	TextView tv = (TextView)this.findViewById(R.id.editText1);
    	TextView tv2 = (TextView)this.findViewById(R.id.editText2);
    	TextView tv3 = (TextView)this.findViewById(R.id.editText3);
    	TextView tv4= (TextView)this.findViewById(R.id.editText4);
    	String content = "Date: " + tv.getText() + "\nHeure: " + tv2.getText() + "\nTentsion systolique: " +tv3.getText() +"\nTension dystolique: " +tv4.getText();
    	Toast.makeText(this, content , Toast.LENGTH_LONG).show();
    }


    public void mmhgOn(View v){

        hpa =false;
        TextView tv = (TextView) this.findViewById(R.id.editText4);
        try {
            double value = Double.valueOf(tv.getText().toString());
            value = (value / 1.333224);
            tv.setText(String.valueOf(value));
        }catch (NumberFormatException e){


        }
    }


    public void hpaOn(View v){

        hpa =true;
        TextView tv = (TextView) this.findViewById(R.id.editText4);
        try {
            double value = Double.valueOf(tv.getText().toString());
            value *= 1.333224;
            tv.setText(String.valueOf(value));
        }catch (NumberFormatException e){


        }
    }
}
