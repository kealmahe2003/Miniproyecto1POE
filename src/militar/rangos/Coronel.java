package militar.rangos;
import militar.Operaciones.OperacionesMilitares;


//la clase Coronel con las implementaciones de operacionesMilitares y extencion de Rango
public class Coronel extends Rango implements OperacionesMilitares {
    

    // se le establece el rango al Coronel
    private final String estrategia;
    public Coronel(String estrategia) {
        super(4); 
        this.estrategia = estrategia;
    }

    //las distintas acciones de el coronel para administrar las misiones de el
    @Override
    public void realizarAccion() {
        System.out.println("El Coronel está implementando la estrategia: " + estrategia);
    }

    @Override
    public void asignarMision(String mision) {
    System.out.println("El Coronel, con su estrategia de " + estrategia + ", ha asignado la misión " + mision + ". Las tropas están preparadas.");
    }

    @Override
    public String reportarEstado() {
        return ("Estrategia actual: " + estrategia + "Mision: " + getMision());
    }

    public String getEstrategia(){
        return estrategia;
    }
}