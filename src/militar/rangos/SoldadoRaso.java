package militar.rangos;
import militar.Operaciones.OperacionesMilitares;
import militar.soldados.Soldado;

//la clase soldado raso con las implementaciones de operacionesMilitares
public class SoldadoRaso extends Soldado implements OperacionesMilitares{

    private String mision;

    public SoldadoRaso(String nombre, String id) {
        super(nombre, id, "Soldado Raso", "Activo");
    }
    
    //aqui implementamos las cosas de el soldado raso para que pueda almacenar, imprimir y modificar su informacion
    public void mostrarInfo() {
        super.mostrarInfo();
    }

    public void realizarAccion() {
        System.out.println("El Soldado Raso sigue las órdenes.");
    }


    @Override
    public String reportarEstado(){
        return ("El soldado " + getId() + " se encuentra activo");
    }

    // metodo para asignar mision
    public void asignarMision(String mision){
        this.mision = mision;
    }

    public String getMision(){
        return mision;
    }


}
