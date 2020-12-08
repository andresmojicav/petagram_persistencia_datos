package com.andoriyu.petagram.presentador;

import android.content.Context;

import com.andoriyu.petagram.db.ConstructorMascotas;
import com.andoriyu.petagram.pojo.Mascota;
import com.andoriyu.petagram.vista_fragment.IRecycerViewFragmentView;

import java.util.ArrayList;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {
    private IRecycerViewFragmentView iRecycerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;
    public RecyclerViewFragmentPresenter(IRecycerViewFragmentView iRecyclerViewFragmentView, Context context) {

        this.iRecycerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerMascotasBaseDatos();

    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iRecycerViewFragmentView.inicializarAdaptadorRV(iRecycerViewFragmentView.crearAdaptador(mascotas));
        iRecycerViewFragmentView.generarLinealLayoutVertical();

    }



}
