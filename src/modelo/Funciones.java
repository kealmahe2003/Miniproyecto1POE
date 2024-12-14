package modelo;

import java.util.ArrayList;
import java.util.List;

public class Funciones {

    // Lista de soldados
    private final static List<Soldado> soldados = new ArrayList<>();
    private final static List<Soldado> soldadosBackup = new ArrayList<>();

    // Lista de operaciones
    public Funciones() {

    }

    // Método para agregar un soldado
    public String agregarSoldado(String nombre, String id) {
        // Validar que el ID solo contenga números y tenga un máximo de 6 caracteres
        if (!id.matches("\\d{1,5}")) {
            return "El ID debe contener solo números y tener un máximo de 6 caracteres.";
        }

        // Verificar si el soldado existe o no mediante el ID
        if (buscarID(id) != null) {
            return "El ID ya existe.";
        }

        // Se crea el nuevo soldado y se almacena en el arrayList soldados
        SoldadoRaso raso = new SoldadoRaso(nombre, id);
        soldados.add(raso);
        // Al final del proceso se actualiza la lista de soldados

        return "Soldado agregado correctamente.";

    }

    // Método para modificar un soldado
    public String modificarSoldado(String id, String nuevoNombre, String nuevoRango) {
        try {
            backupSoldados(); // Se realiza un backup de los soldados antes de modificar

            Soldado soldado = buscarID(id);

            if (soldado == null) { // Si el soldado no existe, se muestra un mensaje de error
                return "Soldado no encontrado.";
            }

            // Se actualizan los datos del soldado
            soldado.setNombre(nuevoNombre); // Se actualiza el nombre del soldado
            soldado.setRango(nuevoRango); // Se actualiza el rango del soldado

            return "Soldado modificado correctamente.";
        } catch (Exception e) {
            return "Error al modificar el soldado.";
        }
    }

    // Método para eliminar un soldado
    public String eliminarSoldado(String id) {
        try {
            backupSoldados(); // Se realiza un backup de los soldados antes de eliminar

            Soldado soldado = buscarID(id);

            if (soldado == null) { // Si el soldado no existe, se muestra un mensaje de error
                return "Soldado no encontrado.";
            }

            soldados.remove(soldado); // Se elimina el soldado de la lista de soldados
            return "Soldado eliminado correctamente.";
        } catch (Exception e) {
            return "Error al eliminar el soldado.";
        }
    }

    // Método para realizar un backup de los soldados (implementación de ejemplo)
    // Método para actualizar la lista de soldados en la tabla
    /*private void actualizarListaOperaciones() {
            try {
                tablaOperaciones.setRowCount(0);
                for (Persona personas : personas) {
                    tablaOperaciones.addRow(new Object[]{personas.getId(), personas.getRango(), personas.getCualidad()});
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al actualizar la lista de operaciones.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }*/
    // Método para buscar un soldado por su ID
    public Soldado buscarID(String id) {
        for (Soldado soldado : soldados) { // Se recorren los soldados y se compara el ID
            if (soldado.getId().equals(id)) {
                return soldado;
            }
        }
        return null;
    }

    // Método para realizar un backup de los soldados
    private void backupSoldados() {
        soldadosBackup.clear(); // Se limpia el backup anterior
        for (Soldado soldado : soldados) { // Se recorren los soldados y se agregan al backup
            SoldadoRaso raso = new SoldadoRaso(soldado.getNombre(), soldado.getId());
            soldadosBackup.add(raso);
        }
    }

    public String deshacerCambios() {
        try {
            if (soldadosBackup.isEmpty()) { // Si no hay cambios para deshacer, se muestra un mensaje
                return "No hay cambios para deshacer";
            }

            soldados.clear(); // Se limpia la lista de soldados actual
            for (Soldado soldado : soldadosBackup) {
                SoldadoRaso raso = new SoldadoRaso(soldado.getNombre(), soldado.getId()); // Se recorren los soldados del backup y se agregan a la lista actual
                soldados.add(raso);
            }
            return "Cambios deshechos correctamente";
        } catch (Exception e) {
            return "Error al deshacer los cambios";
        }
    }

    public static List<Soldado> getSoldados() {
        return soldados;
    }

}
