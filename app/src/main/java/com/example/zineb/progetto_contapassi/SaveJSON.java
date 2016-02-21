package com.example.zineb.progetto_contapassi;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SaveJSON extends Activity implements View.OnClickListener {
    // variabili che contengono i dati dell'allenamento (temporaneo)
    private String nameTraining = "Esempio Allenamento";
    private double DISTANCE = 10;
    private double SAT = 6.59;
    private double SAM = 7;
    private double RAT = 09.01;
    private double RAM = 10;

    private String emailAddress = null;

    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.savejson);

        // creazione e lettura file JSON
        try {
            // richiama la funzione per creare il file JSON
            createJSON();

            try {
                // richiama la funzione per leggere il file JSON appena creato
                readJSON();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // invio email
        EditText EditTextEmailAddress = (EditText) findViewById(R.id.EditTextEmailAddress);
        Button bntSendEmail = (Button) findViewById(R.id.bntSendEmail);
        bntSendEmail.setOnClickListener(this);
    }

    public void createJSON() throws IOException, JSONException {
        // i dati vengono presi da variabili locali in attesa dell'implementazione dell'activity

        JSONObject training = new JSONObject();

        training.put(this.getString(R.string.distance), DISTANCE);
        training.put(this.getString(R.string.speed_avg_total), SAT);
        training.put(this.getString(R.string.speed_avg_meters), SAM);
        training.put(this.getString(R.string.rhythm_avg_total), RAT);
        training.put(this.getString(R.string.rhythm_avg_meters), RAM);


        String text = training.toString();

        FileOutputStream fos = openFileOutput(nameTraining, MODE_PRIVATE);
        fos.write(text.getBytes());
        fos.close();

        Toast.makeText(this, "File JSON creato!", Toast.LENGTH_SHORT).show();
    }

    public void readJSON() throws IOException, JSONException {

        FileInputStream fis = openFileInput(nameTraining);
        BufferedInputStream bis = new BufferedInputStream(fis);
        StringBuffer b = new StringBuffer();

        while (bis.available() != 0) {
            char c = (char) bis.read();
            b.append(c);
        }
        bis.close();
        fis.close();

        JSONObject training = new JSONObject(String.valueOf(b));

        String distance = training.getString(this.getString(R.string.distance));
        String sat = training.getString(this.getString(R.string.speed_avg_total));
        String sam = training.getString(this.getString(R.string.speed_avg_meters));
        String rat = training.getString(this.getString(R.string.rhythm_avg_total));
        String ram = training.getString(this.getString(R.string.rhythm_avg_meters));

        TextView tNameTraining = (TextView) findViewById(R.id.TextViewNameTraining);
        TextView tDistance = (TextView) findViewById(R.id.TextViewDistance);
        TextView tSAT = (TextView) findViewById(R.id.TextViewSpeedAverageTotal);
        TextView tSAM = (TextView) findViewById(R.id.TextViewSpeedAverageMeters);
        TextView tRAT = (TextView) findViewById(R.id.TextViewRhythmAverageTotal);
        TextView tRAM = (TextView) findViewById(R.id.TextViewRhythmAverageMeters);

        tNameTraining.setText(nameTraining);
        tDistance.setText(distance);
        tSAT.setText(sat);
        tSAM.setText(sam);
        tRAT.setText(rat);
        tRAM.setText(ram);
    }

    public boolean sendEmail(View v, String indirizzo) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        // destinatario
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{indirizzo});
        // oggetto
        i.putExtra(Intent.EXTRA_SUBJECT, "Prova invio file JSON");
        // testo email
        i.putExtra(Intent.EXTRA_TEXT, "Questa è una prova, scusa.");
        // allegato
        //Uri attachment = Uri.parse("file:///sdcard/Pictures/cape.jpg");
        // non funziona perchè non so dove salva il file
        // non importante perchè dovrà essere estratto dal database
        //Uri attachment = Uri.parse(valName);

        //i.putExtra(Intent.EXTRA_STREAM, attachment);

        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
            return true;
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bntSendEmail:
                //inviare email (manca allegato)
                EditText etxtemail = (EditText) findViewById(R.id.EditTextEmailAddress);
                emailAddress = etxtemail.getText().toString();
                Toast.makeText(this, emailAddress, Toast.LENGTH_SHORT).show();
                if (!sendEmail(v, emailAddress)) {
                    Toast.makeText(this, "Errore: email non inviata!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
