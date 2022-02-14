package com.example.myenquetesncf2a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class InscriptionActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btParticiper;
    private EditText txtNom, txtPrenom, txtEmail;
    private Spinner spAge, spFrequence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        this.txtNom = (EditText) findViewById(R.id.name);
        this.txtPrenom = (EditText) findViewById(R.id.prenom);
        this.txtEmail = (EditText) findViewById(R.id.email);

        this.btParticiper = (Button) findViewById(R.id.Valider);
        this.spAge = (Spinner) findViewById(R.id.age);
        this.spFrequence = (Spinner) findViewById(R.id.frequence);

        this.btParticiper.setOnClickListener(this);

        ArrayList<String> lesAges = new ArrayList<>();
        lesAges.add("0-18 ans");
        lesAges.add("19-35 ans");
        lesAges.add("36-62 ans");
        lesAges.add("62 ans et plus");
        ArrayAdapter unAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, lesAges);
        this.spAge.setAdapter(unAdapter);


        ArrayList<String> lesFrequences = new ArrayList<>();

        lesFrequences.add("Quotidienne");
        lesFrequences.add("Hebdomadaire");
        lesFrequences.add("Mensuelle");
        lesFrequences.add("Annuelle");
        unAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, lesFrequences);
        this.spFrequence.setAdapter(unAdapter);


    }

    @Override
    public void onClick(View v) {

    }
}