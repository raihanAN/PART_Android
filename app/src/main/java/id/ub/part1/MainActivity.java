package id.ub.part1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView daftarnih;
    private EditText loginemail;
    private EditText passwordlog;
    private Button logbutton;
    private FirebaseAuth mAuth;
    private Button googleSign;
    private Button Adminlog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//LOGIN
        mAuth=FirebaseAuth.getInstance();
        logbutton = (Button) findViewById(R.id.buttonlog);
        logbutton.setOnClickListener(this);
        loginemail = (EditText) findViewById(R.id.editTextTextEmailAddress);
        passwordlog = (EditText) findViewById(R.id.passlog);
        Adminlog = (Button) findViewById(R.id.adlog);
        Adminlog.setOnClickListener(this);
//Login google
        googleSign=(Button) findViewById(R.id.googlelog);
        googleSign.setOnClickListener(this);


//        Sign Up
        daftarnih = (TextView) findViewById(R.id.daftar);
        daftarnih.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.daftar:
                Intent intent =new Intent(this, daftar.class);
                startActivity(intent);
                break;
            case R.id.buttonlog:
                login();
                break;
            case R.id.googlelog:
                SignGoogle();
                break;
            case R.id.adlog:
                AdminPage();
                break;
    }

    }

    private void AdminPage() {
        Intent intent2 =new Intent(this, Adminlog.class);
        startActivity(intent2);
    }

    private void SignGoogle() {
        Intent intent =new Intent(this, GoogleLog.class);
        startActivity(intent);
    }

    private void login() {
        String emailog=loginemail.getText().toString().trim();
        String passlog=passwordlog.getText().toString().trim();

        if (emailog.isEmpty()){
            loginemail.setError("Email Is Required");
            loginemail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(emailog).matches()){
            loginemail.setError("Please Provide Valid Email");
            loginemail.requestFocus();
            return;
        }
        if (passlog.isEmpty()){
            passwordlog.setError("Password Is Required");
            passwordlog.requestFocus();
            return;
        }
        mAuth.signInWithEmailAndPassword(emailog,passlog).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Intent in =new Intent(MainActivity.this, Home2.class);
                    startActivity(in);
                }else{
                    Toast.makeText(MainActivity.this, "Login Gagal", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}