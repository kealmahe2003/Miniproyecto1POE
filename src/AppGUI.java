import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import militar.soldados.Soldado;

public class AppGUI extends JFrame {
    private final List<Soldado> soldados = new ArrayList<>();
    private final DefaultTableModel tableModel = new DefaultTableModel(new String[]{"ID", "Nombre", "Rango"}, 0);
    private final JTable table = new JTable(tableModel);

    public AppGUI() {
        // Configuración de la ventana principal
        setTitle("Sistema de Gestión de Rangos Militares");
        setSize(1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel superior con botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 5));

        JButton btnAgregar = new JButton("Agregar Soldado");
        JButton btnModificar = new JButton("Modificar Soldado");
        JButton btnEliminar = new JButton("Eliminar Soldado");
        JButton btnVerLista = new JButton("Ver Lista");
        JButton btnGestionar = new JButton("Gestionar Operaciones");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnModificar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnVerLista);
        panelBotones.add(btnGestionar);

        // Tabla para mostrar soldados
        JScrollPane scrollPane = new JScrollPane(table);

        // Agregar componentes a la ventana
        add(panelBotones, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Configurar eventos de botones
        btnAgregar.addActionListener(e -> agregarSoldado());
        btnModificar.addActionListener(e -> modificarSoldado());
        btnEliminar.addActionListener(e -> eliminarSoldado());
        btnVerLista.addActionListener(e -> actualizarLista());
        btnGestionar.addActionListener(e -> gestionarOperaciones());
    }

    private void agregarSoldado() {
        // Crear un cuadro de diálogo para ingresar datos
        JTextField txtNombre = new JTextField();
        JTextField txtID = new JTextField();
        Object[] message = {
                "Nombre:", txtNombre,
                "ID:", txtID,
        };
        int option = JOptionPane.showConfirmDialog(this, message, "Agregar Soldado", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String nombre = txtNombre.getText();
            String id = txtID.getText();

            if (buscarID(id) != null) {
                JOptionPane.showMessageDialog(this, "El ID ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Soldado soldado = new Soldado(nombre, id, "Soldado Raso");
            soldados.add(soldado);
            JOptionPane.showMessageDialog(this, "Soldado agregado correctamente.");
            actualizarLista();
        }
    }

    private void modificarSoldado() {
        String id = JOptionPane.showInputDialog(this, "Ingrese el ID del soldado a modificar:");
        Soldado soldado = buscarID(id);

        if (soldado == null) {
            JOptionPane.showMessageDialog(this, "Soldado no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JTextField txtNombre = new JTextField(soldado.getNombre());
        JTextField txtRango = new JTextField(soldado.getRango());
        Object[] message = {
                "Nombre:", txtNombre,
                "Rango:", txtRango,
        };
        int option = JOptionPane.showConfirmDialog(this, message, "Modificar Soldado", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            soldado.setNombre(txtNombre.getText());
            soldado.setRango(txtRango.getText());
            JOptionPane.showMessageDialog(this, "Soldado modificado correctamente.");
            actualizarLista();
        }
    }

    private void eliminarSoldado() {
        String id = JOptionPane.showInputDialog(this, "Ingrese el ID del soldado a eliminar:");
        Soldado soldado = buscarID(id);

        if (soldado == null) {
            JOptionPane.showMessageDialog(this, "Soldado no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        soldados.remove(soldado);
        JOptionPane.showMessageDialog(this, "Soldado eliminado correctamente.");
        actualizarLista();
    }

    private void actualizarLista() {
        tableModel.setRowCount(0);
        for (Soldado soldado : soldados) {
            tableModel.addRow(new Object[]{soldado.getId(), soldado.getNombre(), soldado.getRango()});
        }
    }
    //falta implementar
    private void gestionarOperaciones() {
        JOptionPane.showMessageDialog(this, "Gestión de operaciones aún no implementada.");
    }

    private Soldado buscarID(String id) {
        for (Soldado soldado : soldados) {
            if (soldado.getId().equals(id)) {
                return soldado;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppGUI app = new AppGUI();
            app.setVisible(true);
        });
    }
}