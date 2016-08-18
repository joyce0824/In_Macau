package com.joyce.kuo.inmacau.list;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter {

    Context context;
    String[] str;

    public ListAdapter(Context c,String[] s)
    {
        context=c;
        str=s;
    }

    @Override
    public int getCount() {
        return str.length;
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
        TextView tv=new TextView(context);
        tv.setTextSize(24);
        tv.setText(str[position]);
        return tv;
    }
}
