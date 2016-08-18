package com.joyce.kuo.inmacau.view.fragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.joyce.kuo.inmacau.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent it = getIntent();
        Bundle b = it.getExtras();

        TextView tv1 = (TextView) findViewById(R.id.textView3);
        tv1.setText(b.getString("name"));

        TextView tv2 = (TextView) findViewById(R.id.textView4);
        tv2.setText(b.getString("note"));

        ImageView iv = (ImageView) findViewById(R.id.imageView2);
        int drawableResourceId = this.getResources().getIdentifier(b.getString("id"), "drawable", this.getPackageName());
        iv.setImageResource(drawableResourceId);
    }
}
