package local.hfad.hfad07fragmentsworkout;

import android.app.Activity;
import android.os.Bundle;

public class DetailActivity extends Activity {

    public static final String WORKOUT_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        WorkoutDetailFragment workoutDetailFragment =
                (WorkoutDetailFragment) getFragmentManager()
                        .findFragmentById(R.id.detail_fragment);
        int workoutId = (int) getIntent().getExtras().get(WORKOUT_ID);
        workoutDetailFragment.setWorkoutId(workoutId);
    }
}