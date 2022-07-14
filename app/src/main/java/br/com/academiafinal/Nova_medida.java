package br.com.academiafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.academiafinal.bd.BdMedidas;

public class Nova_medida extends AppCompatActivity {

    EditText txtNome, txtPescoco, txtOmbro, txtPeitoral, txtabdome, txtcintura, txtquadril, txtbiceps, txtantebraco, txtcoxa, txtpanturilha,txtbiceps2, txtantebraco2, txtcoxa2, txtpanturilha2;
    Button btnSalvar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_medida);

        txtNome=findViewById(R.id.txtNome);
        txtPescoco = findViewById(R.id.txtPescoco);
        txtOmbro = findViewById(R.id.txtOmbro);
        txtPeitoral = findViewById(R.id.txtPeitoral);
        txtabdome = findViewById(R.id.txtAbdome);
        txtcintura= findViewById(R.id.txtCintura);
        txtquadril = findViewById(R.id.txtQuadril);
        txtbiceps = findViewById(R.id.txtBiceps);
        txtantebraco = findViewById(R.id.txtAnteBraço);
        txtcoxa = findViewById(R.id.txtCoxa);
        txtpanturilha = findViewById(R.id.txtPanturrilha);
        txtbiceps2 = findViewById(R.id.txtBiceps2);
        txtantebraco2 = findViewById(R.id.txtAnteBraço2);
        txtcoxa2 = findViewById(R.id.txtCoxa2);
        txtpanturilha2 = findViewById(R.id.txtPanturrilha2);

        btnSalvar = findViewById(R.id.salvarMedidas);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!txtNome.getText().toString().equals("") && !txtOmbro.getText().toString().equals("")){
                    BdMedidas bdMedidas = new BdMedidas(Nova_medida.this);
                    long id = bdMedidas.insertarMedidas(txtNome.getText().toString(), txtPescoco.getText().toString(), txtOmbro.getText().toString(),
                            txtPeitoral.getText().toString(), txtabdome.getText().toString(), txtcintura.getText().toString(), txtquadril.getText().toString(), txtbiceps.getText().toString(), txtantebraco.getText().toString(),
                            txtcoxa.getText().toString(), txtpanturilha.getText().toString(), txtbiceps2.getText().toString(), txtantebraco2.getText().toString(), txtcoxa2.getText().toString(), txtpanturilha2.getText().toString());

                    if (id>0){
                        Toast.makeText(Nova_medida.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                        limpiar();
                        voltarTelaInicial();
                    }else {
                        Toast.makeText(Nova_medida.this, "ERRO AO GUARDAR REGISTROS", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(Nova_medida.this, "TODOS OS CAMPOS SÃO OBRIGATORIOS", Toast.LENGTH_LONG).show();
                }
            }

        });
    }
    private void limpiar() {
        txtNome.setText("");
        txtPescoco.setText("");
        txtOmbro.setText("");
        txtPeitoral.setText("");
    }
    private void voltarTelaInicial(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}