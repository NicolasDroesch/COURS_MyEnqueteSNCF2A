package com.example.myenquetesncf2a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class PageFinActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btFin;
    private ImageView imgSmiley;
    private TextView tvResultat;
    private ListView lvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_fin);

        this.btFin = (Button) findViewById(R.id.Fin);
        this.imgSmiley = (ImageView) findViewById(R.id.monImageDeFin);
        this.tvResultat = (TextView) findViewById(R.id.resultat);
        this.lvList = (ListView) findViewById(R.id.maList);

        this.btFin.setOnClickListener(this);

        String rer = this.getIntent().getStringExtra("rer").toString();
        String email = this.getIntent().getStringExtra("email").toString();

        float moyenne = SNCF.getEnquete(rer).getCandidat(email).moyenneScore();
        String nom = SNCF.getEnquete(rer).getCandidat(email).getNom();
        String prenom = SNCF.getEnquete(rer).getCandidat(email).getPrenom();

        this.tvResultat.setText("Résultat Enquete de M./Mme " + nom + " " + prenom);

        if(moyenne < 10)
        {
            this.imgSmiley.setImageResource(R.drawable.smiley_3);
        }
        else if(moyenne < 14)
        {
            this.imgSmiley.setImageResource(R.drawable.smiley_2);
        }
        else
        {
            this.imgSmiley.setImageResource(R.drawable.smiley_1);
        }

        ArrayList<String> lesResultats = new ArrayList<>();
        for (Candidat unCandidat : SNCF.getEnquete(rer).getLesCandidats().values())
        {
            lesResultats.add(unCandidat.getNom() + " " +
                    unCandidat.getPrenom() + " " +
                    unCandidat.moyenneScore());
        }
        ArrayAdapter unAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lesResultats);
        this.lvList.setAdapter(unAdapter);
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