package com.natallia.myfirstapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 18.11.15.
 */
public class MyAdapter extends ArrayAdapter<String>{

    private final Context context;
    private final List<String> values;


    public MyAdapter(Context context, List<String> values) {
        super(context, R.layout.row_layout, values);
        this.context = context;
        this.values = values;
    }

    static class ViewHolder {
        public TextView text;
        public int count;
    }

    @Override
    public void add(String object) {
        super.add(object);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      /* LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row_layout, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.textView);
        textView.setText(values[position]);

        return rowView;
        */

        View rowView = convertView;

        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.row_layout, null);


            ViewHolder viewHolder = new ViewHolder();
            viewHolder.text = (TextView) rowView.findViewById(R.id.textView);

            rowView.setTag(viewHolder);
        }


        ViewHolder holder = (ViewHolder) rowView.getTag();
        holder.count++;
        String s = getItem(position) + " (" + Integer.toString(holder.count) + ")";
        holder.text.setText(s);

        return rowView;
    }
}


