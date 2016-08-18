package com.joyce.kuo.inmacau;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.joyce.kuo.inmacau.list.ListActivity;
import com.joyce.kuo.inmacau.trip.TripActivity;
import com.joyce.kuo.inmacau.view.MapActivity;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }


    public void click_map(View v)
    {

        Intent it =new Intent(Main2Activity.this,MapActivity.class);
        startActivity(it);
    }

    public void click_trip(View v)
    {
        Intent it=new Intent(Main2Activity.this,TripActivity.class);
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
        Intent it=new Intent(Main2Activity.this,ListActivity.class);
        startActivity(it);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
