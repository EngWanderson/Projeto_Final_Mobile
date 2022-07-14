package br.com.academiafinal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.academiafinal.bd.BdMedidas;
import br.com.academiafinal.entidades.Medidas;

public class EditarMedidas1 extends AppCompatActivity {


    EditText txtNome, txtPescoco, txtOmbro, txtPeitoral, txtabdome, txtcintura, txtquadril, txtbiceps, txtantebraco, txtcoxa, txtpanturilha,txtbiceps2, txtantebraco2, txtcoxa2, txtpanturilha2;

    Button fabEliminar;
    Button btnGuardar;
    boolean correto=false;
    Medidas medidas;

    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_medidas1);

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


        fabEliminar = findViewById(R.id.fabEliminar);
        btnGuardar = findViewById(R.id.salvarMedidas);


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

        final BdMedidas bdMedidas = new BdMedidas(EditarMedidas1.this);
        medidas = bdMedidas.verMedidas(id);

        if (medidas!= null){
            txtNome.setText(medidas.getNome());
            txtPescoco.setText(medidas.getPescoco());
            txtOmbro.setText(medidas.getOmbro());
            txtPeitoral.setText(medidas.getPeitoral());
            txtabdome.setText(medidas.getAbdome());
            txtcintura.setText(medidas.getCintura());
            txtquadril.setText(medidas.getCintura());

            txtbiceps.setText(medidas.getBiceps());
            txtantebraco.setText(medidas.getAntebraco());
            txtcoxa.setText(medidas.getCoxa());
            txtpanturilha.setText(medidas.getPanturrilha());


            txtbiceps2.setText(medidas.getBiceps2());
            txtantebraco2.setText(medidas.getAntebraco2());
            txtcoxa2.setText(medidas.getCoxa2());
            txtpanturilha2.setText(medidas.getPanturrilha2());





        }
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //campos obrigratórios
                if (!txtNome.getText().toString().equals("") && !txtPescoco.getText().toString().equals("")) {
                    correto = bdMedidas.editarMedidas(id, txtNome.getText().toString(), txtPescoco.getText().toString(), txtOmbro.getText().toString(), txtPeitoral.getText().toString(), txtabdome.getText().toString(), txtcintura.getText().toString(), txtquadril.getText().toString(), txtbiceps.getText().toString(), txtantebraco.getText().toString(),
                            txtcoxa.getText().toString(), txtpanturilha.getText().toString(), txtbiceps2.getText().toString(), txtantebraco2.getText().toString(), txtcoxa2.getText().toString(), txtpanturilha2.getText().toString());
                    if (correto) {
                        Toast.makeText(EditarMedidas1.this, "REGISTRO MODIFICADO", Toast.LENGTH_LONG).show();
                        //verRegistro();
                        voltarTelaInicial();

                    } else {
                        Toast.makeText(EditarMedidas1.this, "ERROR AL MODIFICAR REGISTRO", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(EditarMedidas1.this, "DEBE LLENAR LOS CAMPOS OBLIGATORIOS", Toast.LENGTH_LONG).show();
                }
            }


        });
        fabEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(EditarMedidas1.this);
                builder.setMessage("Deseja eliminar essas medidas?").setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (bdMedidas.eliminarMedidas(id)){

                            voltarTelaInicial();
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
    private void verRegistro(){
        Intent intent = new Intent(this, VerMedidas.class);
        intent.putExtra("ID", id);
        startActivity(intent);
    }

    private void voltarTelaInicial(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}