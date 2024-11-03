package militar.rangos;
import java.util.Random;


public abstract class Rango {

    protected int nivel;
    public Random random = new Random();

    public Rango(int nivel) {

        this.nivel = nivel;

    }

    public abstract void realizarAccion();
}
