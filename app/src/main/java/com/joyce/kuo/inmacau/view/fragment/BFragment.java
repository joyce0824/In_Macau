package com.joyce.kuo.inmacau.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.joyce.kuo.inmacau.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class BFragment extends Fragment {
    private ListView lv1;
    MyAdapter adapter;
    private View v;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_b,container,false);
        //取Gson 內容
        InputStream is = null;
        is = getResources().openRawResource(R.raw.z1);
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        try {
            while ((length = is.read(buffer)) != -1) {
                result.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String str = result.toString("UTF-8");

            Gson gson = new Gson();
            final ArrayList<MR> mylist1 = gson.fromJson(str, new TypeToken<ArrayList<MR>>() {}.getType());

            for (MR p : mylist1)
            {
                Log.d("NET", p.ID + "," + p.NAME );
            }
            lv1=(ListView)v.findViewById(R.id.listView3);
            MyAdapter adapter=new MyAdapter(getActivity(), mylist1,"f1");
            lv1.setAdapter(adapter);

            lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Bundle b = new Bundle();
                    b.putString("id", MyAdapter.data.get(position).ID);
                    b.putString("name",  MyAdapter.data.get(position).NAME);
                    b.putString("note",  MyAdapter.data.get(position).NOTE);
                    Intent it = new Intent(getActivity(), DetailActivity.class);
                    it.putExtras(b);
                    startActivity(it);

                }
            });

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
   return v;

    }


}


