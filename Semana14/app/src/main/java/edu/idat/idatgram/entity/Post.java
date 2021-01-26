package edu.idat.idatgram.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Post {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String rutaImagen;
    private String descripcion;

    public Post() {
    }

    public Post(String rutaImagen, String descripcion) {
        this.rutaImagen = rutaImagen;
        this.descripcion = descripcion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
