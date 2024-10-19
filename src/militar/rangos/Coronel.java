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
    public void asignarMision(String mision){
        System.out.println("El coronel con su estrategia: " + estrategia + " se le ha asignado la mision de: " + mision);
    }

    @Override
    public void reportarEstado(){

        System.out.println("El Coronel se encuentra haciendo la estratagia de: " + estrategia + ", junto a los capitanes y soldados");
        System.out.println("Misiones completadas hoy: " + random.nextInt(5));

    }

}
