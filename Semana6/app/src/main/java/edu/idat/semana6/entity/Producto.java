package edu.idat.semana6.entity;

public class Producto {
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int imagenId;

    public Producto() {
        this.id = 0;
        this.nombre = "";
        this.descripcion = "";
        this.precio = 0;
        this.imagenId = 0;
    }

    public Producto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = "";
        this.precio = 0;
        this.imagenId = 0;
    }

    public Producto(int id, String nombre, String descripcion, double precio, int imagenId) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagenId = imagenId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getImagenId() {
        return imagenId;
    }

    public void setImagenId(int imagenId) {
        this.imagenId = imagenId;
    }
}
