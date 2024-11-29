package militar.rangos;
import militar.Operaciones.OperacionesMilitares;


//la clase Capitan con las implementaciones de operacionesMilitares y extencion de Rango
public class Capitan extends Rango implements OperacionesMilitares, Persona {
    private int cantSoldados;
    private String id;
    private String nombre;
    private String rango;
    private String mision;


    public Capitan(int cantSoldados) {
        
        //se asigna el rango con un numero para darle valor numerico superior a quienes manda
        super(3);
        this.cantSoldados = cantSoldados;
    }

    // diversas tareas para que la gestion de las misiones funcione correctamente
    @Override
    public String realizarAccion() {
        return ("El Capitán realiza un sondeo a sus: " + cantSoldados + " soldados");
    }

    @Override
    public String reportarEstado(){
        if(random.nextBoolean()) {
            return ("El Capitán lidera la misión con sus " + cantSoldados + " soldados... " + "¡La misión fue exitosa!");
        } else {
            int soldadosPerdidos = random.nextInt(cantSoldados + 1);
            return ("El Capitán lidera la misión con sus " + cantSoldados + " soldados.." + "La misión fracasó. Soldados perdidos: " + soldadosPerdidos + "/" + cantSoldados);
        }
    }

    public int getCantSoldados() {
        return cantSoldados;
    }

    public void setCantSoldados(int cantSoldados) {
        this.cantSoldados = cantSoldados;
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
        String a = Integer.toString(cantSoldados);
        a = cualidad;
    }

    @Override
    public String getCualidad() {
        return Integer.toString(cantSoldados) + " soldados a su mando";
    }

    public String regañar(int id){
        return ("El Capitán " + nombre + " ha regañado a el soldado " + id);
    }

    // Metodo de regaño
    public void regañado() {
        try {
            nivel = nivel - 1;
            String message = ("El Capitán fue regañado por no cumplir con su deber. Por lo tanto será degradado");
            return ;  

        } catch (Exception e) {
            String message = ("Este soldado no ha podido ser regañado.");
            return;
        }
    }

    // metodo para asignar mision
    public void asignarMision(String mision){
        this.mision = mision;
    }

    public String getMision(){
        return mision;
    }

}