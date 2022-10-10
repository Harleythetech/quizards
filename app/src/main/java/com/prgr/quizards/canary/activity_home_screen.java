package com.prgr.quizards.canary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import android.content.Intent;

import android.os.Bundle;

public class activity_home_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        AppCompatButton btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(v -> gotowrite());
    }
    public void gotowrite(){
        Intent intent = new Intent(this, inputdisp.class);
        startActivity(intent);
    }
}