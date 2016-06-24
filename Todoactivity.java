package com.example.venkatesh.todolist;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Todoactivity extends ActionBarActivity {

    ArrayList<String> itemnames;

    ArrayAdapter<String> itemadapter;

    ListView listView;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todoactivity);
       // getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setIcon(R.drawable.todo_launch);


        itemnames = new ArrayList<>();

        readItems();
        itemadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemnames);


        listView = (ListView) findViewById(R.id.list_items);

        listView.setAdapter(itemadapter);

        setupListViewListener();

        getSupportActionBar().setDisplayShowCustomEnabled(true);

        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);


    }

    private void setupListViewListener() {

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                itemnames.remove(position);
                itemadapter.notifyDataSetChanged();
                saveItems();
                return true;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(Todoactivity.this, Date.class);
                startActivity(intent);

            }
        });
    }

    public void readItems() {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        Log.i("INFO FILE DIR", String.valueOf(filesDir));


        try {
            itemnames = new ArrayList<>(FileUtils.readLines(todoFile));

        } catch (IOException e) {

            itemnames = new ArrayList<>();
            e.printStackTrace();
        }



    }

    public void saveItems() {

        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");

        try {

            FileUtils.writeLines(todoFile, itemnames);

        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_todoactivity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addItem(View v) {
        EditText itemtext = (EditText) findViewById(R.id.editText);
        itemadapter.add(itemtext.getText().toString());
        itemtext.setText(""); //setback to empty text field for new entries
        saveItems();
    }

}
