package br.com.academiafinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import br.com.academiafinal.adaptadores.AdapterListaMedidas;
import br.com.academiafinal.bd.BdMedidas;
import br.com.academiafinal.entidades.Medidas;

public class TelaMedidas extends AppCompatActivity {

    FloatingActionButton btnNovaMedida;
    RecyclerView recyListaMedidas;
    ArrayList<Medidas> listaArrayMedidas;
    AdapterListaMedidas adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_medidas);
        btnNovaMedida = findViewById(R.id.floating_nova_medida);
        recyListaMedidas= findViewById(R.id.recyclerview_lista_medidas);
        recyListaMedidas.setLayoutManager(new LinearLayoutManager(this));

        BdMedidas bdMedidas = new BdMedidas(TelaMedidas.this);

        listaArrayMedidas = new ArrayList<>();

        adapter = new AdapterListaMedidas(bdMedidas.mostrarMedidas());
        recyListaMedidas.setAdapter(adapter);

        btnNovaMedida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaMedidas.this, Nova_medida.class);
                startActivity(intent);
            }
        });
    }
}