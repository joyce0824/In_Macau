package com.joyce.kuo.inmacau.view;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.joyce.kuo.inmacau.R;
import com.joyce.kuo.inmacau.view.fragment.AFragment;
import com.joyce.kuo.inmacau.view.fragment.BFragment;
import com.joyce.kuo.inmacau.view.fragment.GoogleMapsActivity;

public class MR1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mr1);

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_layout,
                new AFragment(), "f_a");
        ft.commit();
    }
    public void click_view(View v)
    {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_layout,
                new AFragment(), "f_a");
        ft.commit();

    }

    public void click_food(View v)
    {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_layout,
                new BFragment(),"f_b");
        ft.commit();

    }

    public void click_map(View v)
    {
        Intent it=new Intent(MR1Activity.this,GoogleMapsActivity.class);
        startActivity(it);
       /* FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_layout,new CFragment(),"f_c");
        ft.commit();*/
    }
}
