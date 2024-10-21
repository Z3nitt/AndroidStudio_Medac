package com.example.tablelayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
Button btn1;
TextView c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c1 = (TextView) findViewById(R.id.casilla1);
        c2 = (TextView) findViewById(R.id.casilla2);
        c3 = (TextView) findViewById(R.id.casilla3);
        c4 = (TextView) findViewById(R.id.casilla4);
        c5 = (TextView) findViewById(R.id.casilla5);
        c6 = (TextView) findViewById(R.id.casilla6);
        c7 = (TextView) findViewById(R.id.casilla7);
        c8 = (TextView) findViewById(R.id.casilla8);
        c9 = (TextView) findViewById(R.id.casilla9);
        c10 = (TextView) findViewById(R.id.casilla10);
        resultado = (TextView) findViewById(R.id.resultado);


        String num1 = c1.getText().toString();
        String num2 = c2.getText().toString();
        String num3 = c3.getText().toString();
        String num4 = c4.getText().toString();
        String num5 = c5.getText().toString();
        String num6 = c6.getText().toString();
        String num7 = c7.getText().toString();
        String num8 = c8.getText().toString();
        String num9 = c9.getText().toString();
        String num10 = c10.getText().toString();

        int valorint= Integer.parseInt(num1);
        int valorint2= Integer.parseInt(num2);
        int valorint3= Integer.parseInt(num2);
        int valorint4= Integer.parseInt(num2);
        int valorint5= Integer.parseInt(num2);
        int valorint6= Integer.parseInt(num2);
        int valorint7= Integer.parseInt(num2);
        int valorint8= Integer.parseInt(num2);
        int valorint9= Integer.parseInt(num2);
        int valorint10= Integer.parseInt(num2);

        resultado.setText(String.valueOf(valorint+valorint2+valorint3+valorint4+valorint5+valorint6+valorint7+valorint8+valorint9+valorint10));



    }
}