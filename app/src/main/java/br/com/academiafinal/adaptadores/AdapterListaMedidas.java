package br.com.academiafinal.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import br.com.academiafinal.R;
import br.com.academiafinal.VerMedidas;
import br.com.academiafinal.entidades.Medidas;

public class AdapterListaMedidas extends RecyclerView.Adapter<AdapterListaMedidas.MedidasViewHolder> {

    ArrayList<Medidas> listaMedidas;

    public AdapterListaMedidas(ArrayList<Medidas> listaMedidas){
        this.listaMedidas=listaMedidas;
    }
    @NonNull
    @Override
    public MedidasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nova_medida_item, null, false);
       return new MedidasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MedidasViewHolder holder, int position) {
        holder.viewNome.setText(listaMedidas.get(position).getNome());
    }

    @Override
    public int getItemCount() {
        return listaMedidas.size();
    }

    public class MedidasViewHolder extends RecyclerView.ViewHolder {
        TextView viewNome;
        public MedidasViewHolder(@NonNull View itemView) {
            super(itemView);
            viewNome = itemView.findViewById(R.id.nome_item_lista);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, VerMedidas.class);
                    intent.putExtra("ID", listaMedidas.get(getAdapterPosition()).getId());
                    context.startActivity(intent);
                }
            });
        }
    }
}
