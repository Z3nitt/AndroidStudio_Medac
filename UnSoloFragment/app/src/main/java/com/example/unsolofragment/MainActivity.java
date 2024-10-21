package com.example.unsolofragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener;

public class MainActivity extends AppCompatActivity {
private Button btn1;
private TabLayout tl;
private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.btn1);
        tl = (TabLayout) findViewById(R.id.tablayout);
        tv1 = (TextView) findViewById(R.id.tv1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Inizializo el fragment a null
                Fragment fragment = null;
                //Creo la clase fragment
                fragment = new BlankFragment();
                //Llama al fragment para que aparezca depende de la id
                getSupportFragmentManager().beginTransaction().add(R.id.main, fragment).commit();
            }
        });
        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
            @Override
            public void onTabSelected(TabLayout.Tab tab){
                if (tab.getPosition()==0){
                    tv1.setVisibility(View.INVISIBLE);
                } else if(tab.getPosition()==1){
                    tv1.setVisibility(View.VISIBLE);
                } else if(tab.getPosition()==2){
                    tv1.setVisibility(View.INVISIBLE);
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
    }
