package com.example.myenquetesncf2a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class PageFinActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btFin;
    private ImageView imgSimple;
    private TextView tvResultat;
    private ListView lvList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_fin);

        this.btFin = (Button) findViewById(R.id.Fin);
        this.imgSimple = (ImageView) findViewById(R.id.monImageDeFin);
        this.tvResultat = (TextView) findViewById(R.id.resultat);
        this.lvList = (ListView) findViewById(R.id.maList);

        this.btFin.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.Fin)
        {
            Intent unIntent = new Intent(this, MainActivity.class);
            Toast.makeText(this, "Merci d'avoir participé a l'enquête", Toast.LENGTH_LONG).show();
            this.startActivity(unIntent);
        }

    }
}