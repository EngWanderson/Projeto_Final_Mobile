package br.com.academiafinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Treinos extends AppCompatActivity {

    CardView btnSegunda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treinos);
        btnSegunda=findViewById(R.id.treinoSegunda);

        btnSegunda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Treinos.this, TreinoSegunda.class);
                startActivity(intent);
            }
        });
    }
}