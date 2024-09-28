package militar.rangos;

public class Teniente extends Rango {
    private String unidad;

    public Teniente(String unidad) {
        super(2);
        this.unidad = unidad;
    }

    @Override
    public void realizarAccion() {
        System.out.println("El Teniente supervisa a los soldados rasos.");
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
}