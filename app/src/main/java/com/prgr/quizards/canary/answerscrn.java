package com.prgr.quizards.canary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import android.content.Intent;

import android.os.Bundle;

public class answerscrn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answerscrn);
        AppCompatButton btn = findViewById(R.id.button3);
        btn.setOnClickListener(v -> gotoback());
        AppCompatButton btn2 = findViewById(R.id.button);
        btn2.setOnClickListener(v -> gotorndmz());
    }
    public void gotorndmz(){
        Intent intent = new Intent(this, loading.class);
        startActivity(intent);
    }
    public void gotoback(){
        Intent intent = new Intent(this, activity_home_screen.class);
        startActivity(intent);
    }
}