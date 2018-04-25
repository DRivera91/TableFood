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
    EditText mail, pass, forget;
    Button login, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mail =(EditText) findViewById(R.id.Name_User);
        pass =(EditText) findViewById(R.id.Password);
        login =(Button) findViewById(R.id.Button_Ingreso);
        register =(Button) findViewById(R.id.Registro);
        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this, recovery.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this, pantalla_registro.class);
                startActivity(intent);
            }
        });


    }
}
