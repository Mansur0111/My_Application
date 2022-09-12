package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
Button button1,button2;
EditText editText1,editText2;
ProgressDialog progressDialog;
FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button2=findViewById(R.id.buttonreg);
        button1=findViewById(R.id.buttonlogin);
        editText1=findViewById(R.id.edittext1);
        editText2=findViewById(R.id.edittext2);
progressDialog=new ProgressDialog(this);
progressDialog.setMessage("Kutasan");
firebaseAuth=FirebaseAuth.getInstance();

button1.setOnClickListener(view -> {
    progressDialog.show();
    firebaseAuth.signInWithEmailAndPassword(editText1.getText().toString(),editText2.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isSuccessful()){
                startActivity(new Intent(MainActivity.this,MainActivity3.class));
progressDialog.hide();
            }else {
                progressDialog.hide();
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        }
    });
});

        button2.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this,MainActivity2.class));
        });
    }
}