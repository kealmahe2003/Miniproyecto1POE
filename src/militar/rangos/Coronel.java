package militar.rangos;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import militar.Operaciones.OperacionesMilitares;
public class Coronel extends Rango implements OperacionesMilitares, Persona {
    private String estrategia;
    private String id;
    private String nombre;
    private String rango;
    private String mision;

    public Coronel(String estrategia) {
        super(4); 
        this.estrategia = estrategia;
    }

    //las distintas acciones de el coronel para administrar las misiones de el
    @Override
    public String realizarAccion() {
       return ("El Coronel humilla a los soldaods con su rango, nivel y no sabemos que mas pero los humilla");
    }


    @Override
    public String reportarEstado() {
        return ("Estrategia actual: " + estrategia + "Mision: " + getMision());
    }

    public String saludar(){
        return ("¡Todo el batallon se inclina ante mi presencia!, solo escucha.");
    }
    
    
    public String getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(String estrategia) {
        this.estrategia = estrategia;
    }
    
    
    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id.trim();
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setRango(String rango) {
        this.rango = rango;
    }

    @Override
    public String getRango() {
        return rango;
    }

    @Override
    public void setCualidad(String cualidad) {
        this.estrategia = cualidad;
    }

    @Override
    public String getCualidad() {
        return getEstrategia();
    }

    public String regañar(int id){
        return ("El Coronel " + nombre + " ha regañado a el soldado " + id + " de rango " + rango);
    }

    // Metodo de regaño
    @Override
    public void regañado() {
        try {
            nivel = nivel - 1;
            String message = ("El Coronel fue regañado por no cumplir con su deber. Por lo tanto será degradado");
            JOptionPane.showConfirmDialog(null, message, "¡!", JOptionPane.OK_OPTION);

        } catch (Exception e) {
            String message = ("Este soldado no ha podido ser regañado.");
            JOptionPane.showConfirmDialog(null, message, "¡!", JOptionPane.OK_OPTION);
        }
    }

    public void organizarDesfile() {
    String mensaje = """
        El Coronel ha ordenado un desfile sorpresa:
        - Soldados marchando en formacion impecable 
        - Banda militar tocando canciones patrioticas 
        - Tropas llenas de entusiasmo 
        """;
    // Aqui me entere que se podian usar JOption pane en las clases porque pensaba
    //que tocaba extender de JFrame xd, muy tarde porque ya hice todo lo de teniente
    JOptionPane.showMessageDialog(null, mensaje, "Desfile Militar", JOptionPane.INFORMATION_MESSAGE);
    }

    public void premioOcastigo(List<Persona> soldados) {
    // Seleccionar un soldado aleatorio
    int index = new Random().nextInt(soldados.size());
    Persona soldadoSeleccionado = soldados.get(index);
    
    // Generar una decisión aleatoria (1 = recompensa, 2 = castigo)
    int decision = new Random().nextInt(2) + 1;

    String mensaje;
    switch (decision) {
        case 1 -> {
            mensaje = "El Coronel ha decidido recompensar a " + soldadoSeleccionado.getNombre() +
                      " con un permiso especial para visitar a su familia.";
        }
        case 2 -> {
            int castigo = new Random().nextInt(3); // Elegir un castigo aleatorio
            String castigoDescripcion = switch (castigo) {
                case 0 -> "limpiar las barracas";
                case 1 -> "correr 10 kilometros bajo el sol";
                case 2 -> "entrenar toda la noche en el patio";
                default -> "realizar tareas administrativas aburridas";
            };
            mensaje = "El Coronel ha decidido castigar a " + soldadoSeleccionado.getNombre() +
                      ". El castigo asignado es: " + castigoDescripcion;
        }
        default -> mensaje = "El Coronel está indeciso. Ninguna acción será tomada.";
    }
    
    JOptionPane.showMessageDialog(null, mensaje, "Decisión del Coronel", JOptionPane.INFORMATION_MESSAGE);
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