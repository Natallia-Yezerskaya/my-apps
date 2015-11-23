package com.test.myapplicationtest.adapters;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.myapplicationtest.R;
import com.test.myapplicationtest.models.Summa;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created by USER on 18.11.2015.
 */
public class SummaAdapter extends RecyclerView.Adapter<SummaAdapter.SummaHolder> {


    private List<Summa> mList;
    private ItemClickListener mItemClickListener;


    public void setItemClickListener(ItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    public void setmList(List<Summa> mList) {
        this.mList = mList;
    }

    public SummaAdapter(List<Summa> mList) {
        this.mList = mList;
    }

    public  void addItems(List<Summa> list){
        mList = list;
        notifyDataSetChanged();

    }

    @Override
    public SummaHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_my,viewGroup,false);
        SummaHolder summaHolder = new SummaHolder(view);

        return summaHolder;
    }

    @Override
    public void onBindViewHolder(SummaHolder summaHolder, int i) {

        final Summa summa = mList.get(i);

        summaHolder.summa.setText(String.valueOf(summa.getSumma()));

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.US);
        String stringDate = sdf.format(summa.getDate());
        summaHolder.date.setText(stringDate);

        summaHolder.name.setText(summa.getName());

        summaHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemClickListener != null){
                    mItemClickListener.onClick(summa);
            }
            }

        });



    }

    @Override
    public int getItemCount() {
        if (mList == null)
            return 0;
        else
            return mList.size();

    }

    public static class SummaHolder extends RecyclerView.ViewHolder{

        TextView summa;
        TextView date;
        TextView name;
        View view;


        public SummaHolder(View itemView) {
            super(itemView);
            view = itemView;
            summa = (TextView)itemView.findViewById(R.id.tv_summa);
            date = (TextView)itemView.findViewById(R.id.tv_date);
            name = (TextView)itemView.findViewById(R.id.tv_name);
        }
    }

    public interface ItemClickListener{
        void onClick(Summa summa);

    }

}
