package com.test.myapplicationtest;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by USER on 16.11.2015.
 */
public class MyAdapter extends BaseAdapter{
    private Context mContext;
    private List<String> mList;
    private LayoutInflater mLayoutInflater;

    public MyAdapter(Context context, List<String> list) {
        mContext = context;
        mList = list;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();

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

        View view = mLayoutInflater.inflate(R.layout.item_my,parent,false);
        TextView textView = (TextView) view.findViewById(R.id.textView);
        textView.setText(mList.get(position));

        Log.d(this.getClass().getSimpleName(), "get view position  = " + position);


        return view;
    }

}
