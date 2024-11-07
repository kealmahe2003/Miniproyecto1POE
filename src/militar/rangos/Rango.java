package militar.rangos;
import java.util.Random;


public abstract class Rango {

    protected int nivel;
    private String mision;
    public Random random = new Random();

    public Rango(int nivel) {

        this.nivel = nivel;
        this.mision = "Sin misión asignada";
    }

    public void asignarMision(String mision) {
        this.mision = mision;
    }

    public String getMision() {
        return mision;
    }

    public void reportarEstado() {
        System.out.println("Misión actual: " + mision);
    }

    public abstract void realizarAccion();
}