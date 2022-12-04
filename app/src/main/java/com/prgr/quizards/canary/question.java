package com.prgr.quizards.canary;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;

import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Objects;

public class question extends Activity {

    private HashMap<String, Object> map = new HashMap<>();
    private TextView text;
    private EditText inop;
    private TextInputEditText ans;
    private AppCompatButton btn;
    private SharedPreferences jshared2;

    private SharedPreferences jshared;

    @Override
    protected void onCreate(Bundle _savedInstanceState) {
        super.onCreate(_savedInstanceState);
        setContentView(R.layout.activity_question);
        initializedata();
        AppCompatButton btn2 = findViewById(R.id.button3);
        btn = findViewById(R.id.button);
        btn2.setOnClickListener(v -> gotoback());
        btn.setOnClickListener(view -> logicg());

    }
    public void gotoback(){
        Intent intent = new Intent(question.this, activity_home_screen.class);
        startActivity(intent);
    }

    private void initializedata(){
        jshared = getSharedPreferences("j", Activity.MODE_PRIVATE);
        jshared2 = getSharedPreferences("j2", Activity.MODE_PRIVATE);
    }
    private void logicg() {
        btn = findViewById(R.id.button);
        inop = findViewById(R.id.inop);
        ans = findViewById(R.id.ans);
        text = findViewById(R.id.text1);

        String mount = jshared.getString("amount", "");
        int amounts = Integer.parseInt(mount);

        Toast.makeText(getApplicationContext(), "Debug: entering quest", Toast.LENGTH_SHORT).show();

        for (int i = 1; i < amounts; i++) {
            //String shite = Integer.toString(qloop);
            //Toast.makeText(getApplicationContext(), shite, Toast.LENGTH_SHORT).show();
            if (i == amounts) {
                Intent intent = new Intent(question.this, answerscrn.class);
                startActivity(intent);
            } else{
                map = new HashMap<>();
                map.put("answer", Objects.requireNonNull(ans.getText()).toString());
                map.put("question", inop.getText().toString());
                jshared2.edit().putString("data", new Gson().toJson(map)).commit();

            }


        }
    }
}
