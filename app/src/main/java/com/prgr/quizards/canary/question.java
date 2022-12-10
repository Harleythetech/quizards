package com.prgr.quizards.canary;

import android.annotation.SuppressLint;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;


public class question extends Activity {

    private AppCompatButton btn;
    private SharedPreferences jshared2;
    private int val;
    private SharedPreferences jshared;
    private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
    //private ArrayList<String> liststring = new ArrayList<>();
    private HashMap<String, Object> map = new HashMap<>();
    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    @Override
    protected void onCreate(Bundle _savedInstanceState) {
        super.onCreate(_savedInstanceState);
        setContentView(R.layout.activity_question);
        initializedata();
        AppCompatButton btn2 = findViewById(R.id.button3);
        btn = findViewById(R.id.button);
        btn2.setOnClickListener(v -> gotoback());
        btn.setOnClickListener(view -> logicg());
        val = 0;

    }
    public void gotoback(){
        Intent intent = new Intent(question.this, activity_home_screen.class);
        startActivity(intent);
    }

    private void initializedata(){
        jshared = getSharedPreferences("j", Activity.MODE_PRIVATE);
        jshared2 = getSharedPreferences("j2", Activity.MODE_PRIVATE);

    }
    @SuppressLint("ApplySharedPref")
    private void logicg() {
        btn = findViewById(R.id.button);
        EditText inop = findViewById(R.id.inop);
        TextInputEditText ans = findViewById(R.id.ans);
        TextView text = findViewById(R.id.text3);

        String mount = jshared.getString("amount", "");
        int amounts = Integer.parseInt(mount);

        boolean b = val == amounts;
        Toast.makeText(getApplicationContext(), "Start", Toast.LENGTH_SHORT).show();
        if(b){
            jshared2.edit().putString("data", new Gson().toJson(listmap)).commit();
            Intent intent = new Intent(question.this, answerscrn.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(), "if", Toast.LENGTH_SHORT).show();
        }else{
            map.put("answer", Objects.requireNonNull(ans.getText()).toString());
            map.put("question", inop.getText().toString());
            map.putAll((listmap).get(0));
            map.clear();
            ans.setText(null);
            inop.setText(null);
            val++;
            String f = Integer.toString(val);
            Toast.makeText(getApplicationContext(), f, Toast.LENGTH_SHORT).show();
        }

    }

}

