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

            Intent unIntent = new Intent(this, Page2Activity.class);
            unIntent.putExtra("rer", rer);
            unIntent.putExtra("email", email);

            Toast.makeText(this, "Bravo sale pute",Toast.LENGTH_SHORT).show();
            this.startActivity(unIntent);
        }

    }

}