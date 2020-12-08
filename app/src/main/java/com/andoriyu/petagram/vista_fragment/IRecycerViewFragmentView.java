package com.andoriyu.petagram.vista_fragment;

import com.andoriyu.petagram.adapter.MascotaAdaptador;
import com.andoriyu.petagram.pojo.Mascota;

import java.util.ArrayList;

public interface IRecycerViewFragmentView {
    public void generarLinealLayoutVertical();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);


}

