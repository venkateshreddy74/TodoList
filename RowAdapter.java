package com.example.venkatesh.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Venkatesh on 6/27/2015.
 */
public class RowAdapter extends ArrayAdapter {

    private final Context context;
    private final String[] values;


    public RowAdapter(Context context, String[] values) {
        super(context, R.layout.layout,values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.layout,parent,false);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.image);
        imageView.setImageResource(R.drawable.todo_icon);
        TextView textView = (TextView) rowView.findViewById(R.id.rowtext);

        textView.setText(values[position]);
           return rowView;
    }
}
