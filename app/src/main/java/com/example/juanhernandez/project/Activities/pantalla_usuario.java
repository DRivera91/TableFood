package com.example.juanhernandez.project.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.juanhernandez.project.R;

/**
 * Created by Juan Hernandez on 5/03/2018.
 */

public class pantalla_usuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_usuario);
        Button button2 = findViewById(R.id.pedido);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent pedido = new Intent(pantalla_usuario.this,lista_simple.class);
                startActivity(pedido);

            }
        });


    }
}
