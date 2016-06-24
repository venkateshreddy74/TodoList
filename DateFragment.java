package com.example.venkatesh.todolist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;

import com.example.venkatesh.todolist.interfaces.DateandTimeFragmentCommunicator;

/**
 * Created by Venkatesh on 6/30/2015.
 */
public class DateFragment extends Fragment {

    DateandTimeFragmentCommunicator communicator;
    DatePicker datePicker;
    Button button;

    public DateFragment() {
    }

    public DateFragment(DateandTimeFragmentCommunicator communicator) {

        Log.i("PlaceHolder", "constructor called");
        this.communicator = communicator;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_date, container, false);
        button = (Button) rootView.findViewById(R.id.ok_button);
        datePicker = (DatePicker) rootView.findViewById(R.id.datePicker);
        //saveDate();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int day;
                int month;
                int year;
                day= datePicker.getDayOfMonth();
                year= datePicker.getYear();
                month=datePicker.getMonth();
                Bundle bundle = new Bundle();
                bundle.putInt("day",day);
                bundle.putInt("month",month);
                bundle.putInt("year",year);
                communicator.loadTimeFragment(bundle);
            }
        });

        return rootView;
    }


    public DatePicker getDate() {

        return datePicker;

    }

}
