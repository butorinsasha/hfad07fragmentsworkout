package local.hfad.hfad07fragmentsworkout;

import static android.widget.Toast.LENGTH_SHORT;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class StopwatchFragment extends Fragment implements View.OnClickListener {

    private int seconds = 0;
    private boolean isRunning; // false (default)
    private boolean wasRunning; // false (default)
    private View greenBulb;
    private View yellowBulb;
    private View redBulb;
    Button startStopButton;
    Button resetButton;
    TextView timeView;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i(this.toString(), "StopwatchFragment.onCreate()");
        Toast.makeText(this.getContext(), "StopwatchFragment.onCreate()", LENGTH_SHORT).show();

        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");
            isRunning = savedInstanceState.getBoolean("isRunning");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }

        Log.i(this.toString(), "isRunning = " + isRunning);
        Log.i(this.toString(), "wasRunning = " + wasRunning);

        runTimer();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(this.toString(), "StopwatchFragment.onCreateView()");
        Toast.makeText(this.getContext(), "StopwatchFragment.onCreateView()", LENGTH_SHORT).show();

        View layout = inflater.inflate(R.layout.fragment_stopwatch, container, false);

            // Just interesting...
            View layout2 = getView();
            Log.i(this.toString(),  "layout.equals(layout2) = " + layout.equals(layout2)); // false... hmm???
            Log.i(this.toString(),  "container.equals(layout2) = " + container.equals(layout2)); // also false... hmm???

        greenBulb = layout.findViewById(R.id.green_bulb_view);
        yellowBulb = layout.findViewById(R.id.yellow_bulb_view);
        redBulb = layout.findViewById(R.id.red_bulb_view);

        startStopButton = layout.findViewById(R.id.start_stop_button);
        startStopButton.setOnClickListener(this);

        resetButton = layout.findViewById(R.id.reset_button);
        resetButton.setOnClickListener(this);

        timeView = layout.findViewById(R.id.time_view);

        return layout;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onStart() {
        super.onStart();

        Log.i(this.toString(), "StopwatchFragment.onStart()");
        Toast.makeText(this.getContext(), "StopwatchFragment.onStart()", LENGTH_SHORT).show();


        Log.i(this.toString(), "7. wasRunning = " + wasRunning);
        Log.i(this.getClass().getName(), "8. isRunning = " + isRunning);

        if(wasRunning) {
            isRunning = true;
        }

        Log.i(this.toString(), "9. wasRunning = " + wasRunning);
        Log.i(this.toString(), "10. isRunning = " + isRunning);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onResume() {
        super.onResume();

        Log.i(this.toString(), "StopwatchFragment.onResume()");
        Toast.makeText(this.getContext(), "StopwatchFragment.onResume()", LENGTH_SHORT).show();

        if(wasRunning){
            isRunning = true;
            startStopButton.setText(R.string.stop);
        } else {
            setTime(seconds);
            lightBulb(seconds);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onPause() {
        super.onPause();

        Log.i(this.toString(), "StopwatchFragment.onPause()");
        Toast.makeText(this.getContext(), "StopwatchFragment.onPause()", LENGTH_SHORT).show();

        wasRunning = isRunning;
        isRunning = false;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        Log.i(this.toString(), "StopwatchFragment.onSaveInstanceState()");
        Toast.makeText(this.getContext(), "StopwatchFragment.onSaveInstanceState()", LENGTH_SHORT).show();

        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("isRunning", isRunning);
        savedInstanceState.putBoolean("wasRunning", wasRunning);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onStop() {
        super.onStop();

        Log.i(this.toString(), "StopwatchFragment.onStop()");
        Toast.makeText(this.getContext(), "StopwatchFragment.onStop()", LENGTH_SHORT).show();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.i(this.getClass().getName(), "30. wasRunning = " + wasRunning);
        Log.i(this.getClass().getName(), "31. isRunning = " + isRunning);

        Log.i(this.toString(), "StopwatchFragment.onDestroy()");
        Toast.makeText(this.getContext(), "StopwatchFragment.onDestroy()", LENGTH_SHORT).show();

        Log.i(this.getClass().getName(), "32. wasRunning = " + wasRunning);
        Log.i(this.getClass().getName(), "33. isRunning = " + isRunning);
    }

    public void onClickStartStop(View view) {
        Log.i(this.toString(), "At the start of onClickStartStop(); isRunning=" + isRunning);
        if (!isRunning) {
            isRunning = true;
            startStopButton.setText(R.string.stop);
        } else {
            isRunning = false;
            startStopButton.setText(R.string.start);
        }
        Log.i(this.toString(), "At the end of onClickStartStop(); isRunning=" + isRunning);
    }

    public void onClickReset(View view) {
        isRunning = false;
        seconds = 0;
        setTime(seconds);
        startStopButton.setText(R.string.start);
        greenBulb.setBackgroundColor(getResources().getColor(R.color.grey));
        yellowBulb.setBackgroundColor(getResources().getColor(R.color.grey));
        redBulb.setBackgroundColor(getResources().getColor(R.color.grey));
    }

    private void setTime(int seconds) {
        int hours = seconds / 3600;
        int mins = (seconds % 3600) / 60;
        int secs = seconds % 60;
        String time = String.format("%d:%02d:%02d", hours, mins, secs);
        timeView.setText(time);
    }

    private void runTimer() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
                         @Override
                         public void run() {
                             Log.i(this.getClass().getName(), "in run() of runTimer()");
                             if (isRunning) {
                                 seconds++;
                                 Log.i(this.getClass().getName(), "isRunning = " + isRunning);
                                 setTime(seconds);
                                 lightBulb(seconds);
                             }
                             Log.i(this.getClass().getName(), "isRunning = " + isRunning);
                             handler.postDelayed(this, 1000);
                         }
                     }
        );
    }

    private void lightBulb(int seconds) {
        if (seconds == 0) {
            Log.i(this.toString(), "Switch green");
            greenBulb.setBackgroundColor(getResources().getColor(R.color.grey));
            yellowBulb.setBackgroundColor(getResources().getColor(R.color.grey));
            redBulb.setBackgroundColor(getResources().getColor(R.color.grey));
        } else {
            switch (seconds % 3){
                case (1):
                    Log.i(this.toString(), "Switch green");
                    greenBulb.setBackgroundColor(getResources().getColor(R.color.green));
                    yellowBulb.setBackgroundColor(getResources().getColor(R.color.grey));
                    redBulb.setBackgroundColor(getResources().getColor(R.color.grey));
                    break;
                case (2):
                    Log.i(this.getClass().getName(), "Switch yellow");
                    greenBulb.setBackgroundColor(getResources().getColor(R.color.grey));
                    yellowBulb.setBackgroundColor(getResources().getColor(R.color.yellow));
                    redBulb.setBackgroundColor(getResources().getColor(R.color.grey));
                    break;
                case (0):
                    Log.i(this.getClass().getName(), "Switch red");
                    greenBulb.setBackgroundColor(getResources().getColor(R.color.grey));
                    yellowBulb.setBackgroundColor(getResources().getColor(R.color.grey));
                    redBulb.setBackgroundColor(getResources().getColor(R.color.red));
                    break;
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start_stop_button:
                onClickStartStop(view);
                break;
            case R.id.reset_button:
                onClickReset(view);
                break;
        }
    }
}