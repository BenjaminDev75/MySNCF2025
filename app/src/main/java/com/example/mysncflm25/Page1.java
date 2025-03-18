package com.example.mysncflm25;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Page1 extends AppCompatActivity implements View.OnClickListener {

    private RadioGroup rgRegularite, rgProprete;
    private Button btnSuivant;
    private String email, rer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_page1);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        this.rgRegularite = findViewById(R.id.idRegularite);
        this.rgProprete = findViewById(R.id.idProprete);
        this.btnSuivant = findViewById(R.id.idSuivant);

        this.rer = getIntent().getStringExtra("rer");
        this.email = getIntent().getStringExtra("email");

        this.btnSuivant.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.idSuivant) {
            // On enregistre les scores de réponse
            int score = 0;

            // Vérification de la sélection pour Regularite
            if (rgRegularite.getCheckedRadioButtonId() == R.id.idRegularite1) {
                score = 16;
            } else if (rgRegularite.getCheckedRadioButtonId() == R.id.idRegularite2) {
                score = 12;
            } else if (rgRegularite.getCheckedRadioButtonId() == R.id.idRegularite3) {
                score = 8;
            }

            SNCF.getEnquete(this.rer).getParticipant(email).ajouterReponse("Regularite", score);

            // Réinitialisation du score pour Proprete
            score = 0;

            // Vérification de la sélection pour Proprete
            if (rgProprete.getCheckedRadioButtonId() == R.id.idProprete1) {
                score = 16;
            } else if (rgProprete.getCheckedRadioButtonId() == R.id.idProprete2) {
                score = 12;
            } else if (rgProprete.getCheckedRadioButtonId() == R.id.idProprete3) {
                score = 8;
            }

            SNCF.getEnquete(this.rer).getParticipant(email).ajouterReponse("Proprete", score);

            // On passe à la page suivante
            Intent unIntent = new Intent(this, Page2.class);
            unIntent.putExtra("rer", this.rer);
            unIntent.putExtra("email", this.email);
            startActivity(unIntent);
        }
    }
}
