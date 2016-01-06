package com.test.lesson18;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.otto.Subscribe;
import com.test.lesson18.events.CurrencyResponse;
import com.test.lesson18.network.ServiceHelper;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               callRest();


            }
        });

    }


    public void callRest(){
        ServiceHelper.getInstance().retriveCurrency();
    }
   @Subscribe
    public void onResponse(CurrencyResponse response){



       if(response.isError()) {
           Toast.makeText(this,"ERROR REST", Toast.LENGTH_SHORT).show();
       }
       else {
           String message = "OK ";//+response.getCurrency().getDate();
           Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
       }


    }


    @Override
    protected void onResume() {
        super.onResume();
        OttoProvider.getBus().register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        OttoProvider.getBus().unregister(this);
    }
}
