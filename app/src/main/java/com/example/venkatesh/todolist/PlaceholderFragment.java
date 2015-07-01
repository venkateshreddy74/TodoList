package com.example.venkatesh.todolist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.venkatesh.todolist.interfaces.DateandTimeFragmentCommunicator;

/**
 * Created by Venkatesh on 6/30/2015.
 */
public class PlaceholderFragment extends Fragment {

    DateandTimeFragmentCommunicator communicator;
    Button button;

    public PlaceholderFragment() {
    }

    public PlaceholderFragment(DateandTimeFragmentCommunicator communicator) {

        this.communicator = communicator;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_date, container, false);
        button = (Button) rootView.findViewById(R.id.okbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                communicator.loadTimeFragment();
            }
        });
        return rootView;
    }

}
