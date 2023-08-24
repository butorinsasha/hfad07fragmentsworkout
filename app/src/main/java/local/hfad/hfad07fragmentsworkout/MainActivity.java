package local.hfad.hfad07fragmentsworkout;


import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
            WorkoutDetailFragment workoutDetailFragment = new WorkoutDetailFragment();                      // Crete fragment programmatically
            workoutDetailFragment.setWorkoutId(id);                                                         // Set workoutId for just created new WorkoutDetailFragment()
            Log.i(this.getClass().getSimpleName(), "workoutDetailFragmentTransaction is about to begin");
            FragmentTransaction workoutDetailFragmentTransaction = getFragmentManager()                     // To manage Fragments and FragmentsTransactions we need to use FragmentTransaction by calling getFragmentManager()
                    .beginTransaction()                                                                     // Start the fragment transaction
                    .replace(R.id.fragment_container, workoutDetailFragment)                                // Replace the fragment if FrameLayout with it's by created workoutDetailFragment above
                    .addToBackStack(null)                                                                   // Add workoutDetailFragmentTransaction to back stack to get 'Back' button work well, The addToBackStack() method takes one parameter, a String name you can use to label the transaction:
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);                              // Define fragment transition
            workoutDetailFragmentTransaction.commit();                                                      // Don't forget to commit all about commit
            Log.i(this.getClass().getSimpleName(), "workoutDetailFragmentTransaction committed");

            WorkoutDetailFragment workoutDetailFragment2 = new WorkoutDetailFragment();                      // Crete fragment programmatically
            workoutDetailFragment.setWorkoutId(id);                                                         // Set workoutId for just created new WorkoutDetailFragment()
            Log.i(this.getClass().getSimpleName(), "workoutDetailFragmentTransaction2 is about to begin");
            FragmentTransaction workoutDetailFragmentTransaction2 = getFragmentManager()                     // To manage Fragments and FragmentsTransactions we need to use FragmentTransaction by calling getFragmentManager()
                    .beginTransaction()                                                                     // Start the fragment transaction
                    .replace(R.id.fragment_container2, workoutDetailFragment2)                                // Replace the fragment if FrameLayout with it's by created workoutDetailFragment above
                    .addToBackStack(null)                                                                   // Add workoutDetailFragmentTransaction to back stack to get 'Back' button work well, The addToBackStack() method takes one parameter, a String name you can use to label the transaction:
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);                              // Define fragment transition
            workoutDetailFragmentTransaction2.commit();                                                      // Don't forget to commit all about commit
            Log.i(this.getClass().getSimpleName(), "workoutDetailFragmentTransaction2 committed");

        } else {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.WORKOUT_ID, (int) id);
            startActivity(intent);
        }
   }

}