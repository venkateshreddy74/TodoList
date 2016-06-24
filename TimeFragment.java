package com.example.venkatesh.todolist;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by Venkatesh on 6/30/2015.
 */
public class TimeFragment extends Fragment {
    View timePicker;
    View button;
private DateFragment dateFragment;
    public TimeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.timefragment, container, false);
        timePicker= rootView.findViewById(R.id.time_picker);
        button = rootView.findViewById(R.id.okbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int day =getArguments().getInt("day");
                int month =getArguments().getInt("month");
                int year =getArguments().getInt("year");
                Log.d("Time","Time is set");

                  setAlaram(Calendar.getInstance().getTimeInMillis());
                Toast.makeText(getActivity(),"Alaram is Set for "+ day + "/"+ month+ "/"+ year,Toast.LENGTH_SHORT).show();
            }
        });
        return rootView;
    }

    private void setAlaram(long timeInMillis){

        Intent intent = new Intent(getActivity().getBaseContext(),AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getActivity().getBaseContext(),-1,intent,0);
        AlarmManager alarmManager = (AlarmManager)getActivity().getApplicationContext().getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,timeInMillis,pendingIntent);
        //AlarmManager alarmManager =
       // alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(),
         //       pendingIntent);


    }

}

