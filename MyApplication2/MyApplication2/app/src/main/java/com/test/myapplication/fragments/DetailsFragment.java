package com.test.myapplication.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.myapplication.R;

public class DetailsFragment extends Fragment {

    private TextView mTextView;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

            View view = inflater.inflate(R.layout.fragment_details,
                    container, false);

            mTextView = (TextView)view.findViewById(R.id.textView);

            return view;
    }

}
