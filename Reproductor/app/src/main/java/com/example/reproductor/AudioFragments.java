package com.example.reproductor;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AudioFragments# newInstance} factory method to
 * create an instance of this fragment.
 */
public class AudioFragments extends Fragment {
    // Variables
    Spinner selector;
    MediaPlayer audio;
    ImageButton btnAtras, btnPausa, btnPlay, btnSaltar, btnFav;
    SeekBar sbBarraReprod;
    boolean pausa = false;
    int cancionactual = 0;
    int[] songList = {R.raw.ironmaiden, R.raw.batman, R.raw.dragonball, R.raw.knockin, R.raw.extremoduro};
    String[] nombreCancion = {"The Trooper - IronMaiden", "Batman - Opening", "Dragon Ball - Opening", "Knocking on heavens door - Guns n Roses", "La vereda de la puerta de atrás - Extremoduro"};
    TextView tvReproductorMusica,tvTiempoTranscurrido,tvTiempoTotal;
    ArrayList<String> favoritos = new ArrayList<>();
    Handler handler = new Handler();

    public ArrayList<String> getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(ArrayList<String> favoritos) {
        this.favoritos = favoritos;

    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_audio_fragments, container, false);
        // Inicialización de vistas
        selector = view.findViewById(R.id.selector);
        btnAtras = view.findViewById(R.id.btnRewind);
        btnPausa = view.findViewById(R.id.btnPause);
        btnPlay = view.findViewById(R.id.btnPlay);
        btnSaltar = view.findViewById(R.id.btnForward);
        btnFav = view.findViewById(R.id.btnFav);
        tvReproductorMusica = view.findViewById(R.id.tvReproductorMusica);
        tvTiempoTranscurrido = view.findViewById(R.id.tvTiempoTranscurrido);
        tvTiempoTotal = view.findViewById(R.id.tvTiempoTotal);
        sbBarraReprod = view.findViewById(R.id.sbBarraReprod);

        sbBarraReprod.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progreso, boolean fromUser) {
                if (fromUser && audio !=null){
                    audio.seekTo(progreso);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        // Configurar el Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                requireContext(), R.array.array_musica, android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selector.setAdapter(adapter);

        // Listener del Spinner
        selector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                cancionactual = pos;
                reproducirCancion(cancionactual);
                tvReproductorMusica.setText(nombreCancion[cancionactual]);
                actualizarBotonFavorito(btnFav);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        // Listener del botón de Favoritos
        btnFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cancionFav = nombreCancion[cancionactual];

                if (!favoritos.contains(cancionFav)) {
                    favoritos.add(cancionFav);
                    Toast.makeText(requireContext(), R.string.AnadidoFav, Toast.LENGTH_SHORT).show();
                    btnFav.setImageResource(R.drawable.favoritoanadido); // Cambiar icono
                    btnFav.setBackgroundColor(getActivity().getResources().getColor(R.color.azul)); // Cambiar color
                } else {
                    favoritos.remove(cancionFav);
                    Toast.makeText(requireContext(), R.string.EliminadoFav, Toast.LENGTH_SHORT).show();
                    btnFav.setImageResource(R.drawable.iconofav); // Cambiar icono de favorito
                    btnFav.setBackgroundColor(getActivity().getResources().getColor(R.color.white)); // Cambiar color
                }

                // Asegúrate de que los cambios se reflejen en MainActivity
                ((MainActivity) getActivity()).setListaFavoritos(favoritos);
            }
        });
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cancionactual > 0) {
                    cancionactual--;
                } else {
                    cancionactual = songList.length - 1;
                }
                reproducirCancion(cancionactual);
                tvReproductorMusica.setText(nombreCancion[cancionactual]);  // Actualiza el nombre de la canción en el TextView
                actualizarBotonFavorito(btnFav);  // Actualiza el icono de favoritos
            }
        });
        btnSaltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cancionactual < songList.length - 1) {
                    cancionactual++;
                } else {
                    cancionactual = 0;
                }
                reproducirCancion(cancionactual);
                tvReproductorMusica.setText(nombreCancion[cancionactual]);  // Actualiza el nombre de la canción en el TextView
                actualizarBotonFavorito(btnFav);  // Actualiza el icono de favoritos
            }
        });
        btnPausa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (audio != null && audio.isPlaying()) {
                    audio.pause(); // Pausa la música
                    pausa = true;
                }
            }
        });
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (audio != null && pausa) {
                    audio.start(); // Reanuda la música
                    pausa = false;
                }
            }
        });



        // Más listeners para los botones de control de audio...
        return view;
    }

    private void reproducirCancion(int indice) {
        // Si ya hay un audio reproduciéndose, lo detenemos y liberamos
        if (audio != null) {
            audio.stop();
            audio.release();
            audio = null;
        }

        // Crear el MediaPlayer con la canción seleccionada
        audio = MediaPlayer.create(requireContext(), songList[indice]);

        if (audio != null) {
            audio.start(); // Iniciar la reproducción de la nueva canción
            pausa = false; // Reiniciar el estado de pausa

            actualizarBarraProgreso();

            int duracion = audio.getDuration();
            tvTiempoTotal.setText(formatearTiempo(duracion));
            sbBarraReprod.setMax(duracion);
        }
    }

    private String formatearTiempo(int millis) {
        int minutos = (int) TimeUnit.MILLISECONDS.toMinutes(millis);
        int segundos = (int) (TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(minutos));
        return String.format("%d:%02d", minutos, segundos);
    }

    private void actualizarBarraProgreso() {
        if (audio != null) {
            sbBarraReprod.setProgress(audio.getCurrentPosition());
            tvTiempoTranscurrido.setText(formatearTiempo(audio.getCurrentPosition()));

            // Llamar este método periódicamente
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    actualizarBarraProgreso();
                }
            }, 1000); // Actualizar cada segundo
        }
    }





    public void actualizarBotonFavorito(ImageButton btnFav) {
        String cancionFav = nombreCancion[cancionactual];
        if (favoritos.contains(cancionFav)) {
            btnFav.setImageResource(R.drawable.favoritoanadido);
        } else {
            btnFav.setImageResource(R.drawable.iconofav);
        }
    }
}

