package militar.soldados;

public class Soldado {
    private String nombre;
    private String id;
    private String rango;

    public Soldado(String nombre,String id,String rango){
        this.nombre = nombre;
        this.id = id;
        this.rango = rango;
    }

    public void mostrarInformacion(){
        System.out.println("----------------------------------------");
        System.out.println("Nombre del soldado: ");
        System.out.println(nombre);
        System.out.println("ID:");
        System.out.println(id);
        System.out.println("Rango del soldado: ");
        System.out.println(rango);
        System.out.println("-----------------------------------------");
    }

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
