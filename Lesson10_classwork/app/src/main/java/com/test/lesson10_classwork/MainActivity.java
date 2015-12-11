package com.test.lesson10_classwork;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.BoringLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.squareup.picasso.Picasso;
import com.test.lesson10_classwork.UI.ActivityListener;
import com.test.lesson10_classwork.UI.MaterialMenuDrawable;
import com.test.lesson10_classwork.fragments.FragmentDetails;
import com.test.lesson10_classwork.fragments.ListFragment;
import com.test.lesson10_classwork.services.MyIntentService;
import com.test.lesson10_classwork.services.MyService;


public class MainActivity extends ActionBarActivity  implements ActivityListener{



    private TextView mTitleView;
    private MaterialMenuDrawable mMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);


     setContentView(R.layout.activity_main);

     initToolbar();

     FragmentTransaction tr = getSupportFragmentManager().beginTransaction();

        ListFragment fragment = ListFragment.getInstance("djkgfhsg",getIntent());
        tr.replace(R.id.container,fragment,"First");
        tr.commit();

       // FrameLayout container2  = (FrameLayout) findViewById(R.id.container2);
        //if (container2 !=null){

         /*   FragmentTransaction tr2 = getSupportFragmentManager().beginTransaction();

            FragmentDetails fragment2 = new FragmentDetails();
            tr2.replace(R.id.container,fragment2);
            tr2.addToBackStack(null);
            tr2.commit();
*/
       // }


    }




    private void initToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setContentInsetsAbsolute(0,0);
        mTitleView = (TextView) findViewById(R.id.tv_title);
        mMenu = new MaterialMenuDrawable(this, Color.WHITE,MaterialMenuDrawable.Stroke.REGULAR,300);

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
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
            // тут выполняется код с правами доступа
        }

    }

    @Override
    public void setTitle(String title) {
        mTitleView.setText(title);
    }

    @Override
    public void changeFragment(Fragment fragment) {

    }

    public class  MyAsyncTask extends AsyncTask<Void,Integer,Boolean>{


        public MyAsyncTask() {
        }

        @Override
        protected Boolean doInBackground(Void... param) {
            // только то, что написано здесь запускается в другом потоке

            Log.d("aaa","doInBackground");
            int i = 0;
            while (i<10){

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                publishProgress(i);
                i++;
            }



            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            Log.d("aaa","onProgressUpdate");
            Toast.makeText(MainActivity.this, "ipdate" + values[0],
                    Toast.LENGTH_SHORT).
                    show();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // срабатывает на старте
            // тут можно обновить интерфейс
            Log.d("aaa","onPreExecute");
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            //после выполнения doinBackground
            // тут можно обновить интерфейс
            Log.d("aaa","onPostExecute");
            super.onPostExecute(aBoolean);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();

            // doinBackground выполнится, но результат не вернет
        }
    }





        //ImageView imageView = (ImageView) findViewById(R.id.imageView);
       // Picasso.with(this).load("http://i.imgur.com/DvpvklR.png").
           //     into(imageView);

      //  Manager m1 = new Manager(this);// TODO разные способы получения контекста
       // Manager m2 = new Manager(MyApp.getInstance());
       // Manager m3 = new Manager(this.getApplicationContext());




    @Override
    protected void onStart() {
        super.onStart();



        //IntentFilter filter =  new IntentFilter();
      //  filter.addAction(MyService.ACTION_MY) ; // устанавливаем фильтр
        //LocalBroadcastManager.getInstance(this).registerReceiver(receiver,filter);

       // startService(new Intent(this, MyService.class));

        //bindService(new Intent(this,MyService.class),serviceConnection,BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
       //stopService(new Intent(this,MyService.class));
      // unbindService(serviceConnection);
    }


    private ServiceConnection  serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder service) {
            Log.d("11111111","onServiceConnected");
           // mMyService = (MyService)service;

          //  MyService.LocalBinder binder = (MyService.LocalBinder) service;
          //  mMyService = binder.getService();
           // mMyService.makeSome();

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d("111111111","onServiceDisconnected");
        }
    };

   /* private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            int value = intent.getIntExtra(MyService.KEY_VALUE,0);

            Toast.makeText(MainActivity.this, "value =" + value,Toast.LENGTH_SHORT).show();
        }
    };
    */
}
