package militar.rangos;
import javax.swing.JOptionPane;

import militar.Operaciones.OperacionesMilitares;


//la clase Coronel con las implementaciones de operacionesMilitares y extencion de Rango
public class Coronel extends Rango implements OperacionesMilitares, Persona {
    private String estrategia;
    private String id;
    private String nombre;
    private String rango;
    private String mision;
    private String message;

    public Coronel(String estrategia) {
        super(4); 
        this.estrategia = estrategia;
    }


    @Override
    public void realizarAccion(String message) {
        try {
            if(random.nextBoolean()) {
                message = ("El Coronel ha decidido realizar una misión");
            } else {
                message = ("El Coronel ha decidido realizar una inspección");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El Coronel no ha podido realizar ninguna acción.");
        }
    }


    @Override
    public void reportarEstado() {
        try {
            if (random.nextBoolean()){
                message = ("Gracias a la estrategia del Coronel, la misión fue exitosa.");
            } else {
                int soldadosPerdidos = random.nextInt(1000);
                message = ("La estrategia del Coronel no funcionó, la misión fracasó. Soldados perdidos: " + soldadosPerdidos + "/" + 1000);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El Coronel no ha podido reportar su estado.");
            System.out.println(e);
        }
    }


    public void saludar(){
        try {
            message = ("El Coronel ha saludado a sus soldados");
            return;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El Coronel no ha podido saludar a sus soldados.");
            System.out.println(e);
        }
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


    public void regañar(int id){
        try {
            message = ("El Coronel ha regañado a el soldado " + id);
            return;
        } catch (Exception e) {
            message = ("El Coronel no ha podido regañar a el soldado " + id);
            return;
        }
    }

    
    // Metodo de regaño
    public void regañado() {
        try {
            nivel = nivel - 1;
            message = ("El Coronel fue regañado por no cumplir con su deber. Por lo tanto será degradado");
            return ;  

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El Coronel no ha podido regañar a el soldado.");
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