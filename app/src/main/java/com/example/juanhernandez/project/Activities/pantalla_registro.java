package com.example.juanhernandez.project.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.juanhernandez.project.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Juan Hernandez on 5/03/2018.
 */

public class pantalla_registro extends AppCompatActivity {

    EditText nombre, email, password, confirm;
    Button regist;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_registro);
        {

            email=(EditText)findViewById(R.id.txtemail);
            password=(EditText)findViewById(R.id.txtpassword);
            confirm=(EditText)findViewById(R.id.txtconfirm);

            regist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String userE =email.getText().toString();
                    String userP =password.getText().toString();
                    String userC =confirm.getText().toString();

                    if(TextUtils.isEmpty(userE)){

                    }
                    if(TextUtils.isEmpty(userP)){

                    }
                    if(TextUtils.isEmpty(userC)){

                    }
                    if(TextUtils.equals(userC,userP)){

                    }
                    auth.createUserWithEmailAndPassword(userE,userP).addOnCompleteListener(pantalla_registro.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            Toast.makeText(getApplicationContext(),"Registro exitoso!!",Toast.LENGTH_SHORT).show();
                            if(!task.isSuccessful()){
                                Toast.makeText(getApplicationContext(),"Registro fallido", Toast.LENGTH_SHORT).show();
                                Intent intent =new Intent(pantalla_registro.this, MainActivity.class);
                                startActivity(intent);
                            }

                        }
                    });
                }
            });
        }
    }
}
