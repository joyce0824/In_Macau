package com.joyce.kuo.inmacau;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.joyce.kuo.inmacau.list.ListActivity;
import com.joyce.kuo.inmacau.view.MapActivity;
import com.joyce.kuo.inmacau.trip.TripActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void click_map(View v)
    {

        Intent it =new Intent(MainActivity.this,MapActivity.class);
        startActivity(it);
    }

    public void click_trip(View v)
    {
        Intent it=new Intent(MainActivity.this,TripActivity.class);
        startActivity(it);
    }



    public void click_ticket(View v)
    {
       Uri uri=Uri.parse("http://www.backpackers.com.tw/forum/airfare.php?city_to=MFM");
       Intent it=new Intent(Intent.ACTION_VIEW,uri);
       startActivity(it);
    }

    public void click_hotel(View v)
    {
        Uri uri=Uri.parse("http://hotel.backpackers.com.tw/Place/Macau_1.htm");
        Intent it=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(it);
    }

    public void click_list(View v)
    {
        Intent it=new Intent(MainActivity.this,ListActivity.class);
        startActivity(it);

    }
}
