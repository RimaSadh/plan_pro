package com.example.planpro.project.task;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.example.planpro.R;


public class AddTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        getSupportActionBar().hide();
    }
}