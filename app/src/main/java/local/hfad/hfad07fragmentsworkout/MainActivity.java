package local.hfad.hfad07fragmentsworkout;


import android.app.Activity;
import android.app.FragmentTransaction;
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
       WorkoutDetailFragment workoutDetailFragment = new WorkoutDetailFragment();   // Crete fragment programmatically
       workoutDetailFragment.setWorkoutId(id);                                      // Set workoutId for just created new WorkoutDetailFragment()
       FragmentTransaction fragmentTransaction = getFragmentManager()               // To manage Fragments and FragmentsTransactions we need to use FragmentTransaction by calling getFragmentManager()
               .beginTransaction()                                                  // Start the fragment transaction
               .replace(R.id.fragment_container, workoutDetailFragment)             // Replace the fragment if FrameLayout with it's by created workoutDetailFragment above
               .addToBackStack(null)                                                // Add fragmentTransaction to back stack to get 'Back' button work well, The addToBackStack() method takes one parameter, a String name you can use to label the transaction:
               .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);           // Define fragment transition
       fragmentTransaction.commit();                                                // Don't forget to commit all about commit
   }

}