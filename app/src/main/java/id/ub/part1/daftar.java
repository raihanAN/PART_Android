package id.ub.part1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class daftar extends AppCompatActivity implements View.OnClickListener{
    private TextView Banner;
    private EditText Fullname;
    private EditText Domisili;
    private EditText Age;
    private EditText Email;
    private EditText Password;
    private EditText conPass;
    private FirebaseAuth regAuth;
//    private FirebaseUser userAuth;
    private Button Registe;
//    private ProgressBar proBar;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerpage);

        Banner = (TextView) findViewById(R.id.banner);
        Banner.setOnClickListener(this);

        regAuth=FirebaseAuth.getInstance();

        Registe = (Button) findViewById(R.id.sign);
        Registe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerAct();
            }
        });

        Fullname = (EditText) findViewById(R.id.fullname);
        Domisili = (EditText) findViewById(R.id.domisili);
        Age = (EditText) findViewById(R.id.age);
        Email = (EditText) findViewById(R.id.email2);
        Password = (EditText) findViewById(R.id.passreg);
        conPass = (EditText) findViewById(R.id.passreg2);
//        proBar = (ProgressBar) findViewById(R.id.progressBar);
//
//        proBar.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.banner:
                Intent intent =new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.sign:
                registerAct();
        }
    }

    private void registerAct() {
        String namalengkap = Fullname.getText().toString().trim();
        String pass = Password.getText().toString().trim();
        String pass2 = conPass.getText().toString().trim();
        String umur = Age.getText().toString().trim();
        String alamat = Domisili.getText().toString().trim();
        String email = Email.getText().toString().trim();

        if (namalengkap.isEmpty()){
            Fullname.setError("Full Name Is Required");
            Fullname.requestFocus();
            return;
        }
        if (alamat.isEmpty()){
            Domisili.setError("Domisili Is Required");
            Domisili.requestFocus();
            return;
        }
        if (umur.isEmpty()){
            Age.setError("Umur Is Required");
            Age.requestFocus();
            return;
        }
        if (email.isEmpty()){
            Email.setError("Email Is Required");
            Email.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Email.setError("Please Provide Valid Email");
            Email.requestFocus();
            return;
        }
        if (pass.isEmpty()){
            Password.setError("Password Is Required");
            Password.requestFocus();
            return;
        }
        if (pass.length()<6){
            Password.setError("Password Must At Least Have 6 Characters");
            Password.requestFocus();
            return;
        }
        if (!pass.equals(pass2)){
            conPass.setError("Password not match");
            conPass.requestFocus();
            return;
        }
        regAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(daftar.this, "Registrasi Berhasil", Toast.LENGTH_LONG).show();
//                    Intent intent = new Intent(daftar.this,);
//                    startActivity(intent);
                }
                else {
                    Toast.makeText(daftar.this, "Registrasi Gagal", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}