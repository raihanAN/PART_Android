package id.ub.part1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AdminHome extends AppCompatActivity implements View.OnClickListener {
    Button logout;
    Button supiract;
    private static final int RC_SIGN_IN = 101;
    GoogleSignInClient mGoogleSignInClient;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mAuth=FirebaseAuth.getInstance();
        mGoogleSignInClient = GoogleSignIn.getClient(AdminHome.this, gso);
        logout=(Button) findViewById(R.id.Signout1);
        logout.setOnClickListener(this);
        supiract=(Button) findViewById(R.id.supir1);
        supiract.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.Signout1:
                Intent intent = new Intent(this, MainActivity.class);
                mAuth.signOut();
                mGoogleSignInClient.signOut();
                startActivity(intent);
                break;
            case R.id.supir1:
                Intent intent2 = new Intent(this, CreateSopir.class);
                startActivity(intent2);
                break;
//            case R.id.googlelog:
////                SignGoogle();
        }


    }
}