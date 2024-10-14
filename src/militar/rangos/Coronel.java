package militar.rangos;


public class Coronel extends Rango {
    private String estrategia;

    public Coronel(String estrategia) {
        super(4); // Nivel 4 para Coronel
        this.estrategia = estrategia;
    }

    @Override
    public void realizarAccion() {
        System.out.println("El Coronel está implementando la estrategia: " + estrategia);
    }
}
