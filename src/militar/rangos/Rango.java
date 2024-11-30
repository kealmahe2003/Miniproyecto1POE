package militar.rangos;
import java.util.Random;

import javax.swing.JOptionPane;

public abstract class Rango {

    protected int nivel;
    private String mision;
    public Random random = new Random();
    public String message;

    //Aqui se muestra el nivel de rango, que se adjunta a el nombre para saber quien esta mas arriba
    public Rango(int nivel) {

        this.nivel = nivel;
        this.mision = "Sin misión asignada";
    }

    //Distintas funciones para agregar el rango a los soldados en general
    public void asignarMision(String mision) {
        this.mision = mision;
    }

    public String getMision() {
        return mision;
    }

    public void reportarEstado() {
        try {
            message = ("El rango " + nivel + " tiene la misión de: " + getMision());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha podido reportar el estado.");
            System.out.println(e);
        }
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setMision(String mision) {
        this.mision = mision;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public void realizarAccion(String message) {
        
    }

}