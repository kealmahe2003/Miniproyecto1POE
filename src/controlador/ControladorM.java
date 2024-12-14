package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import vista.vistaGUI;
import modelo.Funciones;
import modelo.Persona;
import modelo.Soldado;
import vista.inicio_config.tablaSoldados;

public class ControladorM {

    private vistaGUI vista;
    private Funciones modelo;

    public ControladorM() {
        this.vista = new vistaGUI();
        this.modelo = new Funciones();
        // Registra el ActionListener para el botón
        // Registra el ActionListener para el botón
        this.vista.btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar un JOptionPane para llenar los datos
                Object[] message = {
                    "Nombre:", vista.txtNombre,
                    "ID:", vista.txtID
                };

                // Mostrar el JOptionPane de confirmación para los datos
                int option = JOptionPane.showConfirmDialog(
                        vista, // Ventana padre
                        message,
                        "Agregar Soldado",
                        JOptionPane.OK_CANCEL_OPTION
                );

                // Si el usuario presiona OK, procesar los datos
                if (option == JOptionPane.OK_OPTION) {
                    // Obtener los datos de los campos de texto
                    String nombre = vista.txtNombre.getText();
                    String id = vista.txtID.getText();

                    // Validar que los datos no estén vacíos
                    if (nombre.isEmpty() || id.isEmpty()) {
                        JOptionPane.showMessageDialog(
                                vista,
                                "Por favor, completa todos los campos.",
                                "Error",
                                JOptionPane.ERROR_MESSAGE
                        );
                        return; // Salir si los datos son inválidos
                    }

                    // Llamar al modelo para agregar el soldado
                    String respuesta = modelo.agregarSoldado(nombre, id);

                    // Limpiar los campos de texto
                    vista.txtNombre.setText("");
                    vista.txtID.setText("");

                    // Mostrar un mensaje de confirmación final
                    JOptionPane.showMessageDialog(vista, respuesta);
                    actualizarLista(vista.tablaSoldados);
                }
            }
        });
        this.vista.btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Solicitar el ID del soldado a modificar
                String id = JOptionPane.showInputDialog(vista, "Ingrese el ID del soldado a modificar:");

                // Buscar el soldado por ID
                Soldado soldado = modelo.buscarID(id);
                if (soldado == null) {
                    JOptionPane.showMessageDialog(vista, "Soldado no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Crear un cuadro de diálogo para ingresar los nuevos datos
                JTextField ingresarNombre = new JTextField(soldado.getNombre()); // Se crea un JTextField para modificar el nombre del soldado
                JComboBox<String> ingresarRango = new JComboBox<>(new String[]{"Soldado Raso", "Teniente", "Capitán", "Coronel"}); // Se crea un JComboBox con los rangos
                ingresarRango.setSelectedItem(soldado.getRango()); // El ComboBox tiene por defecto el rango actual del soldado que se quiere modificar
                Object[] message = {
                    "Nombre:", ingresarNombre,
                    "Rango:", ingresarRango,}; // Se crea un objeto con los componentes a mostrar
                int option = JOptionPane.showConfirmDialog(vista, message, "Modificar Soldado", JOptionPane.OK_CANCEL_OPTION);

                if (option == JOptionPane.OK_OPTION) {
                    // Si se presiona OK, se actualizan los datos del soldado
                    String nuevoNombre = ingresarNombre.getText();
                    String nuevoRango = ingresarRango.getSelectedItem().toString();

                    // Llamar al modelo para modificar el soldado
                    String respuesta = modelo.modificarSoldado(id, nuevoNombre, nuevoRango);

                    // Mostrar un mensaje de confirmación final
                    JOptionPane.showMessageDialog(vista, respuesta);
                    actualizarLista(vista.tablaSoldados);
                }
            }
        });

        this.vista.btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Solicitar el ID del soldado a eliminar
                String id = JOptionPane.showInputDialog(vista, "Ingrese el ID del soldado a eliminar:");

                // Llamar al modelo para eliminar el soldado
                String respuesta = modelo.eliminarSoldado(id);

                // Mostrar un mensaje de confirmación final
                JOptionPane.showMessageDialog(vista, respuesta);
                actualizarLista(vista.tablaSoldados);
            }
        });

        this.vista.btnDeshacerCambios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Llamar al modelo para deshacer los cambios
                String respuesta = modelo.deshacerCambios();

                // Mostrar un mensaje de confirmación final
                JOptionPane.showMessageDialog(vista, respuesta);
                actualizarLista(vista.tablaSoldados);
            }
        });
    }

    private void actualizarLista(tablaSoldados tabla) {
        DefaultTableModel auxiliar = tabla.getTableModelo();
        auxiliar.setRowCount(0); // Limpiar la tabla

        // Se recorren los soldados y se agregan a la tabla
        for (Persona soldado : Funciones.getSoldados()) {
            // Verifica el orden de las columnas en tu tabla
            // Asegúrate de que el orden aquí coincida con el orden de las columnas
            auxiliar.addRow(new Object[]{soldado.getNombre(), soldado.getId(), soldado.getRango()});
        }
    }

    public vistaGUI obtenerVistaGui() {
        return this.vista;
    }

    public String agregarSoldado(String nombre, String id) {
        return this.modelo.agregarSoldado(nombre, id);
    }

}
