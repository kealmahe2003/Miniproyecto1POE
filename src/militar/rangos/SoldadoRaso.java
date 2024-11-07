package militar.rangos;
import militar.Operaciones.OperacionesMilitares;
import militar.soldados.Soldado;

public class SoldadoRaso extends Soldado implements OperacionesMilitares{
    public SoldadoRaso(String nombre, String id) {
        super(nombre, id, "Soldado Raso");
    }
    
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
    }

    public void realizarAccion() {
        System.out.println("El Soldado Raso sigue las órdenes.");
    }

    @Override 
    public void asignarMision(String mision){
        System.out.println("A el soldado " + getId() + " con nombre " + getNombre() + " se le ha asignado la mision de: \n"
        + mision);
    }

    public void reportarEstado(){
        System.out.println("El soldado " + getId() + " se encuentra activo");
    }
}
