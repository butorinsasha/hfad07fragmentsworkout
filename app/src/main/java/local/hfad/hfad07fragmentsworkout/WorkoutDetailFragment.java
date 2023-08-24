package local.hfad.hfad07fragmentsworkout;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class WorkoutDetailFragment extends Fragment {

    private long workoutId;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // Fragments create their Views (not visible so far) at the stage of onCreateView() so inflater.inflate should be overridden here
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        // Rotation of a device doesn't lose information about current workoutId
        // because we save it in savedInstanceState
        if (savedInstanceState != null) {
            workoutId = savedInstanceState.getLong("workoutId");
        } else {
            StopwatchFragment stopwatchFragment = new StopwatchFragment();
            FragmentTransaction stopwatchFragmentTransaction = getChildFragmentManager().beginTransaction()
                    .replace(R.id.stopwatch_container, stopwatchFragment)
                    .addToBackStack(null)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            stopwatchFragmentTransaction.commit();
        }
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override // The onStart() method is called when the fragment is about to become visible so setText() here.
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            Workout workout = Workout.workouts[(int) workoutId];

            TextView title = view.findViewById(R.id.text_title);
            title.setText(workout.getName());

            TextView description = view.findViewById(R.id.text_description);
            description.setText(workout.getDescription());
        }
    }


    // Rotation of a device doesn't lose information about current workoutId
    // because we save it in savedInstanceState
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putLong("workoutId", workoutId);
    }

    public void setWorkoutId(long workoutId) {
        this.workoutId = workoutId;
    }
}