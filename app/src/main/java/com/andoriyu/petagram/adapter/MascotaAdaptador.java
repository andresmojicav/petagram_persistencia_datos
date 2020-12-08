package com.andoriyu.petagram.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.andoriyu.petagram.R;
import com.andoriyu.petagram.TopFive;
import com.andoriyu.petagram.db.ConstructorMascotas;
import com.andoriyu.petagram.pojo.Mascota;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{
    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder mascotaViewHolder, int position) {
final Mascota mascota = mascotas.get(position);
ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity) ;
mascotaViewHolder.imgMascota.setImageResource(mascota.getFoto());
mascotaViewHolder.tvNombre.setText(mascota.getNombre());
mascotaViewHolder.tvVotos.setText(String.valueOf(constructorMascotas.obtenerVotosMascota(mascota)));
//mascotaViewHolder.tvVotos.setText(String.valueOf(mascota.getVotos()));

mascotaViewHolder.tvVotos.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        //activity.startActivity(intent);


    }
});

mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        int votos = 0;
        Toast.makeText(activity, "Diste Like a "+ mascota.getNombre(), Toast.LENGTH_SHORT).show();

        ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity) ;
        constructorMascotas.darVotoMascota(mascota);
        votos = constructorMascotas.obtenerVotosMascota(mascota);
        mascotaViewHolder.tvVotos.setText(String.valueOf(constructorMascotas.obtenerVotosMascota(mascota)));

    }
});

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder  extends RecyclerView.ViewHolder {
        private ImageView imgMascota;
        private TextView tvNombre;
        private TextView tvVotos;
        private ImageButton btnLike;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgMascota = (ImageView) itemView.findViewById(R.id.imgMascota);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            tvVotos = (TextView) itemView.findViewById(R.id.tvVotos);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);

        }
    }
}
