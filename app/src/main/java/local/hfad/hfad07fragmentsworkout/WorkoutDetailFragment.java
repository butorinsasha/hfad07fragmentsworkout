package local.hfad.hfad07fragmentsworkout;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class WorkoutDetailFragment extends Fragment {

    private long workoutId;

    @Override // Fragments create thier Views (not visible so far) at the stage of onCreateView() so inflater.inflate should be ovveriden here
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    @Override // The onStart() method is called when the fragment is about to become visible so setText() here.
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            Workout workout = Workout.workouts[(int) workoutId];

            TextView title = (TextView) view.findViewById(R.id.text_title);
            title.setText(workout.getName());

            TextView description = view.findViewById(R.id.text_description);
            description.setText(workout.getDescription());
        }
    }

    public void setWorkoutId(long workoutId) {
        this.workoutId = workoutId;
    }
}