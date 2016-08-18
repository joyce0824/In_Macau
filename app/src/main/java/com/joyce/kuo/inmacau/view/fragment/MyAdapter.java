package com.joyce.kuo.inmacau.view.fragment;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.joyce.kuo.inmacau.R;

import java.util.ArrayList;

/**
 * Created by apple on 16/8/15.
 */
public class MyAdapter extends BaseAdapter {
    Context context;
   static ArrayList<MR> data;

    public MyAdapter(Context c,ArrayList<MR> list)
    {
        context =c;
        data = new ArrayList<>();
        data=list;
    }

    public  MyAdapter(Context c,ArrayList<MR> list,String s)
    {
        context =c;
        data = new ArrayList<>();
       for(MR mr:list)
        {
            if(mr.AREA.equals(s))
            {
                data.add(mr);

                Log.d("MR", mr.ID + "," + mr.NAME+","+mr.AREA );
            }
        }
        //data=list;
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
        LayoutInflater inflater = LayoutInflater.from(context);

        View v = inflater.inflate(R.layout.screen, null);
        ImageView img = (ImageView) v.findViewById(R.id.imageView2);
        //取得圖片位置
        // int drawableResourceId = context.getResources().getIdentifier(data.get(position).ID, "drawable", context.getPackageName());
        //img.setImageResource(drawableResourceId);
        Glide.with(context)
                .load(data.get(position).ID)
                .override(300,200)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(img);

        TextView tv1 = (TextView) v.findViewById(R.id.textView2);
        tv1.setText(data.get(position).NAME);

        return v;
    }
}



