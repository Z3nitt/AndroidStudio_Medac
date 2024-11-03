package com.example.ejemplolistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PersonajeAdapter extends ArrayAdapter<Personaje> {

    public PersonajeAdapter(Context context, ArrayList<Personaje> personajes) {
        super(context, 0, personajes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtener el personaje actual
        Personaje personaje = getItem(position);

        // Inflar el layout si es necesario
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.personaje, parent, false);
        }

        // Referencias a las vistas del layout
        ImageView imageView = convertView.findViewById(R.id.item_image);
        TextView nameView = convertView.findViewById(R.id.item_name);
        TextView descView = convertView.findViewById(R.id.item_desc);

        // Asignar la imagen, nombre y descripción
        imageView.setImageResource(personaje.getImagenID());
        nameView.setText(personaje.getNombre());
        descView.setText(personaje.getDesc());

        return convertView;
    }
}
