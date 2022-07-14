package br.com.academiafinal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.academiafinal.bd.BdMedidas;
import br.com.academiafinal.entidades.Medidas;

public class VerMedidas extends AppCompatActivity {

    EditText txtNome, txtPescoco, txtOmbro, txtPeitoral, txtabdome, txtcintura, txtquadril, txtbiceps, txtantebraco, txtcoxa, txtpanturilha,txtbiceps2, txtantebraco2, txtcoxa2, txtpanturilha2;

    Button fabEditar, fabEliminar;

    Medidas medidas;

    int id = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_medidas);
        txtNome = findViewById(R.id.txtNome);
        txtOmbro = findViewById(R.id.txtOmbro);
        txtPescoco = findViewById(R.id.txtPescoco);
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


        fabEditar = findViewById(R.id.fabEditar);
        fabEliminar = findViewById(R.id.fabEliminar);


        if(savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if(extras == null){
                id = Integer.parseInt(null);
            } else {
                id = extras.getInt("ID");
            }
        } else {
            id = (int) savedInstanceState.getSerializable("ID");
        }

        final BdMedidas bdMedidas = new BdMedidas(VerMedidas.this);
        medidas = bdMedidas.verMedidas(id);

        if (medidas!= null){
            txtNome.setText(medidas.getNome());
            txtNome.setInputType(InputType.TYPE_NULL);
            txtPescoco.setText(medidas.getPescoco());
            txtPescoco.setInputType(InputType.TYPE_NULL);
            txtOmbro.setText(medidas.getOmbro());
            txtOmbro.setInputType(InputType.TYPE_NULL);
            txtPeitoral.setText(medidas.getPeitoral());
            txtPeitoral.setInputType(InputType.TYPE_NULL);

            txtabdome.setText(medidas.getAbdome());
            txtabdome.setInputType(InputType.TYPE_NULL);
            txtcintura.setText(medidas.getCintura());
            txtcintura.setInputType(InputType.TYPE_NULL);
            txtquadril.setText(medidas.getCintura());
            txtquadril.setInputType(InputType.TYPE_NULL);

            txtbiceps.setText(medidas.getBiceps());
            txtbiceps.setInputType(InputType.TYPE_NULL);
            txtantebraco.setText(medidas.getAntebraco());
            txtantebraco.setInputType(InputType.TYPE_NULL);
            txtcoxa.setText(medidas.getCoxa());
            txtcoxa.setInputType(InputType.TYPE_NULL);
            txtpanturilha.setText(medidas.getPanturrilha());
            txtpanturilha.setInputType(InputType.TYPE_NULL);


            txtbiceps2.setText(medidas.getBiceps2());
            txtbiceps2.setInputType(InputType.TYPE_NULL);
            txtantebraco2.setText(medidas.getAntebraco2());
            txtantebraco2.setInputType(InputType.TYPE_NULL);
            txtcoxa2.setText(medidas.getCoxa2());
            txtcoxa2.setInputType(InputType.TYPE_NULL);
            txtpanturilha2.setText(medidas.getPanturrilha2());
            txtpanturilha2.setInputType(InputType.TYPE_NULL);



        }
        fabEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VerMedidas.this, EditarMedidas1.class);
                intent.putExtra("ID", id);
                startActivity(intent);
            }
        });

        fabEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(VerMedidas.this);
                builder.setMessage("Deseja eliminar essas medidas?").setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (bdMedidas.eliminarMedidas(id)){
                            lista();
                        }
                    }
                }).setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).show();
            }
        });
    }
    private void lista(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}