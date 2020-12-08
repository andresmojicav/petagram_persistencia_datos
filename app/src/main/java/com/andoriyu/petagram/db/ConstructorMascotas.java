package com.andoriyu.petagram.db;

import android.content.ContentValues;
import android.content.Context;

import com.andoriyu.petagram.R;
import com.andoriyu.petagram.pojo.Mascota;

import java.util.ArrayList;

public class ConstructorMascotas {
    private static final Integer VOTO = 1;
    private Context context;
    public ConstructorMascotas(Context context){
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){
        BaseDatos db = new BaseDatos(context);
        //insertarMascotas(db);
        return db.obtenerTodasLasMascotas();
    }

    public ArrayList<Mascota> obtenerDatosTopFive(){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerTopFive();
    }

    public void insertarMascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PET_NOMBRE,"Agata");
        contentValues.put(ConstantesBaseDatos.TABLE_PET_VOTOS,"0");
        contentValues.put(ConstantesBaseDatos.TABLE_PET_FOTO ,R.drawable.agata);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PET_NOMBRE,"Flipa");
        contentValues.put(ConstantesBaseDatos.TABLE_PET_VOTOS,"0");
        contentValues.put(ConstantesBaseDatos.TABLE_PET_FOTO ,R.drawable.flipa);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PET_NOMBRE,"Luka");
        contentValues.put(ConstantesBaseDatos.TABLE_PET_VOTOS,"0");
        contentValues.put(ConstantesBaseDatos.TABLE_PET_FOTO ,R.drawable.luka);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PET_NOMBRE,"Mara");
        contentValues.put(ConstantesBaseDatos.TABLE_PET_VOTOS,"0");
        contentValues.put(ConstantesBaseDatos.TABLE_PET_FOTO ,R.drawable.mara);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PET_NOMBRE,"Mauri");
        contentValues.put(ConstantesBaseDatos.TABLE_PET_VOTOS,"0");
        contentValues.put(ConstantesBaseDatos.TABLE_PET_FOTO ,R.drawable.mauri);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PET_NOMBRE,"Milo");
        contentValues.put(ConstantesBaseDatos.TABLE_PET_VOTOS,"0");
        contentValues.put(ConstantesBaseDatos.TABLE_PET_FOTO ,R.drawable.milo);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PET_NOMBRE,"Nero");
        contentValues.put(ConstantesBaseDatos.TABLE_PET_VOTOS,"0");
        contentValues.put(ConstantesBaseDatos.TABLE_PET_FOTO ,R.drawable.nero);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PET_NOMBRE,"Odin");
        contentValues.put(ConstantesBaseDatos.TABLE_PET_VOTOS,"0");
        contentValues.put(ConstantesBaseDatos.TABLE_PET_FOTO ,R.drawable.odin);
        db.insertarMascota(contentValues);

    }

    public void darVotoMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        db.obtenerTopFive();
        db.sumarVotosMascota(mascota);
    }

    public int obtenerVotosMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerVotosMascota(mascota);
    }

    public void obtenerMascotasTopFive(){
        BaseDatos db = new BaseDatos(context);

    }
}
