package com.example.reproductor;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private TabLayout tl_main;
private ImageView ivmain;

private ArrayList<String> listaFavoritos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tl_main = (TabLayout) findViewById(R.id.tabLayout);
        ivmain= (ImageView) findViewById(R.id.ivlogomain);


        tl_main.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                Fragment selectedFragment = null;

                if(tab.getPosition()==0){
                    selectedFragment = new fragment_main();
                    ivmain.setVisibility(View.INVISIBLE);

                } else if (tab.getPosition()==1) {
                    AudioFragments audioFragment = (AudioFragments) getSupportFragmentManager()
                            .findFragmentByTag("AUDIO_FRAGMENT_TAG");
                    if (audioFragment != null) {
                        listaFavoritos = audioFragment.getFavoritos(); // Obtener la lista de favoritos actualizada
                        audioFragment.actualizarBotonFavorito(audioFragment.btnFav);
                    }
                    selectedFragment = FragmentFav.newInstance(listaFavoritos);
                    ivmain.setVisibility(View.INVISIBLE);

                }else if (tab.getPosition()==2) {
                    selectedFragment = new fragment_video();
                    ivmain.setVisibility(View.INVISIBLE);

                }else if (tab.getPosition() == 3) {
                    selectedFragment = new AudioFragments();
                    ((AudioFragments) selectedFragment).setFavoritos(listaFavoritos);
                    ivmain.setVisibility(View.INVISIBLE);
                }

                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main_content, selectedFragment) // Solo afecta al FrameLayout
                            .commit();
                }


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    public void setListaFavoritos(ArrayList<String> favoritos) {
        this.listaFavoritos = favoritos;
    }

}