package com.example.zineb.progetto_contapassi;

import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

import java.util.jar.Attributes;

public class Fourth extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        final TextView text = (TextView)findViewById(R.id.textView);
        String nom = Third.sharedpreferences.getString("Name", null);
        Boolean valeur = MainActivity.sharedFirstTime.getBoolean("FirstTime",true);

        text.setText(nom +" "+ valeur);

    }

}
