package com.example.zineb.progetto_contapassi;

import android.app.Activity;
<<<<<<< HEAD

=======
>>>>>>> origin/master
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import java.lang.Runnable;
import android.os.Handler;

public class MainActivity extends Activity implements Runnable {

    static DataBaseHelper myDb;
    //private final static String REGISTRATION_PREFERENCES = "RegPref";
   // private final static String REGISTRATION_DATA = "RegDat";
    //verifico che la registrazione sia già stata effettuata
    //SharedPreferences prefs = getSharedPreferences(REGISTRATION_PREFERENCES, Context.MODE_PRIVATE);
   // boolean a = prefs.getBoolean(REGISTRATION_DATA, true);
    boolean b = true;

<<<<<<< HEAD




        static SharedPreferences sharedFirstTime;
        public static final String MyPREF = "FirstTime" ;
=======



>>>>>>> origin/master

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD
<<<<<<< HEAD

         sharedFirstTime = getSharedPreferences(MyPREF, Context.MODE_PRIVATE);
         SharedPreferences.Editor editor = sharedFirstTime.edit();

         editor.putBoolean("FirstTime", false);
         editor.commit();



=======
        myDb = new DataBaseHelper(this);
>>>>>>> origin/master
        Button bnt = (Button)findViewById(R.id.buttonWelc);
        bnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(sharedFirstTime.equals(true))
                startActivity(new Intent(MainActivity.this, Fourth.class));

                startActivity(new Intent(MainActivity.this, Second.class));
            }
        });
<<<<<<< HEAD
=======
        Button dbTest = (Button) findViewById(R.id.dbTest);
        dbTest.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DatabaseTest.class);
                startActivity(intent);
            }
        });

>>>>>>> origin/master
=======
        Handler mHandler = new Handler();
        mHandler.postDelayed(this, 2500);

<<<<<<< HEAD
>>>>>>> origin/master
        myDb = new DataBaseHelper(this);

<<<<<<< HEAD


    }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
=======
=======
        myDb = new DataBaseHelper(this);
>>>>>>> origin/master
    }

>>>>>>> origin/master
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
<<<<<<< HEAD
>>>>>>> origin/master
=======
>>>>>>> origin/master
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void run ()
    {
        if (b) {    //se la prima registrazione è stata effetuata passo direttamente al contappassi
            Intent intent = new Intent(this, Second.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, CoreActivity.class);
            startActivity(intent);
        }

    }

}
