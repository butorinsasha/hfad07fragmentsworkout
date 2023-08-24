package local.hfad.hfad07fragmentsworkout;


import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

// Then make the activity implement the interface
public class MainActivity extends Activity implements WorkoutListFragment.WorkoutListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

   @Override
   public void itemClicked(long id) {
        View fragmentContainer = findViewById(R.id.fragment_container);
        if (fragmentContainer != null) {
            WorkoutDetailFragment workoutDetailFragment = new WorkoutDetailFragment();   // Crete fragment programmatically
            workoutDetailFragment.setWorkoutId(id);                                      // Set workoutId for just created new WorkoutDetailFragment()
            FragmentTransaction workoutDetailFragmentTransaction = getFragmentManager()               // To manage Fragments and FragmentsTransactions we need to use FragmentTransaction by calling getFragmentManager()
                    .beginTransaction()                                                  // Start the fragment transaction
                    .replace(R.id.fragment_container, workoutDetailFragment)             // Replace the fragment if FrameLayout with it's by created workoutDetailFragment above
                    .addToBackStack(null)                                                // Add workoutDetailFragmentTransaction to back stack to get 'Back' button work well, The addToBackStack() method takes one parameter, a String name you can use to label the transaction:
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);           // Define fragment transition
            workoutDetailFragmentTransaction.commit();                                                // Don't forget to commit all about commit
        } else {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.WORKOUT_ID, (int) id);
            startActivity(intent);
        }
   }

}