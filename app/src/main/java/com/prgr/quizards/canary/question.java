package com.prgr.quizards.canary;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;

import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

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
        initialize(_savedInstanceState);
        initializeLogic();
        AppCompatButton btn2 = findViewById(R.id.button3);
        btn2.setOnClickListener(v -> gotoback());

    }
    public void gotoback(){
        Intent intent = new Intent(question.this, activity_home_screen.class);
        startActivity(intent);
    }

    private void initialize(Bundle _savedInstanceState) {

        btn = findViewById(R.id.button);
        inop = findViewById(R.id.inop);
        ans = findViewById(R.id.ans);
        text = findViewById(R.id.text1);
        jshared = getSharedPreferences("j", Activity.MODE_PRIVATE);
        jshared2 = getSharedPreferences("j2", Activity.MODE_PRIVATE);


    }

    private void initializeLogic() {


        text.setText(jshared.getString("amount", ""));
        btn.setOnClickListener(_view -> {
                map = new HashMap<>();
                map.put("answer", ans.getText().toString());
                map.put("question", inop.getText().toString());
                jshared2.edit().putString("data", new Gson().toJson(map)).commit();
                Intent intent = new Intent(question.this, answerscrn.class);
                startActivity(intent);
        });

    }


    @Deprecated
    public void showMessage(String _s) {
        Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
    }

    @Deprecated
    public int getLocationX(View _v) {
        int[] _location = new int[2];
        _v.getLocationInWindow(_location);
        return _location[0];
    }

    @Deprecated
    public int getLocationY(View _v) {
        int[] _location = new int[2];
        _v.getLocationInWindow(_location);
        return _location[1];
    }

    @Deprecated
    public int getRandom(int _min, int _max) {
        Random random = new Random();
        return random.nextInt(_max - _min + 1) + _min;
    }

    @Deprecated
    public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
        ArrayList<Double> _result = new ArrayList<>();
        SparseBooleanArray _arr = _list.getCheckedItemPositions();
        for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
            if (_arr.valueAt(_iIdx))
                _result.add((double)_arr.keyAt(_iIdx));
        }
        return _result;
    }

    @Deprecated
    public float getDip(int _input) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
    }

    @Deprecated
    public int getDisplayWidthPixels() {
        return getResources().getDisplayMetrics().widthPixels;
    }

    @Deprecated
    public int getDisplayHeightPixels() {
        return getResources().getDisplayMetrics().heightPixels;
    }
}
