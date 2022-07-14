package br.com.academiafinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

import br.com.academiafinal.adaptadores.ExercicioAdapter;
import br.com.academiafinal.entidades.ExercicioModal;

public class Escolha_exercicio extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ExercicioModal> exercicioModalArrayList;
    ExercicioAdapter exercicioAdapter;
    String[] nomeExercicio;
    int[] imageResourceId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolha_exercicio);
        recyclerView = findViewById(R.id.recyclerviewExerc);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        exercicioModalArrayList = new ArrayList<ExercicioModal>();
        exercicioAdapter = new ExercicioAdapter(this, exercicioModalArrayList);
        recyclerView.setAdapter(exercicioAdapter);

        nomeExercicio = new String[]{
                "Barra T",
                "Puxador barra",
                "Rosca direta",
                "Triceps frances",
                "Supino Reto",
                "Leg Press",
                "Cadeira extensora",
                "Rosca direta",
                "Desenvolvimento",
        };
        imageResourceId = new int[]{
                R.drawable.barra_t,
                R.drawable.puxador_barra,
                R.drawable.rosca_direta,
                R.drawable.triceps_f,
                R.drawable.supino_reto,
                R.drawable.leg_press,
                R.drawable.cadeira_extensora,
                R.drawable.drop_set_rosca_direta,
                R.drawable.desenvolvimentohalteres,

        };
        getData();


    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menu_principal,menu);
        return true;


}
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menuNovo:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void getData() {
        for (int i=0; i<nomeExercicio.length;i++){
            ExercicioModal exercicioModal = new ExercicioModal(nomeExercicio[i], imageResourceId[i]);
            exercicioModalArrayList.add(exercicioModal);
        }
        exercicioAdapter.notifyDataSetChanged();
    }
}