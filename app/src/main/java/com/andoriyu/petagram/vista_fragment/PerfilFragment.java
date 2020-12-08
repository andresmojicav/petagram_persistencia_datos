package com.andoriyu.petagram.vista_fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import com.andoriyu.petagram.R;
import com.andoriyu.petagram.adapter.MascotaAdaptador;
import com.andoriyu.petagram.pojo.Mascota;

import java.util.ArrayList;

public class PerfilFragment extends Fragment {
    ArrayList<Mascota> perfilmascotas;
    private RecyclerView listaperfilmascotas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_perfil, container, false);

    }

}