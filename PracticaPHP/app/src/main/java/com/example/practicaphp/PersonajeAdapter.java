package com.example.practicaphp;

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

import com.example.practicaphp.Personaje;
import com.example.practicaphp.R;

import java.util.ArrayList;

public class PersonajeAdapter extends RecyclerView.Adapter<PersonajeAdapter.PersonajeViewHolder> {


    private final ArrayList<Personaje> personajes;

    public PersonajeAdapter(ArrayList<Personaje> personajes) {

        this.personajes = personajes;
    }

    @NonNull
    @Override
    public PersonajeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_personaje, parent, false);

        return new PersonajeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonajeViewHolder holder, int position) {
        Personaje personaje = personajes.get(position);

        holder.nombre.setText(personaje.getNombre());
        holder.descripcion.setText(personaje.getDescripcion());
        holder.poder.setText(String.valueOf(personaje.getPoder()));
        holder.universo.setText(personaje.getUniverso());

        android.view.animation.Animation animation = AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.animation1);
        holder.itemView.startAnimation(animation);

    }

    @Override
    public int getItemCount() {
        return personajes.size();
    }

    public static class PersonajeViewHolder extends RecyclerView.ViewHolder {
        TextView nombre, descripcion, universo, poder;

        public PersonajeViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombrePersonaje);
            nombre.setTextColor(Color.BLACK);
            descripcion = itemView.findViewById(R.id.descPersonaje);
            descripcion.setTextColor(Color.BLACK);
            poder = itemView.findViewById(R.id.poderPersonaje);
            poder.setTextColor(Color.BLACK);
            universo = itemView.findViewById(R.id.universoPersonaje);
            universo.setTextColor(Color.BLACK);
        }
    }
}
