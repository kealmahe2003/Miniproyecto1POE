package militar.rangos;

import militar.soldados.Soldado;

public class SoldadoRaso extends Soldado{
    public SoldadoRaso(String nombre, String id) {
        super(nombre, id, "Soldado Raso");
    }
    
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Acción: Seguir órdenes.");
    }

    public void realizarAccion() {
        System.out.println("El Soldado Raso sigue las órdenes.");
    }
}
