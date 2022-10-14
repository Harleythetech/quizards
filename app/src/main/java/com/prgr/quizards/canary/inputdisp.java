package com.prgr.quizards.canary;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class inputdisp extends Activity {

    private EditText quizname;
    private EditText desc;
    private EditText amount;


    private SharedPreferences jshared;

    @Override
    protected void onCreate(Bundle _savedInstanceState) {
        super.onCreate(_savedInstanceState);
        setContentView(R.layout.activity_inputdisp);
        initialize();
        initializeLogic();
    }

    private void initialize() {
        quizname = findViewById(R.id.quizname);
        desc = findViewById(R.id.desc);
        amount = findViewById(R.id.amount);
        Button button = findViewById(R.id.button);
        jshared = getSharedPreferences("j", Activity.MODE_PRIVATE);

        button.setOnClickListener(_view -> {
            jshared.edit().putString("quizname", quizname.getText().toString()).commit();
            jshared.edit().putString("desc", desc.getText().toString()).commit();
            jshared.edit().putString("amount", amount.getText().toString()).commit();
            Intent intent = new Intent(inputdisp.this, question.class);
            startActivity(intent);
        });
    }

    private void initializeLogic() {
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