package com.natallia.lesson14;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.natallia.lesson14.UI.ActivityListener;
import com.natallia.lesson14.UI.MaterialMenuDrawable;
import com.natallia.lesson14.fragments.ListFragment;

public class MainActivity extends AppCompatActivity implements ActivityListener{


    private TextView mTitleView;
    private MaterialMenuDrawable mMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initToolbar();

        FragmentTransaction tr = getSupportFragmentManager().beginTransaction();

       ListFragment fragment  = ListFragment.getInstance("djkgfhsg", getIntent());
        tr.replace(R.id.container, fragment, "First");
        tr.commit();

    }




    private void initToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setContentInsetsAbsolute(0,0);
        mTitleView = (TextView) findViewById(R.id.tv_title);
        mMenu = new MaterialMenuDrawable(this, Color.BLACK,MaterialMenuDrawable.Stroke.REGULAR,300);

        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMenu.animateIconState(MaterialMenuDrawable.IconState.ARROW);
            }
        });
        toolbar.setNavigationIcon(mMenu);


        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(false);


    }

    @Override
    public void setTitle(String title) {
        mTitleView.setText(title);
    }

    @Override
    public void changeFragment(Fragment fragment) {

    }
}
