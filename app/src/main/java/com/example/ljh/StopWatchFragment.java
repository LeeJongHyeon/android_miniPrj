package com.example.ljh;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ScrollView;
import android.widget.TextView;


public class StopWatchFragment extends Fragment implements View.OnClickListener {
    Chronometer chronometer;
    TextView textView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_stop_watch, container, false);

        chronometer = (Chronometer) v.findViewById(R.id.chronometer_view);
        Button startBtn = v.findViewById(R.id.start_button);
        Button stopBtn = v.findViewById(R.id.stop_button);
        Button resetBtn = v.findViewById(R.id.reset_button);
        Button writeBtn = v.findViewById(R.id.write_button);

        ScrollView scrollView = v.findViewById(R.id.scroll_view);
        scrollView.setVerticalScrollBarEnabled(true);
        textView = v.findViewById(R.id.write_tv);

        startBtn.setOnClickListener(this);
        stopBtn.setOnClickListener(this);
        resetBtn.setOnClickListener(this);
        writeBtn.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_button:
                textView.setText("");
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                break;
            case R.id.stop_button:
                chronometer.stop();
                textView.setText("");
                break;
            case R.id.reset_button:
                chronometer.stop();
                chronometer.setBase(SystemClock.elapsedRealtime());
                textView.setText("");
                break;
            case R.id.write_button:
                String text = chronometer.getText().toString();
                textView.append(text + "\n");

                break;
        }

    }
}