package local.hfad.hfad07fragmentsworkout;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class WorkoutListFragment extends ListFragment {

        @Override
        public void onListItemClick(ListView l,
                                    View v,
                                    int position,
                                    long id) {
            if (listener != null) {
                listener.itemClicked(id);
            }
        }

        // Add the own listener to the fragment
        interface WorkoutListListener {
            void itemClicked(long id);
        }

        private WorkoutListListener listener;

    @Override // This happens when the fragment is associated with an activity.
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Initialize listener field of this WorkoutListFragment by operation of casting class of activity to the WorkoutListListener class
        // Here 'activity' is MainActivity which implements this functional interface method
        this.listener = (WorkoutListListener) activity;
    }

    @Override // This is very similar to the activity’s onCreate() method. It can be used to do the initial setup of the fragment.
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // Fragments use a layout inflater to create their view at this stage.
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        // Creating array of data future adapter will work with
        String[] namesArray = new String[Workout.workouts.length];
        for (int i = 0; i < namesArray.length; i++) {
            namesArray[i] = Workout.workouts[i].getName();
        }

        // Creating adapter using namesArray
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                inflater.getContext(),
                android.R.layout.simple_list_item_1,
                namesArray // Adapter will work with this array of data
        );

        // Don't forget to set arrayAdapter
        setListAdapter(arrayAdapter);

        // Calling the superclass onCreateView() method gives you the default layout for the ListFragment.
        return super.onCreateView(
                inflater,
                container,
                savedInstanceState);
    }

    @Override // This method is called when the onCreate() method of the activity has completed.
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
    }
}