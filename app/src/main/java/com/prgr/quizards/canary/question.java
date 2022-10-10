package com.prgr.quizards.canary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import android.content.Intent;

import android.os.Bundle;

public class question extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        AppCompatButton btn = findViewById(R.id.button3);
        btn.setOnClickListener(v -> gotoback());
        AppCompatButton btn2 = findViewById(R.id.button);
        btn2.setOnClickListener(v -> gotowrite());
    }
    public void gotowrite(){
        Intent intent = new Intent(this, answerscrn.class);
        startActivity(intent);
    }
    public void gotoback(){
        Intent intent = new Intent(this, inputdisp.class);
        startActivity(intent);
    }
}