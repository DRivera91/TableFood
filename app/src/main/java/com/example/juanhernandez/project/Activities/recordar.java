package com.example.juanhernandez.project.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.juanhernandez.project.R;

public class recordar extends AppCompatActivity {
    TextView inv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordar);
        inv = (TextView) findViewById(R.id.inv);
    }

}
