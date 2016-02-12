package com.example.zineb.progetto_contapassi;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class Third extends Activity implements View.OnClickListener{

    SharedPreferences sharedpreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        EditText name = (EditText)findViewById(R.id.name);
        final Button button = (Button) findViewById(R.id.buttonSave);
        button.setOnClickListener(this);

    }




    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch ( v.getId() ) {
            case R.id.buttonSave:
                final EditText edit_name = (EditText)findViewById(R.id.name);
                final EditText edit_age = (EditText)findViewById(R.id.age);
                final EditText edit_peso = (EditText)findViewById(R.id.peso);
                final EditText edit_altezza = (EditText)findViewById(R.id.altezza);
                final EditText edit_sesso = (EditText)findViewById(R.id.sex);
                final EditText edit_step = (EditText)findViewById(R.id.step);
                final EditText edit_mail = (EditText)findViewById(R.id.mail);
                Bundle bundle = new Bundle();
                bundle.putString("name", edit_name.getText().toString());
                bundle.putString("lastname", edit_altezza.getText().toString());



                JSONObject obj = new JSONObject();
                try {
                    obj.put("name", edit_name.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    obj.put("age", edit_age.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    obj.put("peso", edit_peso.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    obj.put("altezza", edit_altezza.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    obj.put("sesso", edit_sesso.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    obj.put("step", edit_step.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    obj.put("mail", edit_mail.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                try {

                    FileWriter file = new FileWriter("c:\\test.json");
                    file.write(obj.toString());
                    file.flush();
                    file.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.print(obj);



                final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                emailIntent.setType("plain/text");
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{""});
                emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "");
                emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Questi sono i tuoi dati!");

                //L'allegato è opzionale
                Uri attachment = Uri.parse("file:///sdcard/test.json");
                emailIntent.putExtra(Intent.EXTRA_STREAM, attachment);

                startActivity(Intent.createChooser(emailIntent, "Invia email..."));;

                break;
        }
    }
}

