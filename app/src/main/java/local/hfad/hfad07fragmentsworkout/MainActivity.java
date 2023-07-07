package local.hfad.hfad07fragmentsworkout;


import android.app.Activity;
import android.os.Bundle;
                                           // Then make the activity implement the interface
public class MainActivity extends Activity implements WorkoutListFragment.WorkoutListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

   @Override
   public void itemClicked(long id) {
       //The code to set the detail will go here
   }

}