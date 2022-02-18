package com.example.myenquetesncf2a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton rerA;
    private ImageButton rerB;
    private ImageButton rerC;
    private ImageButton rerD;
    private ImageButton rerE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.rerA = (ImageButton) findViewById(R.id.rerA);
        this.rerB = (ImageButton) findViewById(R.id.rerB);
        this.rerC = (ImageButton) findViewById(R.id.rerC);
        this.rerD = (ImageButton) findViewById(R.id.rerD);
        this.rerE = (ImageButton) findViewById(R.id.rerE);

        this.rerA.setOnClickListener(this);
        this.rerB.setOnClickListener(this);
        this.rerC.setOnClickListener(this);
        this.rerD.setOnClickListener(this);
        this.rerE.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String rer = "";

        switch(v.getId())
        {
            case R.id.rerA: rer = "rerA"; break;
            case R.id.rerB: rer = "rerB"; break;
            case R.id.rerC: rer = "rerC"; break;
            case R.id.rerD: rer = "rerD"; break;
            case R.id.rerE: rer = "rerE"; break;
        }
        //on page a la page suivante en envoyant le rer
        Intent unIntent = new Intent(this, InscriptionActivity.class);
        SNCF.initialiser();
        unIntent.putExtra("rer", rer);
        this.startActivity(unIntent);
    }
}