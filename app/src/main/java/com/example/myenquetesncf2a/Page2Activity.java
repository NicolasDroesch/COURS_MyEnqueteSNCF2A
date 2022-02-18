package com.example.myenquetesncf2a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class Page2Activity extends AppCompatActivity implements View.OnClickListener {

    private Button btTerminer;
    private RadioGroup rbInformation, rbProprete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        this.btTerminer = (Button) findViewById(R.id.page2_Valider);
        this.rbProprete = (RadioGroup) findViewById(R.id.propreteGroup);
        this.rbInformation = (RadioGroup) findViewById(R.id.InformationGroup);

        this.btTerminer.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.page2_Valider)
        {
            String email = this.getIntent().getStringExtra("email").toString();
            String rer = this.getIntent().getStringExtra("rer").toString();

            int score = 0;
            switch (this.rbInformation.getCheckedRadioButtonId())
            {
                case R.id.information1 : score = 16; break;
                case R.id.information2 : score = 12; break;
                case R.id.information3 : score = 8; break;
            }

            SNCF.getEnquete(rer).getCandidat(email).ajouterReponse("Ponctualite", score );

            score = 0;
            switch (this.rbProprete.getCheckedRadioButtonId())
            {
                case R.id.proprete1 : score = 16; break;
                case R.id.proprete2 : score = 12; break;
                case R.id.proprete3 : score = 8; break;
            }

            SNCF.getEnquete(rer).getCandidat(email).ajouterReponse("Service", score );

            Intent unIntent = new Intent(this, PageFinActivity.class);
            unIntent.putExtra("rer", rer);
            unIntent.putExtra("email", email);

            this.startActivity(unIntent);
        }
    }
}