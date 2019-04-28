package com.example.weekcalender;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openMonday();
            }
         });
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openTuesday();
            }
        });
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openWednesday();
            }
        });
        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openThursday();
            }
        });
        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openFriday();
            }
        });
        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openSaturday();
            }
        });
        button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openSunday();
            }
        });
    }
    public void openMonday() {
        Intent intent = new Intent(this, Monday.class);
        startActivity(intent);
    }
    public void openTuesday() {
        Intent intent = new Intent(this, Tuesday.class);
        startActivity(intent);
    }
    public void openWednesday() {
        Intent intent = new Intent(this, Wednesday.class);
        startActivity(intent);
    }
    public void openThursday() {
        Intent intent = new Intent(this, Thursday.class);
        startActivity(intent);
    }
    public void openFriday() {
        Intent intent = new Intent(this, Friday.class);
        startActivity(intent);
    }
    public void openSaturday() {
        Intent intent = new Intent(this, Saturday.class);
        startActivity(intent);
    }
    public void openSunday() {
        Intent intent = new Intent(this, Sunday.class);
        startActivity(intent);
    }

}
