package com.example.ejemplorecycleview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonajeAdapter extends RecyclerView.Adapter<PersonajeAdapter.PersonajeViewHolder> {

    private final Context context;
    private final ArrayList<Personaje> personajes;

    public PersonajeAdapter(Context context, ArrayList<Personaje> personajes) {
        this.context = context;
        this.personajes = personajes;
    }

    @NonNull
    @Override
    public PersonajeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_personaje, parent, false);
        return new PersonajeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonajeViewHolder holder, int position) {
        Personaje personaje = personajes.get(position);
        holder.nombre.setText(personaje.getNombre());
        holder.descripcion.setText(personaje.getDesc());
        holder.imagen.setImageResource(personaje.getImagenID());

        // Abrir la actividad de detalle al hacer clic
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, PersonajeClick.class);
            intent.putExtra("nombre", personaje.getNombre());
            intent.putExtra("imagenID", personaje.getImagenID());
            intent.putExtra("descripcionExtendida", personaje.getDescripcionExtendida());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return personajes.size();
    }

    public static class PersonajeViewHolder extends RecyclerView.ViewHolder {
        TextView nombre, descripcion;
        ImageView imagen;

        public PersonajeViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombrePersonaje);
            descripcion = itemView.findViewById(R.id.descPersonaje);
            imagen = itemView.findViewById(R.id.imagenPersonaje);
        }
    }
}
