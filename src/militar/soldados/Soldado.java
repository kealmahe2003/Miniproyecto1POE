package militar.soldados;

import javax.swing.JOptionPane;
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
        this.nivel = 1;
    }
        

    //la forma en que vamos a imprimir la informacion de el soldado
    public void mostrarInfo(){
        this.getId();
        this.getNombre();
        this.getRango();
    }
    
    // Metodo saludar
    public void saludar() {
        try {
            // Si el nombre empieza y termina en la misma letra
            if (nombre.length() > 0 && nombre.charAt(0) == nombre.charAt(nombre.length() - 1)) {
                JOptionPane.showMessageDialog(null, "El soldado " + nombre + " saluda, es un chico chill y tranquilo.",
                 "Saludo", JOptionPane.OK_OPTION);
            } else {
                JOptionPane.showMessageDialog(null, "El soldado " + nombre + " saluda formalmente.",
                 "Saludo", JOptionPane.OK_OPTION);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El Soldado no ha podido saludar.");
            System.out.println(e);
        }
        
    } 

    
    // Metodo patrullar
    public String patrullar() {
        return "El soldado " + nombre + " está patrullando.";
    }

    // Metodo de regaño
    @Override
    public void regañado() {
        try {
            nivel = nivel - 1;
            String message = ("El Soldado Raso fue regañado por no cumplir con su deber. Por lo tanto será expulsado del batallón");
            JOptionPane.showConfirmDialog(null, message, "¡!", JOptionPane.OK_OPTION);

        } catch (Exception e) {
            String message = ("Este soldado no ha podido ser regañado.");
            JOptionPane.showConfirmDialog(null, message, "¡!", JOptionPane.OK_OPTION);
        }
    }
        
    
    // aqui se guarda los datos del soldado
    @Override
    public String getNombre() {
        return nombre;
    }
        
    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
        
    @Override
    public String getId() {
        return id.trim();
    }
        
    @Override
    public void setId(String id) {
        this.id = id;
    }
    
    @Override
    public String getRango() {
        return rango;
    }
    
    @Override
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


    @Override
    public String getMision() {
        return mision;
    }

    @Override
    public void asignarMision(String mision) {
        this.mision = mision;
    }
}
