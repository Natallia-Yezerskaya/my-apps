package com.test.lesson19;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.File;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takeFoto();
            }
        });





    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @TargetApi(23)
    public  void takeFoto(){
        if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.M) {
            int result = checkCallingOrSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);

            if (result == PackageManager.PERMISSION_DENIED) {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
                return;
            }
        }

            Intent intent  = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (intent.resolveActivity(getPackageManager())!=null){
                File foto = getFotoPath();
                if (foto!=null){
                   intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(foto));
                    startActivityForResult(intent,123);
                }
            }

  }

    private File getFoto(){
        return new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "/my images/"+"photo.jpg");

    }

    private File getFotoPath(){
        File root = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "my images");

       if (!root.exists()){
           if (root.mkdir()){
               return null;
           }
       }

        return  new File(root.getAbsolutePath()+"/"+"photo.jpg");

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 123:
                File file = getFoto();

                if (file!=null && file.exists()){
                    Log.d("FOTO",file.getAbsolutePath());
                }
                break;


        }



    }

}