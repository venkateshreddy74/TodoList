package com.example.venkatesh.todolist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Venkatesh on 6/30/2015.
 */
public class TimeFragment extends Fragment {

    public TimeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.timefragment, container, false);
        return rootView;
    }
}

