package mlv.tp2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Florian on 10/12/2014.
 */
public class Luncher extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.luncher);
    }

    public void goToForm(View view ){
        Intent intent = new Intent(this,Formulaire.class);
        startActivity(intent);


    }

    public void goToChrono(View view){
        Intent intent = new Intent(this,Chrono.class);
        startActivity(intent);
    }

    public void goToBarbouille(View view){
        Intent intent = new Intent(this,Barbouille.class);
        startActivity(intent);
    }
}