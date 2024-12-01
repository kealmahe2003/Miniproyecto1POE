package militar.rangos;
import javax.swing.JOptionPane;

import militar.Operaciones.OperacionesMilitares;

//La clase teniente hereda de Rango e implementa la interface OperacionesMilitares
public class Teniente extends Rango implements OperacionesMilitares, Persona {
    private String unidad;
    private String id;
    private String nombre;
    private String rango;
    private String mision;
    private String message;

    //Se establece el rango teniente
    public Teniente(String unidad) {
        super(2);
        this.unidad = unidad;
    }

    //aqui mostramos la mision del teniente por defecto
    @Override
    public String realizarAccion() {
        int probabilidad = random.nextInt(50);
        if (probabilidad%2 == 0){ return "1"; }
        if (probabilidad%5 == 0){ return "2";}
        else{ return "3"; }
    }


    public void regañar(int id){
        try {
            message = ("El Teniente fue regañado por no cumplir con su deber. Por lo tanto será degradado");
            return ;  

        } catch (Exception e) {
            message = ("Este soldado no ha podido ser regañado.");
            return;
        }
    }


    // Esto es para imprimir el estado del teniente
    @Override
    public void reportarEstado(){
        try{
            if (random.nextBoolean()) {
                message = ("El Teniente lidera la misión con su: " + unidad + "¡La misión fue exitosa!");
            } else {
                int soldadosPerdidos = random.nextInt(1);
                message = ("El Teniente lidera la misión con su: " + unidad + "La misión fracasó. Soldados perdidos: " + soldadosPerdidos + "/" + unidad);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El Teniente no ha podido reportar su estado.");
            System.out.println(e);
        }
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
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
        this.unidad = cualidad;
    }

    @Override
    public String getCualidad() {
        return getUnidad();
    }

    // Metodo de regaño
    @Override
    public void regañado() {
        try {
            nivel = nivel - 1;
            String message = ("El Teniente fue regañado por no cumplir con su deber. Por lo tanto será degradado");
            JOptionPane.showConfirmDialog(null, message, "¡!", JOptionPane.OK_OPTION);

        } catch (Exception e) {
            String message = ("Este soldado no ha podido ser regañado.");
            JOptionPane.showConfirmDialog(null, message, "¡!", JOptionPane.OK_OPTION);
        }
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