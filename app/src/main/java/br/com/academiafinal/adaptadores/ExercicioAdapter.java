package br.com.academiafinal.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import br.com.academiafinal.R;
import br.com.academiafinal.entidades.ExercicioModal;

public class ExercicioAdapter extends RecyclerView.Adapter<ExercicioAdapter.ExercicioViewHolder> {

        Context context;
        ArrayList<ExercicioModal> arrayListexercicioModal;
public ExercicioAdapter(Context context, ArrayList<ExercicioModal> arrayListexercicioModal) {
        this.context = context;
        this.arrayListexercicioModal = arrayListexercicioModal;
        }



@NonNull
@Override
public ExercicioAdapter.ExercicioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.exercicios_item, parent, false);


        return new ExercicioViewHolder(view);
        }

@Override
public void onBindViewHolder(@NonNull ExercicioAdapter.ExercicioViewHolder holder, int position) {

        ExercicioModal exercicioModal = arrayListexercicioModal.get(position);
        holder.txtNomeExercicio.setText(exercicioModal.getNomeExercicio());
        holder.imgExercicio.setImageResource(exercicioModal.getImage());
        }

@Override
public int getItemCount() {
        return arrayListexercicioModal.size();
        }

public class ExercicioViewHolder extends RecyclerView.ViewHolder {

    TextView txtNomeExercicio;
    ImageView imgExercicio;

    public ExercicioViewHolder(@NonNull View itemView) {
        super(itemView);
        txtNomeExercicio = itemView.findViewById(R.id.nomeExercicio);
        imgExercicio = itemView.findViewById(R.id.imageExercicio);

    }
}
}
