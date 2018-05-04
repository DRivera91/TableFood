package com.example.juanhernandez.project;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.juanhernandez.project.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SignUp extends AppCompatActivity {

    MaterialEditText edtPhone, edtEmail, edtPassword;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edtPhone=(MaterialEditText)findViewById(R.id.edtPhone);
        edtEmail=(MaterialEditText)findViewById(R.id.edtEmail);
        edtPassword=(MaterialEditText)findViewById(R.id.edtPassword);

        btnSignUp = (Button)findViewById(R.id.btnsignUp);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog mDialog = new ProgressDialog(SignUp.this);
                mDialog.setMessage(getString(R.string.waiting));
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //verificamos que el usuario exista en la BD
                        if(dataSnapshot.child(edtPhone.getText().toString()).exists()) {
                            mDialog.dismiss();
                            Toast.makeText(SignUp.this, R.string.Exist, Toast.LENGTH_SHORT).show();

                        }else{

                            //obtenemos la informacion del usuario
                            mDialog.dismiss();
                            User user=new User(edtEmail.getText().toString(),edtPassword.getText().toString());
                            table_user.child(edtPhone.getText().toString()).setValue(user);
                            Toast.makeText(SignUp.this, R.string.Supsucessfully, Toast.LENGTH_SHORT).show();
                            finish();

                            /*
                            User user = dataSnapshot.child(edtPhone.getText().toString()).getValue(User.class);
                            if (user.getPassword().equals(edtPassword.getText().toString())) {
                                Toast.makeText(SignUp.this, R.string.sucessfully, Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(SignUp.this, R.string.failed, Toast.LENGTH_SHORT).show();
                            }*/

                        }


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


            }
        });

    }
}
