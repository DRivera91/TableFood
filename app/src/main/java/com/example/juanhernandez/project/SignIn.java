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
import com.rengwuxian.materialedittext.MaterialAutoCompleteTextView;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SignIn extends AppCompatActivity {

    MaterialEditText edtPhone, edtPassword;
    Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        edtPhone=(MaterialEditText)findViewById(R.id.edtPhone);
        edtPassword=(MaterialEditText)findViewById(R.id.edtPassword);
        btnSignIn = (Button)findViewById(R.id.btnsignIn);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog mDialog = new ProgressDialog(SignIn.this);
                mDialog.setMessage(getString(R.string.waiting));
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //verificamos que el usuario exista en la BD
                        if(dataSnapshot.child(edtPhone.getText().toString()).exists()) {
                            //obtenemos la informacion del usuario
                            mDialog.dismiss();
                            User user = dataSnapshot.child(edtPhone.getText().toString()).getValue(User.class);
                            if (user.getPassword().equals(edtPassword.getText().toString())) {
                                Toast.makeText(SignIn.this, R.string.sucessfully, Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(SignIn.this, R.string.failed, Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            mDialog.dismiss();
                            Toast.makeText(SignIn.this, R.string.nExist, Toast.LENGTH_SHORT).show();
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
