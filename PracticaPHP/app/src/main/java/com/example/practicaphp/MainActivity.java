package com.example.practicaphp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RequestQueue queue;
    private RecyclerView recyclerView;
    private PersonajeAdapter adaptadorPersonaje;
    private ArrayList<Personaje> personajes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar RecyclerView y Adapter
        recyclerView = findViewById(R.id.recycler);
        personajes = new ArrayList<>();


        // Obtener datos y llenar el RecyclerView
        obtenerDatos(personajes);
        adaptadorPersonaje = new PersonajeAdapter(personajes);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptadorPersonaje);
    }

    private void obtenerDatos(ArrayList<Personaje> personajes) {
        queue = Volley.newRequestQueue(this);
        String url = "http://10.0.2.2:8081/dragonball/obtenerTodosPersonajes.php";

        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {

                            JSONArray datospersonajes = response.getJSONObject(0).getJSONArray("mensaje");
                            Log.d("JSON Response", response.toString());
                            for (int i = 0; i < datospersonajes.length(); i++) {
                                JSONObject per = datospersonajes.getJSONObject(i);
                                String nombre = per.getString("Nombre");
                                int poder = per.getInt("Poder");
                                String descripcion = per.getString("Descripcion");
                                String universo = per.getString("Universo");
                                Personaje personaje = new Personaje(nombre, poder, descripcion, universo);
                                personajes.add(personaje);

                            }
                            // Notificar al Adapter que los datos han cambiado
                            adaptadorPersonaje.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println(error.toString());
                    }
                });

        queue.add(jsonObjectRequest);
    }
}