package id.ub.part1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity implements View.OnClickListener {
    private TextView title;
    private Button PRT;
    private Button SOPIR;
    private Button BABY;
    private Button SATPAM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        title = (TextView) findViewById(R.id.textView);

        PRT = (Button) findViewById(R.id.prt);
        PRT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

    }

    @Override
    public void onClick(View view) {

    }
}