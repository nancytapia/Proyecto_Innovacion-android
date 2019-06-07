package com.money.keepsafe.keepsafemoney;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PersonajesAdapter extends RecyclerView.Adapter<PersonajesAdapter.PersonajeViewHolder> {

    ArrayList<PersonajeVo> listapersonaje;

    public PersonajesAdapter(ArrayList<PersonajeVo> listapersonaje) {
        this.listapersonaje = listapersonaje;
    }

    @NonNull
    @Override
    public PersonajeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);
        return new PersonajeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonajeViewHolder holder, int position) {

        holder.txtNombre.setText(listapersonaje.get(position).getNombre());
        holder.txtInformacion.setText(listapersonaje.get(position).getInfo());
        holder.foto.setImageResource(listapersonaje.get(position).getImageId());

    }

    @Override
    public int getItemCount() {

        return listapersonaje.size();
    }

    public class PersonajeViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombre,txtInformacion;
        ImageView foto;
        public PersonajeViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNombre= (TextView) itemView.findViewById(R.id.idNombre);
            txtInformacion= (TextView) itemView.findViewById(R.id.idInfo);
            foto= (ImageView) itemView.findViewById(R.id.idImagen);
        }
    }
}
