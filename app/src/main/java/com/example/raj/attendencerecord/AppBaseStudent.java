package com.example.raj.attendencerecord;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.GridView;

import java.util.ArrayList;

public class AppBaseStudent extends AppCompatActivity {

    ArrayList<String> basicFields;
    gridAdapter adapter;
    public static ArrayList<String> divisions ;
    GridView gridView;
    public static databaseHandler handler;
    public static Activity activity;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mai_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_layout);
        basicFields = new ArrayList<>();
        handler = new databaseHandler(this);
        activity = this;

       // getSupportActionBar().show();
        divisions = new ArrayList();
        divisions.add("S1 COMPUTER SCIENCE");
        divisions.add("S2 COMPUTER SCIENCE");
        divisions.add("S3 COMPUTER SCIENCE");
        divisions.add("S4 COMPUTER SCIENCE");
        divisions.add("S5 COMPUTER SCIENCE");
        divisions.add("S6 COMPUTER SCIENCE");
        divisions.add("S7 COMPUTER SCIENCE");
        gridView = (GridView)findViewById(R.id.grid);
        basicFields.add("SCHEDULER");
        basicFields.add("NOTES");
        basicFields.add("PROFILE");
        basicFields.add("CGPA-CALC");
        basicFields.add("SETTINGS");

        adapter = new gridAdapter(this,basicFields);
        gridView.setAdapter(adapter);
    }

    public void loadSettings(MenuItem item) {
        Intent launchIntent = new Intent(this,SettingsActivity.class);
        startActivity(launchIntent);
    }

    public void loadAbout(MenuItem item) {
        Intent launchIntent = new Intent(this,About.class);
        startActivity(launchIntent);
    }
}
