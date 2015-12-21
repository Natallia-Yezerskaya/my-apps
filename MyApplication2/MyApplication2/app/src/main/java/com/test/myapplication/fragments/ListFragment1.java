package com.test.myapplication.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.myapplication.R;
import com.test.myapplication.activities.MainActivity;
import com.test.myapplication.ui.ActivityListener;

public class ListFragment1 extends Fragment {

    public static final String KEY_AAA = "dsfdsf";
    private TextView mTextView;
    private String aaa;

    private ActivityListener mActivityListener;

    public static ListFragment1 getInstance(String aaa, Intent intent) {

        ListFragment1 fragment1 = new ListFragment1();
        intent.putExtra(KEY_AAA, aaa);
        return fragment1;
    }

    public ListFragment1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

            View view = inflater.inflate(R.layout.fragment_list,
                    container, false);

            mTextView = (TextView)view.findViewById(R.id.textView);

            return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        aaa = getActivity().getIntent().getStringExtra(KEY_AAA);
        mTextView.setText(aaa);

        setHasOptionsMenu(true);

     }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof ActivityListener) {
            mActivityListener = (ActivityListener)context;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if(mActivityListener != null) mActivityListener.setTitle("HELLO");



    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case  R.id.my_action:

                Log.d("FRAGMENT", "Menu click");
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
