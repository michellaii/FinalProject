package com.example.weekcalender;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

public class Tuesday extends AppCompatActivity {
    ListView timeView;
    ListView saved;
    ArrayList<String> reminder;
    ArrayAdapter<String> arrayAdapter2;
    View clickSource;
    View touchSource;
    Button button;

    int offset = 0;
    int offset1 = 0;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuesday);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Select A Time");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        timeView = (ListView)findViewById(R.id.timeView);
        saved = (ListView) findViewById(R.id.saved);
        button = (Button) findViewById(R.id.button10);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                for (int i = 0; i < reminder.size(); i++) {
                    reminder.set(i, " ");
                    arrayAdapter2.notifyDataSetChanged();
                }
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Tuesday.this);
                SharedPreferences.Editor editor = prefs.edit();
                Gson gson = new Gson();
                String json = gson.toJson(reminder);
                editor.putString("rem2", json);
                editor.apply();
            }
        });
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
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                showInputBox(reminder.get(position), position);
            }
        });
        timeView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(touchSource == null)
                    touchSource = v;
                if(v == touchSource) {
                    saved.dispatchTouchEvent(event);
                    if(event.getAction() == MotionEvent.ACTION_UP) {
                        clickSource = v;
                        touchSource = null;
                    }
                }

                return false;
            }
        });
        timeView.setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (view == clickSource)
                    saved.setSelectionFromTop(firstVisibleItem, view.getChildAt(0).getTop() + offset);
            }
            public void onScrollStateChanged(AbsListView view, int scrollState) {}

        });

        saved.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(touchSource == null)
                    touchSource = v;
                if(v == touchSource) {
                    timeView.dispatchTouchEvent(event);
                    if(event.getAction() == MotionEvent.ACTION_UP) {
                        clickSource = v;
                        touchSource = null;
                    }
                }

                return false;
            }
        });
        saved.setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (view == clickSource)
                    timeView.setSelectionFromTop(firstVisibleItem, view.getChildAt(0).getTop() + offset1);
            }
            public void onScrollStateChanged(AbsListView view, int scrollState) {}

        });

        String[] items = {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",
                " ", " " , " ", " ", " ", " ", " ", " ", " "};
        reminder = new ArrayList<>(Arrays.asList(items));
        arrayAdapter2 = new ArrayAdapter<String>(this, R.layout.listitem, R.id.txtitem, reminder);
        saved.setAdapter(arrayAdapter2);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        Gson gson = new Gson();
        String json = prefs.getString("rem2", null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        ArrayList<String> remin = gson.fromJson(json, type);
        if (remin != null) {
            for(int i = 0; i < remin.size(); i++) {
                reminder.set(i, remin.get(i));
            }
        }
    }
    public void showInputBox(String str, final int i) {
        final Dialog dialog = new Dialog(Tuesday.this);
        dialog.setContentView(R.layout.inputbox1);
        TextView txt = (TextView) dialog.findViewById(R.id.txt);
        txt.setText("Edit reminder");
        final EditText editText = (EditText) dialog.findViewById(R.id.txtinput);
        editText.setText(str);
        Button b = (Button)dialog.findViewById(R.id.done);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                reminder.set(i, editText.getText().toString());
                arrayAdapter2.notifyDataSetChanged();

                SharedPreferences prefs2 = PreferenceManager.getDefaultSharedPreferences(Tuesday.this);
                SharedPreferences.Editor editor = prefs2.edit();
                Gson gson2 = new Gson();
                String json = gson2.toJson(reminder);
                editor.putString("rem2", json);
                editor.apply();

                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
