package modelo;

import java.util.List;

public class Soldado implements Persona{
    private String id;
    private String nombre;
    private String rango;
    private int nivel;
    private String cualidad;
    
    public Soldado (String nombre, String id, String rango){
        this.id = id;
        this.nombre = nombre;
        this.rango = rango;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        if (rango.equals("Soldado Raso")){
            nivel = 1;
        }
        if (rango.equals("Teniente")){
            nivel = 2;
        }
        if (rango.equals("Capitán")){
            nivel = 3;
        }
        if (rango.equals("Coronel")){
            nivel = 4;
        } 
        this.nivel = nivel;
    }

    public void mostrarInfo (){
        this.getId();
        this.getNombre();
        this.getRango();
    }

    public void patrullar(){

    }

    // Metodo saludar
    public void saludar() {
        //Si el nombre empieza y termina en la misma letra
        if (nombre.length() > 0 && nombre.charAt(0) == nombre.charAt(nombre.length() - 1)) {
            String message = ("El soldado " + nombre + " saluda, es un chico chill y tranquilo.");
        } else {
            String message = ("El soldado " + nombre + " saluda formalmente.");
        }
    } 

    public void regañado(List soldados){
        if (rango == "Soldado Raso"){
            soldados.remove(soldados);
            String message = ("El soldado " + nombre + " ha sido regañado por no cumplir su deber. Por lo tanto será expulsado");
        }
        if (rango == "Teniente"){
            rango = ("Soldado Raso");
            String message = ("El soldado " + nombre + " ha sido regañado por no cumplir su deber. Por lo tanto será degradado");
        }
        if (rango == "Capitán"){
            rango = "Teniente";
            String message = ("El soldado " + nombre + " ha sido regañado por no cumplir su deber. Por lo tanto será degradado");
        }
        if (rango == "Coronel"){
            rango = "Capitán";
            String message = ("El soldado " + nombre + " ha sido regañado por no cumplir su deber. Por lo tanto será degradado");
        }
    }

    @Override
    public void setCualidad(String cualidad) {
        this.cualidad = cualidad;
    }

    @Override
    public String getCualidad() {
        return cualidad;
    }

    
}
