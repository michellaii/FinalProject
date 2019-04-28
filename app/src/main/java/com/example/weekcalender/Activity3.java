package com.example.weekcalender;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

public class Activity3 extends AppCompatActivity {
    private EditText inputText;
    private Button done;
    private ListView list;
    ArrayList<String> array = new ArrayList<String> ();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        //back button
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Edit Reminder");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        inputText = (EditText) findViewById(R.id.textInput);
        inputText.setText("");
        list = (ListView)findViewById(R.id.list);
        done = (Button) findViewById(R.id.button9);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = inputText.getText().toString();
//                Intent intent = new Intent(Activity3.this, Monday.class);
//                intent.putExtra("message", getInput);
//                startActivity(intent);
                array.add(getInput);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>
                        (Activity3.this, android.R.layout.simple_list_item_1, array);
                list.setAdapter(adapter);
                ((EditText) findViewById(R.id.textInput)).setText("");
            }
        });

//        done.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Activity3.this, Activity2.class);
//                intent.putExtra("message", inputText.getText().toString());
//                startActivity(intent);
//
//            }
//        });
    }
}
