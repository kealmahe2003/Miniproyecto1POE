package militar.rangos;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import militar.Operaciones.OperacionesMilitares;
import militar.soldados.Soldado;

//la clase soldado raso con las implementaciones de operacionesMilitares
public class SoldadoRaso extends Soldado implements OperacionesMilitares{

    private String mision;
    private String message;

    public SoldadoRaso(String nombre, String id) {
        super(nombre, id, "Soldado Raso", "Activo");
    }
    
    //aqui implementamos las cosas de el soldado raso para que pueda almacenar, imprimir y modificar su informacion
    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
    }

    public void realizarAccion() {
    try {
            // genera un numero random del 1 al 3
            int randomNum = new java.util.Random().nextInt(3) + 1;
            // si el numero es 1, se va a entrenar
            if (randomNum == 1) {
                message = ("El Soldado Raso se encuentra entrenando.");
            }
            // si el numero es 2, se va a descansar
            if (randomNum == 2) {
                message = ("El Soldado Raso se encuentra descansando.");
            }
            // si el numero es 3, se va a patrullar
            if (randomNum == 3) {
                message = ("El Soldado Raso se encuentra patrullando.");
            }
            JOptionPane.showMessageDialog(null, message,"Soldado", JOptionPane.OK_CANCEL_OPTION);
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "El Soldado Raso no ha podido realizar ninguna acción.");
            System.out.println(e);
        }
    }
    


    @Override
    public String reportarEstado(){
        return ("El soldado " + getId() + " se encuentra activo");
    }

    // metodo para asignar mision
    @Override
    public void asignarMision(String mision){
        this.mision = mision;
    }

    @Override
    public String getMision(){
        return mision;
    }


}
