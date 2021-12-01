package id.ub.part1;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PageTwoAdapter extends RecyclerView.Adapter<PageTwoAdapter.ViewHolder> {
    private List<PRT> PRTlist;
    private Activity activity;


    public PageTwoAdapter(ArrayList<PRT> PRTlist, Activity activity) {
        this.PRTlist=PRTlist;
        this.activity=activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.activity_descript,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PRT Broker = PRTlist.get(position);
        holder.Nama.setText("Nama:"+Broker.getName());
        holder.Price.setText("Gaji:"+Broker.getGaji());
        holder.alamat.setText("Domisili:"+Broker.getDomisili());
        holder.skillev.setText("Skill:"+Broker.getSkill());
        holder.usiaa.setText("Umur:"+Broker.getUsia());
        holder.deskrip.setText("Deskripsi:"+Broker.getDescript());
        holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                FragmentManager manager=((AppCompatActivity)activity).getSupportFragmentManager();
                DialogForm2 dialogForm2 = new DialogForm2(Broker.getName(),Broker.getUsia(),Broker.getGaji(),
                        Broker.getSkill(),Broker.getDomisili(),Broker.getDescript(), Broker.getKey(), "Ubah");
                dialogForm2.show(manager,"form");
                return true;
            }
        });
//        holder.deskrip.setText("Deskripsi:"+Broker.getDescript());
    }

    @Override
    public int getItemCount() {
        return PRTlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Nama;
        TextView Price;
        TextView alamat;
        TextView skillev;
        TextView usiaa;
        TextView deskrip;

        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Nama = itemView.findViewById(R.id.name);
            Price = itemView.findViewById(R.id.gaji2);
            alamat = itemView.findViewById(R.id.domisilii);
            skillev = itemView.findViewById(R.id.skillagi);
            usiaa = itemView.findViewById(R.id.usiaa);
            deskrip = itemView.findViewById(R.id.deskriptif);
            cardView = itemView.findViewById(R.id.cardv);
        }
    }
}
