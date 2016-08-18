package com.joyce.kuo.inmacau.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.joyce.kuo.inmacau.R;

public class MapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
    }

    public void MR1(View v)
    {

        Intent it =new Intent(MapActivity.this,MR1Activity.class);
        startActivity(it);
    }

}
