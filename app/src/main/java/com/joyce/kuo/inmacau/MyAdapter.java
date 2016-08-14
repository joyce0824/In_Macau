package com.joyce.kuo.inmacau;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by apple on 16/8/14.
 */
public class MyAdapter extends BaseAdapter {

    AFragment context;
    ArrayList<MR> data;

    public MyAdapter(AFragment c, ArrayList<MR> list)
    {
        context=c;
        data=list;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View v=inflater.inflate(R.layout.screen,null);
        ImageView img=(ImageView)v.findViewById(R.id.imageView);
        int drawableResourceId = context.getResources().getIdentifier("ID", "drawable", context.getPackageName());
        img.setImageResource(drawableResourceId);
        TextView tv1=(TextView)v.findViewById(R.id.textView2);
        tv1.setText(data.get(position).NAME);

        return v;
    }
}
