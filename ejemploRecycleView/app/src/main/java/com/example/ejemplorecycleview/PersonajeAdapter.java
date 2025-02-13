package com.example.ejemplorecycleview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
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
        holder.cardView.setAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.animation1));

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
        private CardView cardView;

        public PersonajeViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombrePersonaje);
            nombre.setTextColor(Color.BLACK);
            descripcion = itemView.findViewById(R.id.descPersonaje);
            descripcion.setTextColor(Color.BLACK);
            imagen = itemView.findViewById(R.id.imagenPersonaje);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
