package com.natallia.lesson13;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.natallia.lesson13.fragments.MyFragment;
import com.natallia.lesson13.fragments.MyFragment2;
import com.natallia.lesson13.fragments.MyFragment3;
import com.natallia.lesson13.fragments.MyFragment4;
import com.natallia.lesson13.fragments.MyFragment5;

import android.support.v4.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {


    final static String TAG_1 = "FRAGMENT_1";
    final static String TAG_2 = "FRAGMENT_2";
    final static String TAG_3 = "FRAGMENT_3";
    final static String TAG_4 = "FRAGMENT_4";
    final static String TAG_5 = "FRAGMENT_5";

    final static String KEY_MSG_1 = "FRAGMENT1";
    final static String KEY_MSG_2 = "FRAGMENT2";
    final static String KEY_MSG_3 = "FRAGMENT3";
    final static String KEY_MSG_4 = "FRAGMENT4";
    final static String KEY_MSG_5 = "FRAGMENT5";


    MyFragment myFragment;
    MyFragment2 myFragment2;
    MyFragment3 myFragment3;
    MyFragment4 myFragment4;
    MyFragment5 myFragment5;
    FragmentManager fragmentManager;
    FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView_number = (TextView) findViewById(R.id.text_number);
        final Button button_next = (Button) findViewById(R.id.button_next);
        final Button button_previous = (Button) findViewById(R.id.button_previous);

        container = (FrameLayout) findViewById(R.id.container);

        final FragmentManager fragmentManager = getSupportFragmentManager();

        button_previous.setVisibility(View.INVISIBLE);
        button_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int number = Integer.parseInt((String) textView_number.getText());
                textView_number.setText("" + (--number));


               // if ( fragmentManager.getFragments().size() ==0) {

                //} else {

                //    String tag = fragmentManager.getFragments().get(fragmentManager.getFragments().size()-1).getTag();
                    switch (number) {
                        case 4: {

                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.setCustomAnimations(R.anim.card_flip_diagonal_in, R.anim.card_flip_diagonal_out);
                            fragmentTransaction.replace(R.id.container, myFragment4,
                                    TAG_4);
                            fragmentTransaction.commit();
                            button_next.setVisibility(View.VISIBLE);
                        }
                        break;
                        case 1:{

                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.setCustomAnimations(R.anim.card_flip_diagonal_in, R.anim.card_flip_diagonal_out);
                            fragmentManager.popBackStack();
                            fragmentTransaction.replace(R.id.container, myFragment,
                                    TAG_1);
                            fragmentTransaction.commit();
                            button_previous.setVisibility(View.INVISIBLE);}
                        break;
                        case 2:{
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.setCustomAnimations(R.anim.card_flip_diagonal_in, R.anim.card_flip_diagonal_out);
                            fragmentTransaction.replace(R.id.container, myFragment2,
                                    TAG_2);
                            fragmentTransaction.commit();}
                        break;
                        case 3:
                        {
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.setCustomAnimations(R.anim.card_flip_diagonal_in, R.anim.card_flip_diagonal_out);
                            fragmentTransaction.replace(R.id.container, myFragment3,
                                    TAG_3);
                            fragmentTransaction.commit();
                            }
                        break;

                        default:

                            break;


                    }
                }

            //}
        });

        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int number = Integer.parseInt((String) textView_number.getText());
                textView_number.setText("" + (++number));

               // if ( fragmentManager.getFragments() == null) {

              //  } else {

                 //   String tag = fragmentManager.getFragments().get(fragmentManager.getFragments().size()-1).getTag();
                    switch (number) {
                        case 2: {

                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


                            fragmentTransaction.setCustomAnimations(R.anim.card_flip_left_in, R.anim.card_flip_left_out);
                           // fragmentTransaction.setCustomAnimations(R.anim.card_flip_diagonal_in, R.anim.card_flip_diagonal_out);
                            fragmentTransaction.replace(R.id.container, myFragment2, TAG_2);
                            fragmentTransaction.commit();
                            button_previous.setVisibility(View.VISIBLE);
                        }
                        break;
                        case 3:{
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.setCustomAnimations(R.anim.card_flip_right_out, R.anim.card_flip_right_in);
                            fragmentTransaction.replace(R.id.container, myFragment3,
                                    TAG_3);
                            fragmentTransaction.commit();}
                            break;
                        case 4:{
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.setCustomAnimations( R.anim.card_flip_top_out,R.anim.card_flip_top_in);
                            fragmentTransaction.replace(R.id.container, myFragment4,
                                    TAG_4);
                            fragmentTransaction.commit();}
                            break;
                        case 5:
                        {
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.setCustomAnimations(R.anim.card_flip_bottom_in,R.anim.card_flip_bottom_out);
                            fragmentTransaction.replace(R.id.container, myFragment5,
                                    TAG_5);
                            fragmentTransaction.commit();
                            button_next.setVisibility(View.INVISIBLE);}
                            break;

                        default:

                            break;


                    }
                }
           // }
        });


        myFragment = new MyFragment();
        myFragment2 = new MyFragment2();
        myFragment3 = new MyFragment3();
        myFragment4 = new MyFragment4();
        myFragment5 = new MyFragment5();

        if (savedInstanceState == null) {
            // при первом запуске программы
            FragmentTransaction fragmentTransaction = fragmentManager
                    .beginTransaction();
            // добавляем в контейнер при помощи метода add()
            fragmentTransaction.add(R.id.container, myFragment, TAG_1);
            fragmentTransaction.commit();
        }

    }
    }



