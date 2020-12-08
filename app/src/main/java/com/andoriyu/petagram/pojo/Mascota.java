package com.andoriyu.petagram.pojo;

public class Mascota {
    private int id;
    private String nombre;
    private int votos;
    private int foto;

    public Mascota(String nombre, int votos, int foto) {
        this.nombre = nombre;
        this.votos = votos;
        this.foto = foto;
    }
    public Mascota(){

    }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) {  this.nombre = nombre;}

    public int getVotos() {  return votos; }

    public void setVotos(int votos) {  this.votos = votos; }

    public int getFoto() {  return foto;  }

    public void setFoto(int foto) {  this.foto = foto; }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
