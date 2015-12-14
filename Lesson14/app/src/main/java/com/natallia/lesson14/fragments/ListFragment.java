package com.natallia.lesson14.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.natallia.lesson14.R;
import com.natallia.lesson14.UI.ActivityListener;

/**
 * Created by Administrator on 13.12.15.
 */
public class ListFragment extends Fragment {


    private static String KEA_AAA = "sfafsafa";
    private static int KEY_number ;
    private int keyNumber ;
    public TextView mTextView;

    private String aaa;

    private ActivityListener mActivityListener;

    public ListFragment() {
        this.aaa = aaa;

    }

    public static ListFragment getInstance (String aaa,Intent intent){
        ListFragment fragment = new ListFragment();
        intent.putExtra(KEA_AAA,aaa);
        return fragment;

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        aaa = getActivity().getIntent().getStringExtra(KEA_AAA);

        // if (KEY_number == 1){
        View view = inflater.inflate(R.layout.fragment_list,container,false);
        // else if (KEY_number == 2){
        //     View view = inflater.inflate(R.layout.fragment_details,container,false);}
        // else
        //  {View view = inflater.inflate(R.layout.fragment_details2,container,false);}


        // mTextView = (TextView) .findViewById(R.id.textView);
        //    mTextView.setText(aaa);


        return view;


    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ActivityListener){
            mActivityListener = (ActivityListener)context;
        }

    }

    @Override
    public void onResume() {
        super.onResume();

        if(mActivityListener!=null) {mActivityListener.setTitle("Hello");}
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.my_action:

//                Log.d("hdkjshfka","onOptionsItemSelected");
                break;

        }
        return super.onOptionsItemSelected(item);


    }
}
