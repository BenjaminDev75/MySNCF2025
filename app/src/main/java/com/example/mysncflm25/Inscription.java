package com.example.mysncflm25;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Inscription extends AppCompatActivity implements View.OnClickListener {

    private EditText txtNom, txtPrenom, txtEmail;
    private Spinner spAge, spFrequence;
    private Button btnParticiper;
    private String rer, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inscription);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        this.txtNom = (EditText) findViewById(R.id.idNom);
        this.txtPrenom = (EditText) findViewById(R.id.idPrenom);
        this.txtEmail = (EditText) findViewById(R.id.idEmail);
        this.btnParticiper = (Button) findViewById(R.id.idParticiper);
        this.spAge = (Spinner) findViewById(R.id.idAge);
        this.spFrequence = (Spinner) findViewById(R.id.idFrequence);

        this.btnParticiper.setOnClickListener(this);

        // je recupère le nom du rer
        this.rer = this.getIntent().getStringExtra("rer");

        // remplir les spinners
        ArrayList<String> lesAges = new ArrayList<>();
        lesAges.add("6 ans à 18 ans");
        lesAges.add("19 ans à 35 ans");
        lesAges.add("36 ans à 64 ans");
        lesAges.add("65 ans et plus");
        ArrayAdapter unAdapteurAge = new ArrayAdapter(this, android.R.layout.simple_spinner_item, lesAges);
        this.spAge.setAdapter(unAdapteurAge);

        ArrayList<String> lesFrequences = new ArrayList<>();
        lesFrequences.add("Journalière");
        lesFrequences.add("Hebdomadaire");
        lesFrequences.add("Mensuelle");
        lesFrequences.add("Annuelle");
        ArrayAdapter unAdapteurFrequence = new ArrayAdapter(this, android.R.layout.simple_spinner_item, lesFrequences);
        this.spFrequence.setAdapter(unAdapteurFrequence);



    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.idParticiper){
            Intent unIntent = new Intent(this, Page1.class);
            String nom = this.txtNom.getText().toString();
            String prenom = this.txtPrenom.getText().toString();
            String email = this.txtEmail.getText().toString();
            String age = this.spAge.getSelectedItem().toString();
            String frequence = this.spFrequence.getSelectedItem().toString();

            // enregistrer le participant

            Participant unParticipant = new Participant(nom, prenom, email, age, frequence);
            // on ajoute ce participant à l'enquete qu'il à choisie
            SNCF.getEnquete(this.rer).ajouterParticipant(unParticipant);


            // on va faire passer le rer et email
            unIntent.putExtra("rer", this.rer);
            unIntent.putExtra("email", email);
            Toast.makeText(this,"Bienvenue " + nom + " " + prenom, Toast.LENGTH_LONG).show();
            startActivity(unIntent);

        }

    }
}