package id.ub.part1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Adminlog extends AppCompatActivity implements View.OnClickListener {
    private EditText loginAdmin;
    private EditText passwordAdmin;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlog);
        mAuth=FirebaseAuth.getInstance();

        loginAdmin = (EditText) findViewById(R.id.emailadmin);
        passwordAdmin = (EditText) findViewById(R.id.passlogadmin);
        Button button = findViewById(R.id.loginadmin);
        button.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.loginadmin:
                login();
                break;
        }
    }
        private void login() {
            String emailog1=loginAdmin.getText().toString().trim();
            String passlog1=passwordAdmin.getText().toString().trim();

            if (emailog1.isEmpty()){
                loginAdmin.setError("Email Is Required");
                loginAdmin.requestFocus();
                return;
            }
            if(!Patterns.EMAIL_ADDRESS.matcher(emailog1).matches()){
                loginAdmin.setError("Please Provide Valid Email");
                loginAdmin.requestFocus();
                return;
            }
            if (passlog1.isEmpty()){
                passwordAdmin.setError("Password Is Required");
                passwordAdmin.requestFocus();
                return;
            }
            mAuth.signInWithEmailAndPassword(emailog1,passlog1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Intent in =new Intent(Adminlog.this, AdminHome.class);
                        startActivity(in);
                    }else{
                        Toast.makeText(Adminlog.this, "Login Gagal", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

    }
