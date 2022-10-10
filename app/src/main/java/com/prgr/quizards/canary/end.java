package com.prgr.quizards.canary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;

public class end extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        AppCompatButton btn2 = findViewById(R.id.button);
        btn2.setOnClickListener(v -> gotoback());
    }
    public void gotoback(){
        Intent intent = new Intent(this, activity_home_screen.class);
        startActivity(intent);
    }
}