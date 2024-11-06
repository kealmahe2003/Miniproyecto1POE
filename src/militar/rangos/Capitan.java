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
    System.out.println("El Capitán ha asignado la misión: " + mision + " a sus " + cantidadSoldadosBajoSuMando + " soldados.");
    }

    @Override
    public void reportarEstado(){
        System.out.println("El Capitán lidera la misión con sus " + cantidadSoldadosBajoSuMando + " soldados.");
        if(random.nextBoolean()) {
            System.out.println("¡La misión fue exitosa!");
        } else {
            int soldadosPerdidos = random.nextInt(cantidadSoldadosBajoSuMando + 1);
            System.out.println("La misión fracasó. Soldados perdidos: " + soldadosPerdidos + "/" + cantidadSoldadosBajoSuMando);
        }
    }
}