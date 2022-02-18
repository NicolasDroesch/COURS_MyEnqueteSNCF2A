package com.example.myenquetesncf2a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Page3Activity extends AppCompatActivity implements View.OnClickListener{
    private Button btSuivant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);
        this.btSuivant = (Button) findViewById(R.id.page3_suivant);
        this.btSuivant.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.page3_suivant)
        {
            String email = this.getIntent().getStringExtra("email").toString();
            String rer = this.getIntent().getStringExtra("rer").toString();

            Intent unIntent = new Intent(this, PageFinActivity.class);
            unIntent.putExtra("rer", rer);
            unIntent.putExtra("email", email);

            this.startActivity(unIntent);

        }
    }
}