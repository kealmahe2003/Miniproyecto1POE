import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import militar.soldados.Soldado;

public class GUI extends JFrame {
    private final List<Soldado> soldados = new ArrayList<>();
    private final DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Nombre","ID"}, 0);
    private final JTable table = new JTable(tableModel);

    public GUI() {
        // Configuración de la ventana principal
        setTitle("Sistema de Gestión de Rangos Militares");
        setSize(1000, 680);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        //Panel de fondo
        JPanel panelFondo = new JPanel();
        panelFondo.setBounds(0, 0, 1000, 680);
        panelFondo.setBackground(Color.LIGHT_GRAY);
        panelFondo.setLayout(null);

        // JLabel del titulo
        JLabel titulo = new JLabel("SISTEMA DE GESTION DE RANGOS MILITARES");
        titulo.setBounds(380, 20, 500, 70);
        titulo.setForeground(new Color(155,20,200));
        titulo.setFont(new Font("Arial", Font.BOLD, 20));

        // Panel con botones
        JPanel panelBotones = new JPanel();
        panelBotones.setBounds(280, 90, 630, 450);
        panelBotones.setLayout(new GridLayout(5, 1));
        panelBotones.setBackground(Color.gray);

        // Definicion de botones con sus caracteristicas
        JButton btnAgregar = new JButton("Agregar Soldado");
        btnAgregar.setFont(new Font("Arial", Font.PLAIN, 14));
        btnAgregar.setBackground(Color.DARK_GRAY);
        btnAgregar.setForeground(Color.white);
        btnAgregar.setBorder(null);
        JButton btnModificar = new JButton("Modificar Soldado");
        btnModificar.setFont(new Font("Arial", Font.PLAIN, 14));
        btnModificar.setBackground(Color.DARK_GRAY);
        btnModificar.setForeground(Color.white);
        btnModificar.setBorder(null);
        JButton btnEliminar = new JButton("Eliminar Soldado");
        btnEliminar.setFont(new Font("Arial", Font.PLAIN, 14));
        btnEliminar.setBackground(Color.DARK_GRAY);
        btnEliminar.setForeground(Color.white);
        btnEliminar.setBorder(null);
        JButton btnVerLista = new JButton("Ver Lista");
        btnVerLista.setFont(new Font("Arial", Font.PLAIN, 14));
        btnVerLista.setBackground(Color.DARK_GRAY);
        btnVerLista.setForeground(Color.white);
        btnVerLista.setBorder(null);
        JButton btnGestionar = new JButton("Gestionar Operaciones");
        btnGestionar.setFont(new Font("Arial", Font.PLAIN, 14));
        btnGestionar.setBackground(Color.DARK_GRAY);
        btnGestionar.setForeground(Color.white);
        btnGestionar.setBorder(null);

        // Se agregan los botones al panel de botones
        panelBotones.add(btnAgregar);
        panelBotones.add(btnModificar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnVerLista);
        panelBotones.add(btnGestionar);

        // Panel lateral
        JPanel panelLateral = new JPanel();
        panelLateral.setBounds(0, 0, 240, 680);
        panelLateral.setLayout(null);
        panelLateral.setBackground(new Color(155,20,200));

        // Tabla para mostrar soldados
        JScrollPane tablaDatos = new JScrollPane(table);
        tablaDatos.setBounds(20, 90, 200, 450);

        // Agregar componentes a la ventana
        add(panelFondo);
        panelFondo.add(titulo);
        panelFondo.add(panelLateral);
        panelLateral.add(tablaDatos);
        panelFondo.add(panelBotones);

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

            // Verificar si el soldado existe o no mediante el ID
            if (buscarID(id) != null) {
                JOptionPane.showMessageDialog(this, "El ID ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Se crea el nuevo soldado y se almacena en el arrayList soldados
            Soldado soldado = new Soldado(nombre, id, "Soldado Raso");
            soldados.add(soldado);
            JOptionPane.showMessageDialog(this, "Soldado agregado correctamente.");
            // Al final del proceso se actualiza la lista de soldados
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
            tableModel.addRow(new Object[]{soldado.getNombre(), soldado.getId()});
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
}