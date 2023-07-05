package local.hfad.hfad07fragmentsworkout;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class WorkoutListFragment extends ListFragment {


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        // Creating array of data future adapter will work with
        String[] namesArray = new String[Workout.workouts.length];
        for (int i = 0; i < namesArray.length; i++) {
            namesArray[i] = Workout.workouts[i].getName();
        }

        // Creating adapter
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                inflater.getContext(),
                android.R.layout.simple_list_item_1,
                namesArray // Adapter will work with this array of data
        );

        setListAdapter(arrayAdapter);

        // Calling the superclass onCreateView() method gives you the default layout for the ListFragment.
        return super.onCreateView(
                inflater,
                container,
                savedInstanceState);
    }
}