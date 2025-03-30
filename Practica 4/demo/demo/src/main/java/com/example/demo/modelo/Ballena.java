package com.example.demo.modelo;

public class Ballena {
    private Long id;
    private String nombre;
    private int tamaño;
    private String alimentacion;

    // Constructor vacío
    public Ballena() {}

    // Constructor con parámetros
    public Ballena(Long id, String nombre, int tamaño, String alimentacion) {
        this.id = id;
        this.nombre = nombre;
        this.tamaño = tamaño;
        this.alimentacion = alimentacion;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getTamaño() { return tamaño; }
    public void setTamaño(int tamaño) { this.tamaño = tamaño; }

    public String getAlimentacion() { return alimentacion; }
    public void setAlimentacion(String alimentacion) { this.alimentacion = alimentacion; }
}
