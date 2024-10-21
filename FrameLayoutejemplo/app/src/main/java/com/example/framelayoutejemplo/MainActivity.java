package com.example.framelayoutejemplo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
Button btn;
ImageView iv,iv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn1);
        iv = (ImageView) findViewById(R.id.iv1);
        iv2 = (ImageView) findViewById(R.id.iv2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iv.getVisibility()==View.VISIBLE){
                    iv.setVisibility(View.INVISIBLE);
                    iv2.setVisibility(View.VISIBLE);
                }
                else{
                    iv.setVisibility(View.VISIBLE);
                    iv2.setVisibility(View.INVISIBLE);

                }
            }
        });

    }
}