package com.example.zineb.progetto_contapassi;

<<<<<<< HEAD
=======
import android.app.AlertDialog;
import android.database.Cursor;
>>>>>>> origin/master
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
<<<<<<< HEAD
=======
import android.widget.Toast;
>>>>>>> origin/master

public class DatabaseTest extends Activity {

    EditText nameSessionET;
    EditText jasonFileET;
    EditText dateET;
    EditText speedET;
    EditText stepsET;
    EditText x_speedET;
    EditText x_stepsET;

    Button btnAddSession;
<<<<<<< HEAD
=======
    Button btnShowAll;
>>>>>>> origin/master

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_test);
<<<<<<< HEAD
        getActionBar().setDisplayHomeAsUpEnabled(true);
=======
>>>>>>> origin/master

        nameSessionET = (EditText) findViewById(R.id.nameSessionET);
        jasonFileET = (EditText) findViewById(R.id.jasonfileET);
        dateET = (EditText) findViewById(R.id.dateET);
        speedET = (EditText) findViewById(R.id.speedET);
        stepsET = (EditText) findViewById(R.id.stepsET);
        x_speedET = (EditText) findViewById(R.id.x_speedET);
        x_stepsET = (EditText) findViewById(R.id.x_stepsET);
<<<<<<< HEAD
=======
        btnAddSession = (Button) findViewById(R.id.btnSave);
        btnShowAll = (Button) findViewById(R.id.btnshow);

        addSession();
<<<<<<< HEAD
        showAll();
=======
>>>>>>> origin/master
>>>>>>> origin/master
    }

    public void addSession(){
        btnAddSession.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
<<<<<<< HEAD
                        MainActivity.myDb.insertData(nameSessionET.getText().toString(),
=======
                        boolean isInserted = MainActivity.myDb.insertData(nameSessionET.getText().toString(),
>>>>>>> origin/master
                                                     jasonFileET.getText().toString(),
                                                    dateET.getText().toString(),
                                                    Double.parseDouble(speedET.getText().toString()),
                                                    Integer.parseInt(stepsET.getText().toString()),
                                                    Double.parseDouble(x_speedET.getText().toString()),
                                                    Integer.parseInt(x_stepsET.getText().toString()));
<<<<<<< HEAD
=======
                        if(isInserted){
                            Toast.makeText(DatabaseTest.this,"Session Saved",Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(DatabaseTest.this,"OOPS, Session NOT Saved",Toast.LENGTH_LONG).show();
                        }
>>>>>>> origin/master
                    }
                }
        );
    }
<<<<<<< HEAD
=======
    public void showAll(){
        btnShowAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = MainActivity.myDb.getAllData();
                if(res.getCount()==0){
                    //show message
                    showMessage("Error","Nothing found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("Id : "+res.getString(0)+"\n");
                    buffer.append("name : "+res.getString(1)+"\n");
                    buffer.append("js : "+res.getString(2)+"\n");
                    buffer.append("date : "+res.getString(3)+"\n");
                    buffer.append("speed : "+res.getString(4)+"\n");
                    buffer.append("steps : "+res.getString(5)+"\n");
                    buffer.append("x-speed : "+res.getString(6)+"\n");
                    buffer.append("x-steps : "+res.getString(7)+"\n");
                }
                //show All
                showMessage("Data",buffer.toString());
            }
        });
    }

    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
>>>>>>> origin/master

}
