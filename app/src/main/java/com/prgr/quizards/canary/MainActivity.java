package com.prgr.quizards.canary;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatButton btn = findViewById(R.id.button);
        btn.setOnClickListener(v -> gotohome());

    }
    public void gotohome(){
        Intent intent = new Intent(this, activity_home_screen.class);
        startActivity(intent);
    }

}