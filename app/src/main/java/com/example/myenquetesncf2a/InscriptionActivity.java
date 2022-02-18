package com.example.myenquetesncf2a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

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

        if(v.getId() == R.id.Valider)
        {
            String email = this.txtEmail.getText().toString();
            String nom = this.txtPrenom.getText().toString();
            String prenom = this.txtNom.getText().toString();

            String age = this.spAge.getSelectedItem().toString();
            String frequence = this.spFrequence.getSelectedItem().toString();

            if(nom.equals("")){
                Toast.makeText(this, "Veuillez saisir le nom du candidat", Toast.LENGTH_LONG).show();
            }
            if(prenom.equals("")){
                Toast.makeText(this, "Veuillez saisir le prenom du candidat", Toast.LENGTH_LONG).show();
            }
            if(email.equals("")){
                Toast.makeText(this, "Veuillez saisir l'email du candidat", Toast.LENGTH_LONG).show();
            }
            if(!nom.equals("") && !prenom.equals("") && !email.equals(""))
            {
                //instanciation de la classe Candidat à l'enquete
                Candidat unCandidat = new Candidat (email, nom, prenom, age, frequence);

                //passage a la premiere page de l'enquete.
                Intent unIntent = new Intent(this, Page1Activity.class);
                String rer = this.getIntent().getStringExtra("rer").toString();
                if(! SNCF.getEnquete(rer).ajouterCandidat(unCandidat))
                {
                    Toast.makeText(this, "Candidat a déjà participé", Toast.LENGTH_LONG).show();
                }
                else
                {
                    unIntent.putExtra("rer", rer);
                    unIntent.putExtra("email", email);
                    Toast.makeText(this, "Bienvenue " + nom + " " + prenom,Toast.LENGTH_LONG).show();
                    this.startActivity(unIntent);
                }
            }
        }
    }
}