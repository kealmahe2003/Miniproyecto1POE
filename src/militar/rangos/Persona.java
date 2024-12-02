package militar.rangos;

public interface Persona {
    
    public void setId(String id);

    public String getId();

    public void setNombre(String nombre);

    public String getNombre();

    public void setRango(String rango);

    public String getRango();

    public void setNivel(int nivel);

    public int getNivel();

    public void setCualidad(String cualidad);

    public String getCualidad();

    public void asignarMision(String mision);

    public String getMision();

    public void regañado();

}