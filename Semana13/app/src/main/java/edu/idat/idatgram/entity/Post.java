package edu.idat.idatgram.entity;

public class Post {
    private int id;
    private String rutaImagen;
    private String descripcion;

    public Post() {
    }

    public Post(int id, String rutaImagen, String descripcion) {
        this.id = id;
        this.rutaImagen = rutaImagen;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
