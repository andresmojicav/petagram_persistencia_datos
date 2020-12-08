package com.andoriyu.petagram.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.andoriyu.petagram.pojo.Mascota;

import java.util.ArrayList;

public  final class BaseDatos  extends SQLiteOpenHelper {

        private Context context;
        public BaseDatos(@Nullable Context context) {
            super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
            this.context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            String queryCrearTablaContacto = "CREATE TABLE " + ConstantesBaseDatos.TABLE_PET + "("+
                    ConstantesBaseDatos.TABLE_PET_ID + " INTEGER PRIMARY KEY ASC, "+
                    ConstantesBaseDatos.TABLE_PET_NOMBRE + " TEXT, " +
                    ConstantesBaseDatos.TABLE_PET_VOTOS + " INTEGER," +
                    ConstantesBaseDatos.TABLE_PET_FOTO + " INTEGER" +
                    ")";

            db.execSQL(queryCrearTablaContacto);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+ ConstantesBaseDatos.TABLE_PET);
            onCreate(db);
        }

        public ArrayList<Mascota> obtenerTodasLasMascotas(){
            ArrayList<Mascota> mascotas = new ArrayList<>();
            String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_PET;
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor registros = db.rawQuery(query,null);

            while (registros.moveToNext()){
                Mascota mascotaActual = new Mascota();
                mascotaActual.setId(registros.getInt(0));
                mascotaActual.setNombre(registros.getString(1));
                mascotaActual.setVotos(registros.getInt(2));
                mascotaActual.setFoto(registros.getInt(3));

                String queryTopFive = "SELECT *" +
                        " FROM " + ConstantesBaseDatos.TABLE_PET +
                        " ORDER BY " + ConstantesBaseDatos.TABLE_PET_VOTOS + " DESC ";

                Cursor registrosLikes = db.rawQuery(queryTopFive,null);

                if (registrosLikes.moveToNext() ){
                    mascotaActual.setVotos(registrosLikes.getInt(0));
                }else {
                    mascotaActual.setVotos(0);
                }

                mascotas.add(mascotaActual);
            }
            db.close();

            return mascotas;
        }

        public void insertarMascota(ContentValues contentValues){
            SQLiteDatabase db = this.getWritableDatabase();
            db.insert(ConstantesBaseDatos.TABLE_PET, null, contentValues);
            db.close();
        }

        public int obtenerVotosMascota(Mascota mascota){
            int votos = 0;
            String query = "SELECT "+ ConstantesBaseDatos.TABLE_PET_VOTOS +" " +
                    " FROM " + ConstantesBaseDatos.TABLE_PET +
                    " WHERE " + ConstantesBaseDatos.TABLE_PET_ID  + " = " + mascota.getId() ;

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor registros = db.rawQuery(query,null);

            if (registros.moveToNext() ){

                votos = registros.getInt(0);
            }

            return votos;
        }

        public void sumarVotosMascota(Mascota mascota){
            String querySumarVoto = "UPDATE " + ConstantesBaseDatos.TABLE_PET +
                    " SET " + ConstantesBaseDatos.TABLE_PET_VOTOS + " = " +
                    ConstantesBaseDatos.TABLE_PET_VOTOS + " + 1" +
                    " WHERE " + ConstantesBaseDatos.TABLE_PET_ID  + " = " + mascota.getId();
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL(querySumarVoto);
        }

    public ArrayList<Mascota> obtenerTopFive(){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_PET +
                        " ORDER BY " + ConstantesBaseDatos.TABLE_PET_VOTOS + " DESC ";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setVotos(registros.getInt(2));
            mascotaActual.setFoto(registros.getInt(3));

            String queryTopFive = "SELECT *" +
                    " FROM " + ConstantesBaseDatos.TABLE_PET +
                    " ORDER BY " + ConstantesBaseDatos.TABLE_PET_VOTOS + " DESC ";

            Cursor registrosLikes = db.rawQuery(queryTopFive,null);

            if (registrosLikes.moveToNext() ){
                mascotaActual.setVotos(registrosLikes.getInt(0));
            }else {
                mascotaActual.setVotos(0);
            }

            mascotas.add(mascotaActual);
        }
        db.close();

        return mascotas;
    }
}
