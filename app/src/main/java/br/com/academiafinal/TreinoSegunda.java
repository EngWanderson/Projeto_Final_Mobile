package br.com.academiafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TreinoSegunda extends AppCompatActivity {

    FloatingActionButton addExercicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treino_segunda);
        addExercicio = findViewById(R.id.addExercicio);

        addExercicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TreinoSegunda.this, Escolha_exercicio.class);
                startActivity(intent);
            }
        });
    }
}