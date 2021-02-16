package com.example.mptsewa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private EditText Name, Password;
    private TextView Info, ForgotPassword;
    private Button Login;
    private int counter=5;
    private TextView userRegistration;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText) findViewById(R.id.etName);
        Password = (EditText) findViewById(R.id.etPass);
        Login = (Button) findViewById(R.id.btnLogin);
        Info = (TextView) findViewById(R.id.tvInfo);
        userRegistration = (TextView) findViewById(R.id.tvRegister);
        ForgotPassword = (TextView) findViewById(R.id.tvForgotPass);

        Info.setText("Bilangan Percubaan: 5");

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        FirebaseUser user = firebaseAuth.getCurrentUser();

        if(user != null){
            finish();
            startActivity(new Intent(MainActivity.this, SecondActivity.class));
        }

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });

        userRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegistrationActivity.class));
            }
        });

        ForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ForgotPassword.class));
            }
        });

    }
    private void validate (String userName, String userPassword){

        progressDialog.setMessage("Anda Akan Log Masuk Selepas /nPengesahan Emel");
        progressDialog.show();

      firebaseAuth.signInWithEmailAndPassword(userName, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
          public void onComplete(@NonNull Task<AuthResult> task) {
              if(task.isSuccessful()){
                  progressDialog.dismiss();
                  //Toast.makeText(MainActivity.this,"Login Successful", Toast.LENGTH_SHORT).show();
                  checkEmailVerification();
              }else{
                  Toast.makeText(MainActivity.this,"Login Failed", Toast.LENGTH_SHORT).show();
                  counter--;
                  Info.setText("Bilangan Percubaan: " + counter) ;
                  progressDialog.dismiss();
                  if(counter == 0){
                      Login.setEnabled(false);
                  }
              }
          }
      });
    }
    private void checkEmailVerification(){
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        Boolean emailflag = firebaseUser.isEmailVerified();

        startActivity(new Intent(MainActivity.this, SecondActivity.class));

       /* if(emailflag){
            finish();
            startActivity(new Intent(MainActivity.this ,SecondActivity.class));
        }else{
            Toast.makeText(this, "Verify your email", Toast.LENGTH_SHORT).show();
            firebaseAuth.signOut();
        }*/
    }
}