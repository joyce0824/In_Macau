package com.joyce.kuo.inmacau;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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

        menu.add(0,0,Menu.NONE,"關於我們");
        menu.add(0,1,Menu.NONE,"聯絡我們");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == 0) {
            Toast.makeText(Main2Activity.this, "BB", Toast.LENGTH_SHORT).show();
            AlertDialog.Builder builder=new AlertDialog.Builder(Main2Activity.this);
            builder.setTitle("關於我們");
            builder.setMessage("特別感謝:澳門特別行政區政府旅遊局\n資料來源:來自澳門特別行政區政府旅遊局");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
