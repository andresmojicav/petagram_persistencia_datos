package com.andoriyu.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import com.andoriyu.petagram.adapter.MascotaAdaptador;
import com.andoriyu.petagram.pojo.Mascota;

import java.util.ArrayList;

public class TopFive extends AppCompatActivity {

    ArrayList<Mascota> mascotasTF;
    private RecyclerView listamascotasTF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_five);

        listamascotasTF= (RecyclerView) findViewById(R.id.rvMascotasTopFive);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listamascotasTF.setLayoutManager(llm);

        Bundle parametros = getIntent().getExtras();

        inicializarListaMascotas();
        inicializarAdaptador();
    }


    public MascotaAdaptador adaptadorTF;
    public void inicializarAdaptador(){
        adaptadorTF = new MascotaAdaptador(mascotasTF,this);
        listamascotasTF.setAdapter(adaptadorTF);
    }

    public void inicializarListaMascotas(){

        mascotasTF= new ArrayList<Mascota>();

        mascotasTF.add(new Mascota("Odin",5,R.drawable.odin));
        mascotasTF.add(new Mascota("Agata",4,R.drawable.agata));
        mascotasTF.add(new Mascota("Flipa",3,R.drawable.flipa));
        mascotasTF.add(new Mascota("Mauri",3,R.drawable.mauri));
        mascotasTF.add(new Mascota("Mara",2,R.drawable.mara));



    }

}