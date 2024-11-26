package militar.rangos;
import java.util.Random;

//la clase rando la cual todos heredan para el funcionamiento de el rango y la prihoridad
public abstract class Rango {

    protected int nivel;
    private String mision;
    public Random random = new Random();

    //aqui se muestra el nivel de rango, que se adjunta a el nombre para saber quien esta mas arriba
    public Rango(int nivel) {

        this.nivel = nivel;
        this.mision = "Sin misión asignada";
    }

    //distintas funciones para agregar el rango a los soldados en general
    public void asignarMision(String mision) {
        this.mision = mision;
    }

    public String getMision() {
        return mision;
    }

    public String reportarEstado() {
        return ("Misión actual: " + mision);
    }


    public abstract void realizarAccion();
}