package com.test.myapplicationtest.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.test.myapplicationtest.R;
import com.test.myapplicationtest.adapters.SummaAdapter;
import com.test.myapplicationtest.models.Summa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MainActivity extends Activity {

    private List<Summa> mList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private SummaAdapter mSummaAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);

       GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setHasFixedSize(true);

        mSummaAdapter = new SummaAdapter(mList);
        mRecyclerView.setAdapter(mSummaAdapter);

        mSummaAdapter.setItemClickListener(new SummaAdapter.ItemClickListener() {
            @Override
            public void onClick(Summa summa) {
                Log.d("ResVIEW", "item name " + summa.getName());
            }
        });

        showData();


      }

    private void showData(){

        mList.add(new Summa(10, new Date(), "Первый"));
        mList.add(new Summa(5.7, new Date(), "Второй"));
        mList.add(new Summa(1.1, new Date(), "Третий"));
        mList.add(new Summa(5.1, new Date(), "item 4"));
        mList.add(new Summa(8.1, new Date(), "item 5"));
        mList.add(new Summa(9.1, new Date(), "item 6"));
        mList.add(new Summa(1.2, new Date(), "item 7"));
        mList.add(new Summa(5, new Date(), "item 8"));

        mSummaAdapter.addItems(mList);
    }


}
