package militar.rangos;
import militar.Operaciones.OperacionesMilitares;

//La clase teniente hereda de Rango e implementa la interface OperacionesMilitares
public class Teniente extends Rango implements OperacionesMilitares {
    private String unidad;

    //Se establece el rango teniente
    public Teniente(String unidad) {
        super(2);
        this.unidad = unidad;
    }

    //aqui mostramos la mision del teniente por defecto
    @Override
    public void realizarAccion() {
        System.out.println("El Teniente supervisa a los soldados rasos.");
    }

    //si vamos a cambiar la mision del teniente, aqui se muestra como
    @Override
    public void asignarMision(String mision){
      System.out.println("El Teniente de la unidad " + unidad + ", ha sido asignado a la mision de: " + mision);
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
}