package com.example.juanhernandez.project.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.juanhernandez.project.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.Button_Ingreso);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = ((EditText) findViewById(R.id.Name_User)).getText().toString();
                String password = ((EditText) findViewById(R.id.Password)).getText().toString();
                if (usuario.equals("Admin") && password.equals("12345"))
                {
                    Intent pantalla_usuario = new Intent(MainActivity.this,pantalla_usuario.class);
                    startActivity(pantalla_usuario);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Usuario Incorrecto", Toast.LENGTH_LONG).show();
                }
            }
        });

        Button button1 = (Button) findViewById(R.id.Registro);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Registro = new Intent(MainActivity.this,pantalla_registro.class);
                startActivity(Registro);

            }
        });


    }
}
