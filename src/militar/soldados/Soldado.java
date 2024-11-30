package militar.soldados;

import militar.rangos.Persona;

public class Soldado implements Persona{
    private String nombre;
    private String id;
    private String rango;
    private int nivel;
    private String cualidad;
    private String mision;
    private String message;
            
        
    //constructor de soldado
    public Soldado(String nombre, String id, String rango, String cualidad) {
        this.nombre = nombre;
        this.id = id;
        this.rango = rango;
    }
        
    //la forma en que vamos a imprimir la informacion de el soldado
    public void mostrarInfo(){
        this.getId();
        this.getNombre();
        this.getRango();
    }
    
    // Metodo saludar
    public String saludar() {
        //Si el nombre empieza y termina en la misma letra
        if (nombre.length() > 0 && nombre.charAt(0) == nombre.charAt(nombre.length() - 1)) {
            return "El soldado " + nombre + " saluda, es un chico chill y tranquilo.";
        } else {
            return "El soldado " + nombre + " saluda formalmente.";
        }
    } 
    
    // Metodo patrullar
    public String patrullar() {
        return "El soldado " + nombre + " está patrullando.";
    }


    // Metodo de regaño
    public void regañado() {
        try {
            nivel = nivel - 1;
            String message = ("El Soldado Raso fue regañado por no cumplir con su deber. Por lo tanto será expulsado del batallón");
            return ;  

        } catch (Exception e) {
            String message = ("Este soldado no ha podido ser regañado.");
            return;
        }
    }
        
    // aqui se guarda los datos del soldado
    public String getNombre() {
        return nombre;
    }
        
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
        
    public String getId() {
        return id.trim();
    }
        
    public void setId(String id) {
        this.id = id;
    }
    
    public String getRango() {
        return rango;
    }
    
    public void setRango(String rango) {
        this.rango = rango;
    }
            
    
    @Override
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    @Override
    public int getNivel() {
        return nivel;
    }
    
    @Override
    public void setCualidad(String cualidad) {
        this.cualidad = cualidad;   
    }

    @Override
    public String getCualidad() {
        return cualidad;
    }


    public String getMision() {
        return mision;
    }

    @Override
    public void asignarMision(String mision) {
        this.mision = mision;
    }
}
