package com.joyce.kuo.inmacau.view.fragment;
import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.joyce.kuo.inmacau.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class GoogleMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    ArrayList<MR> mylist1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //抓gson
        InputStream is1 = null;
        is1 = getResources().openRawResource(R.raw.z1);
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        try {
            while ((length = is1.read(buffer)) != -1) {
                result.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String str = result.toString("UTF-8");

            Gson gson = new Gson();
            mylist1 = gson.fromJson(str, new TypeToken<ArrayList<MR>>() {}.getType());
            for (MR p : mylist1)
            {
                Log.d("MP", p.ID + "," + p.NAME );
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    // //開權限
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        int result = grantResults[0];

        if (result == PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                return;
            }
            mMap.setMyLocationEnabled(true);
        }
        else
        {

        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //跳出對話框
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }
        else
        {
            mMap.setMyLocationEnabled(true);
        }

        Log.d("2562651",mylist1.size()+"");
        for(MR p : mylist1)
        {
            if(p.AREA.equals("v1")){
                mMap.addMarker(new MarkerOptions()
                        .title(p.NAME)
                        .position(new LatLng(p.LAT,p.LNG))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_2)));
                Log.d("foooooo", p.ID + "," + p.NAME );
            }

           else {
                mMap.addMarker(new MarkerOptions()
                        .title(p.NAME)
                        .position(new LatLng(p.LAT,p.LNG))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_1)));
                Log.d("z", p.ID + "," + p.NAME );
            }
        }

        LatLng macau = new LatLng(22.2076035,113.5459481);
        CameraPosition cameraPos = new CameraPosition.Builder().target(macau)
                .zoom(17.0f)
                .build();
        CameraUpdate cameraUpt = CameraUpdateFactory
                .newCameraPosition(cameraPos);
        // 移動的效果
        mMap.moveCamera(cameraUpt);

    }
}
