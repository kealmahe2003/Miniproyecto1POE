package militar.rangos;

public abstract class Rango {
    protected int nivel;

    public Rango(int nivel) {
        this.nivel = nivel;
    }

    public abstract void realizarAccion();
}
