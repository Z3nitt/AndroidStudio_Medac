package com.example.mantenimientoperiodontal;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {
EditText etSangrar, etAusdientes, etPerdidadientes, etDiabetes, etTabaco, etProfbolsa;
TextView tvColorSangrado, tvColorAusDiente, tvColorPerdDiente, tvColorDiabetes, tvColorTabaco, tvColorProfBolsa, tvResultado;
Button btnCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //DECLARACION EDITTEXT
        etSangrar = (EditText) findViewById(R.id.sangrado);
        etAusdientes = (EditText) findViewById(R.id.ausdientes);
        etPerdidadientes = (EditText) findViewById(R.id.perdidadientes);
        etDiabetes = (EditText) findViewById(R.id.diabetes);
        etTabaco = (EditText) findViewById(R.id.tabaco);
        etProfbolsa = (EditText) findViewById(R.id.profbolsa);

        //DECLARACION TEXTVIEW
        tvColorSangrado = (TextView) findViewById(R.id.tvColorSangrado);
        tvColorAusDiente = (TextView) findViewById(R.id.tvColorAusDiente);
        tvColorPerdDiente = (TextView) findViewById(R.id.tvColorPerdDiente);
        tvColorDiabetes = (TextView) findViewById(R.id.tvColorDiabetes);
        tvColorTabaco = (TextView) findViewById(R.id.tvColorTabaco);
        tvColorProfBolsa = (TextView) findViewById(R.id.tvColorProfBolsa);
        tvResultado = (TextView) findViewById(R.id.resultado);

        //Boton
        btnCalc = (Button) findViewById(R.id.Calcular);




        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Cambiar de String a numero para poder comparar
                //Sangrado
                String InputSangrado = etSangrar.getText().toString();
                int NumSangrado = Integer.parseInt(InputSangrado);

                //Ausencia de dientes
                String InputAusDiente = etAusdientes.getText().toString();
                int NumAusDiente = Integer.parseInt(InputAusDiente);

                //Perdida de dientes
                String InputPerdidaDientes = etPerdidadientes.getText().toString();
                int NumPerdidaDientes = Integer.parseInt(InputPerdidaDientes);

                //Diabetes
                String InputDiabetes = etDiabetes.getText().toString();


                //Tabaco
                String InputTabaco = etTabaco.getText().toString();


                //Profundidad de bolsa
                String InputProfBolsa = etProfbolsa.getText().toString();
                int NumProfBolsa = Integer.parseInt(InputProfBolsa);

                //Cambio de color y texto segun numero

                if(NumSangrado==0){
                    tvColorSangrado.setText("Sin Riesgo");
                    tvColorSangrado.setBackgroundResource(R.color.noRiesgo);
                } else if (NumSangrado<=3 && NumSangrado!=0) {
                    tvColorSangrado.setText("Riesgo Bajo");
                    tvColorSangrado.setBackgroundResource(R.color.riesgoBajo);
                } else if (NumSangrado>3 && NumSangrado<=8) {
                    tvColorSangrado.setText("Riesgo Moderado");
                    tvColorSangrado.setBackgroundResource(R.color.riesgoMedio);
                } else if (NumSangrado>=8) {
                    tvColorSangrado.setText("Riesgo Alto");
                    tvColorSangrado.setBackgroundResource(R.color.riesgoAlto);
                } else if (InputSangrado.isEmpty()) {
                    tvColorSangrado.setText("Riesgo Bajo");
                    tvColorSangrado.setBackgroundResource(R.color.riesgoBajo);
                }

                if(NumAusDiente==0){
                    tvColorAusDiente.setText("Sin Riesgo");
                    tvColorAusDiente.setBackgroundResource(R.color.noRiesgo);
                } else if (NumAusDiente<=3 && NumAusDiente!=0) {
                    tvColorAusDiente.setText("Riesgo Bajo");
                    tvColorAusDiente.setBackgroundResource(R.color.riesgoBajo);
                } else if (NumAusDiente>3 && NumAusDiente<=8) {
                    tvColorAusDiente.setText("Riesgo Moderado");
                    tvColorAusDiente.setBackgroundResource(R.color.riesgoMedio);
                } else if (NumAusDiente>=8) {
                    tvColorAusDiente.setText("Riesgo Alto");
                    tvColorAusDiente.setBackgroundResource(R.color.riesgoAlto);
                } else if (InputAusDiente.isEmpty()) {
                    tvColorAusDiente.setText("Riesgo Bajo");
                    tvColorAusDiente.setBackgroundResource(R.color.riesgoBajo);
                }

                if(NumPerdidaDientes==0){
                    tvColorPerdDiente.setText("Sin Riesgo");
                    tvColorPerdDiente.setBackgroundResource(R.color.noRiesgo);
                } else if (NumPerdidaDientes<=3 && NumPerdidaDientes!=0) {
                    tvColorPerdDiente.setText("Riesgo Bajo");
                    tvColorPerdDiente.setBackgroundResource(R.color.riesgoBajo);
                } else if (NumPerdidaDientes>3 && NumPerdidaDientes<=8) {
                    tvColorPerdDiente.setText("Riesgo Moderado");
                    tvColorPerdDiente.setBackgroundResource(R.color.riesgoMedio);
                } else if (NumPerdidaDientes>=8) {
                    tvColorPerdDiente.setText("Riesgo Alto");
                    tvColorPerdDiente.setBackgroundResource(R.color.riesgoAlto);
                } else if (InputPerdidaDientes.isEmpty()) {
                    tvColorPerdDiente.setText("Riesgo Bajo");
                    tvColorPerdDiente.setBackgroundResource(R.color.riesgoBajo);
                }

                if(InputDiabetes.equals("Si") || InputDiabetes.equals("si")){
                    tvColorDiabetes.setText("Riesgo Alto");
                    tvColorDiabetes.setBackgroundResource(R.color.riesgoAlto);
                }
                else{
                    tvColorDiabetes.setText("Sin Riesgo");
                    tvColorDiabetes.setBackgroundResource(R.color.noRiesgo);
                }

                if(InputTabaco.equals("Si") || InputTabaco.equals("si")){
                    tvColorTabaco.setText("Riesgo Alto");
                    tvColorTabaco.setBackgroundResource(R.color.riesgoAlto);
                }
                else{
                    tvColorTabaco.setText("Sin Riesgo");
                    tvColorTabaco.setBackgroundResource(R.color.noRiesgo);
                }

                if(NumProfBolsa==0){
                    tvColorProfBolsa.setText("Sin Riesgo");
                    tvColorProfBolsa.setBackgroundResource(R.color.noRiesgo);
                } else if (NumProfBolsa<=3 && NumProfBolsa!=0) {
                    tvColorProfBolsa.setText("Riesgo Bajo");
                    tvColorProfBolsa.setBackgroundResource(R.color.riesgoBajo);
                } else if (NumProfBolsa>3 && NumProfBolsa<=8) {
                    tvColorProfBolsa.setText("Riesgo Moderado");
                    tvColorProfBolsa.setBackgroundResource(R.color.riesgoMedio);
                } else if (NumProfBolsa>=8) {
                    tvColorProfBolsa.setText("Riesgo Alto");
                    tvColorProfBolsa.setBackgroundResource(R.color.riesgoAlto);
                } else if (InputProfBolsa.isEmpty()) {
                    tvColorProfBolsa.setText("Riesgo Bajo");
                    tvColorProfBolsa.setBackgroundResource(R.color.riesgoBajo);
                }

                if(NumSangrado==0 && NumPerdidaDientes==0 && NumAusDiente==0 && NumProfBolsa==0){
                    tvResultado.setText("Riesgo Bajo");
                    tvResultado.setBackgroundResource(R.color.riesgoBajo);
                } else if (NumSangrado<=2 && NumPerdidaDientes<=2 && NumAusDiente<=2 && NumProfBolsa<=2 && NumSangrado!=0 && NumPerdidaDientes!=0 && NumAusDiente!=0 && NumProfBolsa!=0) {
                    tvResultado.setText("Riesgo Moderado");
                    tvResultado.setBackgroundResource(R.color.riesgoMedio);
                } else if (NumSangrado<=4 && NumPerdidaDientes<=4 && NumAusDiente<=4 && NumProfBolsa<=4 && NumSangrado!=0 && NumPerdidaDientes!=0 && NumAusDiente!=0 && NumProfBolsa!=0) {
                    tvResultado.setText("Riesgo Alto");
                    tvResultado.setBackgroundResource(R.color.riesgoAlto);
                }

            }
        });
    }
}