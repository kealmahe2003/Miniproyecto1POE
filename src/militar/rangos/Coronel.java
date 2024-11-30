package militar.rangos;
import militar.Operaciones.OperacionesMilitares;


//la clase Coronel con las implementaciones de operacionesMilitares y extencion de Rango
public class Coronel extends Rango implements OperacionesMilitares, Persona {
    private String estrategia;
    private String id;
    private String nombre;
    private String rango;
    private String mision;

    public Coronel(String estrategia) {
        super(4); 
        this.estrategia = estrategia;
    }

    //las distintas acciones de el coronel para administrar las misiones de el
    @Override
    public String realizarAccion() {
       return ("El Coronel humilla a los soldaods con su rango, nivel y no sabemos que mas pero los humilla");
    }


    @Override
    public String reportarEstado() {
        return ("Estrategia actual: " + estrategia + "Mision: " + getMision());
    }

    public String saludar(){
        return ("¡Todo el batallon se inclina ante mi presencia!, solo escucha.");
    }
    
    
    public String getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(String estrategia) {
        this.estrategia = estrategia;
    }
    
    
    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id.trim();
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setRango(String rango) {
        this.rango = rango;
    }

    @Override
    public String getRango() {
        return rango;
    }

    @Override
    public void setCualidad(String cualidad) {
        this.estrategia = cualidad;
    }

    @Override
    public String getCualidad() {
        return getEstrategia();
    }

    public String regañar(int id){
        return ("El Coronel " + nombre + " ha regañado a el soldado " + id + " de rango " + rango);
    }

    // Metodo de regaño
    public void regañado() {
        try {
            nivel = nivel - 1;
            String message = ("El Coronel fue regañado por no cumplir con su deber. Por lo tanto será degradado");
            return ;  

        } catch (Exception e) {
            String message = ("Este soldado no ha podido ser regañado.");
            return;
        }
    }

    // metodo para asignar mision
    public void asignarMision(String mision){
        this.mision = mision;
    }

    public String getMision(){
        return mision;
    }


}