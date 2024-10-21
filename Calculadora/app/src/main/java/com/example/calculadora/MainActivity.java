package com.example.calculadora;

import android.os.Bundle;
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
Button btn_sumar;
Button btn_restar;
Button btn_multiplicar;
Button btn_dividir;
Button btn_limpiar;

EditText et1;
EditText et2;

TextView tvres;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_sumar = (Button) findViewById(R.id.sumar);
        btn_restar = (Button) findViewById(R.id.restar);
        btn_dividir = (Button) findViewById(R.id.dividir);
        btn_multiplicar = (Button) findViewById(R.id.multiplicar);
        btn_limpiar = (Button) findViewById(R.id.limpiar);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        tvres = (TextView) findViewById(R.id.resultado);

        btn_sumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String InputNum = et1.getText().toString();
                float ValorInt = Float.parseFloat(InputNum);
                String InputNum2 = et2.getText().toString();
                float ValorInt2 = Float.parseFloat(InputNum2);
                tvres.setText(String.valueOf(ValorInt+ValorInt2));
            }
        });

        btn_restar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String InputNum = et1.getText().toString();
                float ValorInt = Float.parseFloat(InputNum);
                String InputNum2 = et2.getText().toString();
                float ValorInt2 = Float.parseFloat(InputNum2);
                tvres.setText(String.valueOf(ValorInt-ValorInt2));
            }
        });

        btn_multiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String InputNum = et1.getText().toString();
                float ValorInt = Float.parseFloat(InputNum);
                String InputNum2 = et2.getText().toString();
                float ValorInt2 = Float.parseFloat(InputNum2);
                tvres.setText(String.valueOf(ValorInt*ValorInt2));
            }
        });

        btn_dividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String InputNum = et1.getText().toString();
                float ValorInt = Float.parseFloat(InputNum);
                String InputNum2 = et2.getText().toString();
                float ValorInt2 = Float.parseFloat(InputNum2);
                tvres.setText(String.valueOf(ValorInt/ValorInt2));
            }
        });

        btn_limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et1.setText(null);
                et2.setText(null);
                tvres.setText("Resultado");
            }
        });

    }
}