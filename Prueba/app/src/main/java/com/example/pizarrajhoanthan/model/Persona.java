package com.example.pizarrajhoanthan.model;

public class Persona {

    private String uid;
    private String nombre;
    private String apellido;
    private String correo;
    private String password;

    //Constructor
    public Persona() {
    }

    //Getters
    public String getUid() {
        return uid;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPassword() {
        return password;
    }

    //Setters

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //To String
    @Override
    public String toString() {
        return nombre;
    }
}
