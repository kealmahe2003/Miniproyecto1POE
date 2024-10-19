package militar.rangos;
import militar.Operaciones.OperacionesMilitares;

public class Capitan extends Rango implements OperacionesMilitares {
    private final int cantidadSoldadosBajoSuMando;

    public Capitan(int cantidadSoldadosBajoSuMando) {
        super(3);
        this.cantidadSoldadosBajoSuMando = cantidadSoldadosBajoSuMando;
    }

    @Override
    public void realizarAccion() {
        System.out.println("El Capitán realiza un sondeo");
    }

    @Override
    public void asignarMision(String mision){
        System.out.println("Mision actual: " + mision);
    }

    @Override
    public void reportarEstado(){
        System.out.println("El capitan se encuentra haciendo la mision con sus " + cantidadSoldadosBajoSuMando + " soldados");
        if(random.nextBoolean() == true){
            System.out.println("La mision fue exitosa");
        }
        else{
            System.out.println("La mision fracaso, soldados perdidos: " + random.nextInt(cantidadSoldadosBajoSuMando));
        }
    }
}
