package militar.rangos;
import militar.Operaciones.OperacionesMilitares;

public class Coronel extends Rango implements OperacionesMilitares {
    
    private final String estrategia;
    public Coronel(String estrategia) {
        super(4); 
        this.estrategia = estrategia;
    }

    @Override
    public void realizarAccion() {
        System.out.println("El Coronel está implementando la estrategia: " + estrategia);
    }

    @Override
    public void asignarMision(String mision) {
    System.out.println("El Coronel, con su estrategia de: " + estrategia + ", ha asignado la misión: " + mision + ". Las tropas están preparadas.");
    }

    @Override
    public void reportarEstado() {
        super.reportarEstado();
        System.out.println("Estrategia actual: " + estrategia);
    }

}
