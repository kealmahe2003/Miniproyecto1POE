package militar.rangos;

public class Capitan extends Rango {
    private int cantidadSoldadosBajoSuMando;

    public Capitan(int cantidadSoldadosBajoSuMando) {
        super(3); // Nivel 3 para Capitán
        this.cantidadSoldadosBajoSuMando = cantidadSoldadosBajoSuMando;
    }

    @Override
    public void realizarAccion() {
        System.out.println("El Capitán está coordinando una misión con " + cantidadSoldadosBajoSuMando + " soldados bajo su mando.");
    }
}
