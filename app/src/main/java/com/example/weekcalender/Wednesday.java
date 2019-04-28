package com.example.weekcalender;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Wednesday extends AppCompatActivity {
    ListView timeView;
    TextView reminder;

    public void openTextInput() {
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wednesday);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Select A Time");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        timeView = (ListView)findViewById(R.id.timeView);
        ArrayList<String> timeList = new ArrayList<>();
        timeList.add("12 AM");
        timeList.add("1 AM");
        timeList.add("2 AM");
        timeList.add("3 AM");
        timeList.add("4 AM");
        timeList.add("5 AM");
        timeList.add("6 AM");
        timeList.add("7 AM");
        timeList.add("8 AM");
        timeList.add("9 AM");
        timeList.add("10 AM");
        timeList.add("11 AM");
        timeList.add("12 PM");
        timeList.add("1 PM");
        timeList.add("2 PM");
        timeList.add("3 PM");
        timeList.add("4 PM");
        timeList.add("5 PM");
        timeList.add("6 PM");
        timeList.add("7 PM");
        timeList.add("8 PM");
        timeList.add("9 PM");
        timeList.add("10 PM");
        timeList.add("11 PM");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, timeList);
        timeView.setAdapter(arrayAdapter);
        timeView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View v, int i, long l) {
                openTextInput();
            }
        });

        TextView t = (TextView) findViewById(R.id.reminder);
        t.setText(getIntent().getStringExtra("message"));
    }
}
