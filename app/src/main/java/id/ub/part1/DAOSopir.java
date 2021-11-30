package id.ub.part1;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAOSopir {
    private DatabaseReference databaseReference;

    public DAOSopir() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Sopir.class.getSimpleName());
    }
    public Task<Void> add(Sopir sopir){

        return databaseReference.push().setValue(sopir);
    }
}
