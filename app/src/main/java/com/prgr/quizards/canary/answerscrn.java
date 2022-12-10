package com.prgr.quizards.canary;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class answerscrn extends Activity {

    private HashMap<String, Object> map = new HashMap<>();
    private TextView amount;
    private TextView text;
    private SharedPreferences jshared2;
    private SharedPreferences jshared;
    private AppCompatButton btn;

    @Override
    protected void onCreate(Bundle _savedInstanceState) {
        super.onCreate(_savedInstanceState);
        setContentView(R.layout.activity_answerscrn);
        initialize(_savedInstanceState);
        initializeLogic();
        btn = findViewById(R.id.button3);
        btn.setOnClickListener(v -> gotoback());
    }
    public void gotoback(){
        Intent intent = new Intent(this, question.class);
        startActivity(intent);
    }
    private void initialize(Bundle _savedInstanceState) {
        text = findViewById(R.id.text);
        amount = findViewById(R.id.amount);
        jshared = getSharedPreferences("j", Activity.MODE_PRIVATE);
        jshared2 = getSharedPreferences("j2", Activity.MODE_PRIVATE);


    }

    private void initializeLogic() {
        map = new Gson().fromJson(jshared2.getString("data", ""), new TypeToken<HashMap<String, Object>>(){}.getType());
        amount.setText(jshared2.getString("amount", ""));
        text.setText(map.get("question").toString());
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
