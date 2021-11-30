package id.ub.part1;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DialogForm extends DialogFragment {
    String name,age,price,skill,doms,desc, key, pilih;
    DatabaseReference db = FirebaseDatabase.getInstance().getReference();

    public DialogForm(String name, String age, String price, String skill, String doms, String desc, String key, String pilih) {
        this.name = name;
        this.age = age;
        this.price = price;
        this.skill = skill;
        this.doms = doms;
        this.desc = desc;
        this.key=key;
        this.pilih=pilih;
    }
    TextView nama;
    TextView umur;
    TextView gaji;
    TextView skillk;
    TextView domisili;
    TextView descript;
    Button btn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view= inflater.inflate(R.layout.inputform,container,false);
        nama=view.findViewById(R.id.NamaSopir);
        umur=view.findViewById(R.id.Usiasup);
        gaji=view.findViewById(R.id.Payday);
        skillk=view.findViewById(R.id.Skill);
        domisili=view.findViewById(R.id.Domisili3);
        descript=view.findViewById(R.id.Descriprion);
        btn=view.findViewById(R.id.Adding);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String asma = nama.getText().toString();
                String usia = umur.getText().toString();
                String payoff = gaji.getText().toString();
                String power = skillk.getText().toString();
                String domisili2 = domisili.getText().toString();
                String desc = descript.getText().toString();

                if (TextUtils.isEmpty(asma)) {
                    input((EditText) nama, "nama");
                } else if (TextUtils.isEmpty(usia)) {
                    input((EditText) umur, "usia");
                } else if (TextUtils.isEmpty(payoff)) {
                    input((EditText) gaji, "gaji");
                } else if (TextUtils.isEmpty(power)) {
                    input((EditText) skillk, "skill");
                } else if (TextUtils.isEmpty(domisili2)) {
                    input((EditText) domisili, "domisili");
                } else if (TextUtils.isEmpty(desc)) {
                    input((EditText) descript, "descript");
                } else {
                    if (pilih.equals("Tambah")){
                        db.child("Data").push().setValue(new Sopir(asma, usia, payoff, power, domisili2, desc)).addOnSuccessListener(
                                new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(view.getContext(), "Data tersimpan", Toast.LENGTH_SHORT).show();
                                    }
                                }
                        ).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(view.getContext(), "Data Gagal tersimpan", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }else if (pilih.equals("Ubah")){
                        db.child("Data").child(key).setValue(new Sopir(asma, usia, payoff, power, domisili2, desc)).addOnSuccessListener(
                                new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(view.getContext(), "Data tersimpan", Toast.LENGTH_SHORT).show();
                                    }
                                }
                        ).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(view.getContext(), "Data Gagal tersimpan", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                }
            }
        });

        return view;
    }


    public void onStart(){
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null){
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
    }
    }
    private void input(EditText txt, String s){
        txt.setError(s+"Tidak Boleh Kosong");
        txt.requestFocus();
    }

}