package id.ub.part1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateSopir extends AppCompatActivity {
    EditText editname,editage,editprice,editskill,editdoms,editdesc;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_sopir);
        editname=findViewById(R.id.NamaSopir);
        editage=findViewById(R.id.Usiasup);
        editprice=findViewById(R.id.Payday);
        editskill=findViewById(R.id.Skill);
        editdoms=findViewById(R.id.Domisili3);
        editdesc=findViewById(R.id.Descriprion);
        add=findViewById(R.id.Adding);
        DAOSopir dao=new DAOSopir();
        add.setOnClickListener(view -> {
            Sopir sop =new Sopir(editname.getText().toString(),editage.getText().toString(),editprice.getText().toString(),editskill.getText().toString()
            ,editdoms.getText().toString(),editdesc.getText().toString());
            dao.add(sop).addOnSuccessListener(suc->
            {
                Toast.makeText(this, "Data is Uploaded", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->
            {
                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });
        });

    }
}