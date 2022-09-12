package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity2 extends AppCompatActivity {
EditText editText1;
EditText editText2;
Button button;
ProgressBar progressBar;

FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button=findViewById(R.id.buttonregister);
        editText1=findViewById(R.id.edittextemail);
        editText2=findViewById(R.id.edittextpassword);
firebaseAuth=FirebaseAuth.getInstance();

button.setOnClickListener(view -> {
    progressBar.setVisibility(View.VISIBLE);
   firebaseAuth.createUserWithEmailAndPassword(editText1.getText().toString(),editText2.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
if (task.isComplete()){
    Toast.makeText(MainActivity2.this, "Bazada saqlandi", Toast.LENGTH_SHORT).show();
    progressBar.setVisibility(View.GONE);
}
        }
    });
});


    }
}