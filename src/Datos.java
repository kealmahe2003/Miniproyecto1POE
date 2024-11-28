public class Datos {
    private String id;
    private String rango;
    private String cualidad;
    private String mision;
    private String nombre;
        
    public Datos(String id, String rango, String cualidad, String mision, String nombre) {
        this.id = id;
        this.rango = rango;
        this.cualidad = cualidad;
        this.mision = mision;
        this.nombre = nombre;
    }
    
    public String getId(){
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

    public String getCualidad() {
        return cualidad;
    }

    public void setCualidad(String cualidad) {
        this.cualidad = cualidad;
    }

    public String getMision() {
        return mision;
    }

    public void setMision(String mision) {
        this.mision = mision;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
