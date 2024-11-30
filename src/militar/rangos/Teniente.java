package militar.rangos;
import militar.Operaciones.OperacionesMilitares;

//La clase teniente hereda de Rango e implementa la interface OperacionesMilitares
public class Teniente extends Rango implements OperacionesMilitares, Persona {
    private String unidad;
    private String id;
    private String nombre;
    private String rango;
    private String mision;

    //Se establece el rango teniente
    public Teniente(String unidad) {
        super(2);
        this.unidad = unidad;
    }

    //aqui mostramos la mision del teniente por defecto
    @Override
    public String realizarAccion() {
        return ("El Teniente supervisa a los soldados rasos de su area.");
    }


    public String regañar(int id){
        return ("El teniente de la unidad " + unidad + " ha regañado a el soldado " + id);
    }

    //esto es para imprimir el estado del teniente
    @Override
    public String reportarEstado(){
        return ("El teniente de la unidad " + unidad + ", tiene la mision de: " + getMision());
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
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
        this.unidad = cualidad;
    }

    @Override
    public String getCualidad() {
        return getUnidad();
    }

    // Metodo de regaño
    public void regañado() {
        try {
            nivel = nivel - 1;
            String message = ("El Teniente fue regañado por no cumplir con su deber. Por lo tanto será degradado");
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