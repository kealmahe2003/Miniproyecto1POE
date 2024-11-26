package militar.rangos;
import militar.Operaciones.OperacionesMilitares;


//la clase Capitan con las implementaciones de operacionesMilitares y extencion de Rango
public class Capitan extends Rango implements OperacionesMilitares {
    private final int cantidadSoldadosBajoSuMando;
    public Capitan(int cantidadSoldadosBajoSuMando) {
        
        //se asigna el rango con un numero para darle valor numerico superior a quienes manda
        super(3);
        this.cantidadSoldadosBajoSuMando = cantidadSoldadosBajoSuMando;
    }

    // diversas tareas para que la gestion de las misiones funcione correctamente
    @Override
    public void realizarAccion() {
        System.out.println("El Capitán realiza un sondeo");
    }

    @Override
    public void asignarMision(String mision){
    System.out.println("El Capitán ha asignado la misión: " + mision + " a sus " + cantidadSoldadosBajoSuMando + " soldados.");
    }

    @Override
    public String reportarEstado(){
        if(random.nextBoolean()) {
            return ("El Capitán lidera la misión con sus " + cantidadSoldadosBajoSuMando + " soldados... " + "¡La misión fue exitosa!");
        } else {
            int soldadosPerdidos = random.nextInt(cantidadSoldadosBajoSuMando + 1);
            return ("El Capitán lidera la misión con sus " + cantidadSoldadosBajoSuMando + " soldados.." + "La misión fracasó. Soldados perdidos: " + soldadosPerdidos + "/" + cantidadSoldadosBajoSuMando);
        }
    }

    public Integer getCantidadSoldados() {
        return cantidadSoldadosBajoSuMando;
    }
}