package com.example.myenquetesncf2a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Page1Activity extends AppCompatActivity implements View.OnClickListener {

    private Button btSuivant;
    private RadioGroup rbPonctulite, rbService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        this.btSuivant = (Button) findViewById(R.id.page1_Valider);
        this.rbPonctulite = (RadioGroup) findViewById(R.id.PonctualiGroup);
        this.rbService = (RadioGroup) findViewById(R.id.ServiceGroup);

        this.btSuivant.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.page1_Valider)
        {
            String email = this.getIntent().getStringExtra("email").toString();
            String rer = this.getIntent().getStringExtra("rer").toString();

            int score = 0;
            switch (this.rbPonctulite.getCheckedRadioButtonId())
            {
                case R.id.ponctualite1 : score = 16; break;
                case R.id.ponctualite2 : score = 12; break;
                case R.id.ponctualite3 : score = 8; break;
            }

            SNCF.getEnquete(rer).getCandidat(email).ajouterReponse("Ponctualite", score );

            score = 0;
            switch (this.rbService.getCheckedRadioButtonId())
            {
                case R.id.service1 : score = 16; break;
                case R.id.service2 : score = 12; break;
                case R.id.service3 : score = 8; break;
            }

            SNCF.getEnquete(rer).getCandidat(email).ajouterReponse("Service", score );

            Intent unIntent = new Intent(this, Page2Activity.class);
            unIntent.putExtra("rer", rer);
            unIntent.putExtra("email", email);

            this.startActivity(unIntent);
        }

    }

}