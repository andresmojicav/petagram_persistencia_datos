package com.andoriyu.petagram.vista_fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andoriyu.petagram.R;
import com.andoriyu.petagram.adapter.MascotaAdaptador;
import com.andoriyu.petagram.pojo.Mascota;
import com.andoriyu.petagram.presentador.IRecyclerViewFragmentPresenter;
import com.andoriyu.petagram.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment implements IRecycerViewFragmentView {
    ArrayList<Mascota> mascotas;
    private RecyclerView rvmascotas;
    private IRecyclerViewFragmentPresenter presenter;

     @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

         rvmascotas  = (RecyclerView) v.findViewById(R.id.rvMascotas);
         presenter = new RecyclerViewFragmentPresenter(this, getContext());

        return v;

    }


    @Override
    public void generarLinealLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvmascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        rvmascotas.setAdapter(adaptador);
    }
}