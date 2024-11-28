package militar.soldados;

public class Soldado {
    private String nombre;
    private String id;
    private String rango;
    private int nivelRango;
    

    //constructor de soldado
    public Soldado(String nombre,String id,String rango){
        this.nombre = nombre;
        this.id = id;
        this.rango = rango;
        this.nivelRango = 5;
    }
    
    //la forma en que vamos a imprimir la informacion de el soldado
    public void mostrarInfoConsola(){
        System.out.println("----------------------------------------");
        System.out.println("Nombre del soldado: " + nombre);
        System.out.println("ID: " + id);
        System.out.println("Rango del soldado: " + rango);
        System.out.println("-----------------------------------------\n");
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
    public String regañado() {
        if (nivelRango > 1) {
            nivelRango--;
            return "El soldado " + nombre + " ha sido degradado. Su nuevo nivel de rango es: " + nivelRango;
        } else {
            return "El soldado " + nombre + " ha sido expulsado por no cumplir con su deber.";
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
        return id;
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
}
