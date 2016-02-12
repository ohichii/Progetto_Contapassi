package com.example.zineb.progetto_contapassi;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DatabaseTest extends Activity {

    EditText nameSessionET;
    EditText jasonFileET;
    EditText dateET;
    EditText speedET;
    EditText stepsET;
    EditText x_speedET;
    EditText x_stepsET;

    Button btnAddSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_test);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        nameSessionET = (EditText) findViewById(R.id.nameSessionET);
        jasonFileET = (EditText) findViewById(R.id.jasonfileET);
        dateET = (EditText) findViewById(R.id.dateET);
        speedET = (EditText) findViewById(R.id.speedET);
        stepsET = (EditText) findViewById(R.id.stepsET);
        x_speedET = (EditText) findViewById(R.id.x_speedET);
        x_stepsET = (EditText) findViewById(R.id.x_stepsET);
    }

    public void addSession(){
        btnAddSession.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MainActivity.myDb.insertData(nameSessionET.getText().toString(),
                                                     jasonFileET.getText().toString(),
                                                    dateET.getText().toString(),
                                                    Double.parseDouble(speedET.getText().toString()),
                                                    Integer.parseInt(stepsET.getText().toString()),
                                                    Double.parseDouble(x_speedET.getText().toString()),
                                                    Integer.parseInt(x_stepsET.getText().toString()));
                    }
                }
        );
    }

}
