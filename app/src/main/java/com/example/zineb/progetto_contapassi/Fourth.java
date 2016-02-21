package com.example.zineb.progetto_contapassi;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.jar.Attributes;

public class Fourth extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        final TextView text = (TextView)findViewById(R.id.textView);
        String nom = Third.sharedpreferences.getString("Name", null);
        Boolean valeur = MainActivity.sharedFirstTime.getBoolean("FirstTime",true);

        text.setText(nom +" "+ valeur);

        // test JSON
        Button bnt = (Button) findViewById(R.id.buttonTestJSON);
        bnt.setOnClickListener(this);
        // test JSON

    }

    // test JSON
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonTestJSON:
                Intent i = new Intent (this, SaveJSON.class);
                startActivity(i);
        }
    }
    // test JSON
}
