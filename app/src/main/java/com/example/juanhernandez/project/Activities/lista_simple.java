package com.example.juanhernandez.project.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.juanhernandez.project.R;

/**
 * Created by Juan Hernandez on 9/03/2018.
 */

public class lista_simple extends AppCompatActivity {

    ListView lista_restaurantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.elemento_lista);

        lista_restaurantes = findViewById(R.id.lv_01);
        String [] tiendas = new String[] {"Qbano","Corral","Kokoriko","Crepes","Frisby","JuanValdez"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        lista_restaurantes.setAdapter(adapter);
        lista_restaurantes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    Intent one = new Intent(view.getContext(),MainActivity.class);
                    startActivityForResult(one, 0);
                }
            }
        });
    }
}
