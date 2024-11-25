import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import militar.rangos.SoldadoRaso;
import militar.soldados.Soldado;

public class GUI extends JFrame {
        private final List<Soldado> soldados = new ArrayList<>();
        private final List<Soldado> soldadosBackup = new ArrayList<>();
        private final DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Nombre","ID","Rango"}, 0);
        private final JTable table = new JTable(tableModel);
    
        public GUI() {
            // Configuración de la ventana principal
            setTitle("Sistema de Gestión de Rangos Militares");
            setSize(1200, 680);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setResizable(false);
            setLayout(null);
    
    
            //Panel de fondo
            JPanel panelFondo = new JPanel();
            panelFondo.setBounds(0, 0, 1200, 680);
            panelFondo.setBackground(Color.LIGHT_GRAY);
            panelFondo.setLayout(null);
    
    
            // JLabel imagen
            JLabel imagenFondo = new JLabel();
            imagenFondo.setBounds(0, 0, 1200, 680);
            ImageIcon img = new ImageIcon("src/images/Camuflaje.jpg");
            imagenFondo.setIcon(img);
    
    
            // JLabel del titulo
            JLabel titulo = new JLabel("SISTEMA DE GESTION DE RANGOS MILITARES");
            titulo.setBounds(520, 20, 500, 70);
            titulo.setForeground(Color.white);
            titulo.setFont(new Font("Arial", Font.BOLD, 20));
            titulo.setHorizontalAlignment(SwingConstants.CENTER);

            // JLabel de la tabla de soldados
            JLabel listaSoldados = new JLabel("LISTA DE SOLDADOS");
            listaSoldados.setBounds(20, 60, 300, 30);
            listaSoldados.setForeground(Color.white);
            listaSoldados.setFont(new Font("Arial", Font.BOLD, 16));
            listaSoldados.setHorizontalAlignment(SwingConstants.CENTER);
    
    
            // Panel con botones
            JPanel panelBotones = new JPanel();
            panelBotones.setBounds(400, 90, 740, 450);
            panelBotones.setLayout(new GridLayout(4, 1));
            panelBotones.setBackground(Color.gray);
    
    
            // Definicion de botones con sus caracteristicas
            JButton btnAgregar = new JButton("Agregar Soldado");
            btnAgregar.setFont(new Font("Arial", Font.PLAIN, 14));
            btnAgregar.setBackground(Color.DARK_GRAY);
            btnAgregar.setForeground(Color.white);
            btnAgregar.setBorder(null);
            btnAgregar.setHorizontalAlignment(SwingConstants.CENTER);
    
            JButton btnModificar = new JButton("Modificar Soldado");
            btnModificar.setFont(new Font("Arial", Font.PLAIN, 14));
            btnModificar.setBackground(Color.DARK_GRAY);
            btnModificar.setForeground(Color.white);
            btnModificar.setBorder(null);
            btnModificar.setHorizontalAlignment(SwingConstants.CENTER);
    
            JButton btnEliminar = new JButton("Eliminar Soldado");
            btnEliminar.setFont(new Font("Arial", Font.PLAIN, 14));
            btnEliminar.setBackground(Color.DARK_GRAY);
            btnEliminar.setForeground(Color.white);
            btnEliminar.setBorder(null);
            btnEliminar.setHorizontalAlignment(SwingConstants.CENTER);
    
            JButton btnGestionar = new JButton("Gestionar Operaciones");
            btnGestionar.setFont(new Font("Arial", Font.PLAIN, 14));
            btnGestionar.setBackground(Color.DARK_GRAY);
            btnGestionar.setForeground(Color.white);
            btnGestionar.setBorder(null);
            btnGestionar.setHorizontalAlignment(SwingConstants.CENTER);
    
            JButton btnDeshacerCambios = new JButton("Deshacer Cambios");
            btnDeshacerCambios.setBounds(700, 570, 150, 30);
            btnDeshacerCambios.setFont(new Font("Arial", Font.PLAIN, 14));
            btnDeshacerCambios.setBackground(Color.DARK_GRAY);
            btnDeshacerCambios.setForeground(Color.white);
            btnDeshacerCambios.setBorder(null);
            btnDeshacerCambios.setHorizontalAlignment(SwingConstants.CENTER);
    
    
            // Se agregan los botones al panel de botones
            panelBotones.add(btnAgregar);
            panelBotones.add(btnModificar);
            panelBotones.add(btnEliminar);
            panelBotones.add(btnGestionar);
    
    
            // Panel lateral
            JPanel panelLateral = new JPanel();
            panelLateral.setBounds(0, 0, 350, 680);
            panelLateral.setLayout(null);
            panelLateral.setBackground(Color.DARK_GRAY);
    
    
            // Tabla para mostrar soldados
            JScrollPane tablaDatos = new JScrollPane(table);
            tablaDatos.setBounds(20, 90, 300, 450);
    
    
            // Agregar componentes a la ventana
            add(panelFondo);
            panelFondo.add(titulo);
            panelFondo.add(panelLateral);
            panelLateral.add(listaSoldados);
            panelLateral.add(tablaDatos);
            panelFondo.add(panelBotones);
            panelFondo.add(btnDeshacerCambios);
            panelFondo.add(imagenFondo);
    
    
            // Configurar eventos de botones
            btnAgregar.addActionListener(e -> agregarSoldado());
            btnModificar.addActionListener(e -> modificarSoldado());
            btnEliminar.addActionListener(e -> eliminarSoldado());
            btnGestionar.addActionListener(e -> gestionarOperaciones());
            btnDeshacerCambios.addActionListener(e -> deshacerCambios());
        }
    
        // Método para agregar un soldado
        private void agregarSoldado() {
            backupSoldados(); // Se realiza un backup de los soldados antes de agregar
    
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
                SoldadoRaso raso = new SoldadoRaso(nombre, id);
                soldados.add(raso);
                JOptionPane.showMessageDialog(this, "Soldado agregado correctamente.");
                // Al final del proceso se actualiza la lista de soldados
                actualizarLista();
            }
        }
    
        // Método para modificar un soldado
        private void modificarSoldado() {
            backupSoldados(); // Se realiza un backup de los soldados antes de modificar
    
            // Se solicita el ID del soldado a modificar
            String id = JOptionPane.showInputDialog(this, "Ingrese el ID del soldado a modificar:");
            Soldado soldado = buscarID(id);
    
            if (soldado == null) { // Si el soldado no existe, se muestra un mensaje de error
                JOptionPane.showMessageDialog(this, "Soldado no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
    
            // Se crea un cuadro de diálogo para ingresar los nuevos datos
            JTextField ingresarNombre = new JTextField(soldado.getNombre()); // Se crea un JTextField para modificar el nombre del soldado
            JComboBox<String> ingresarRango = new JComboBox<>(new String[]{"Soldado Raso", "Teniente", "Capitán", "Coronel"}); // Se crea un JComboBox con los rangos
            ingresarRango.setSelectedItem(soldado.getRango()); // El ComboBox tiene por defecto el rango actual del soldado que se quiere modificar
            Object[] message = {
                    "Nombre:", ingresarNombre,
                    "Rango:", ingresarRango,
            }; // Se crea un objeto con los componentes a mostrar
            int option = JOptionPane.showConfirmDialog(this, message, "Modificar Soldado", JOptionPane.OK_CANCEL_OPTION); 
            if (option == JOptionPane.OK_OPTION) { // Si se presiona OK, se actualizan los datos del soldado
                soldado.setNombre(ingresarNombre.getText()); // Se actualiza el nombre del soldado
                soldado.setRango(ingresarRango.getSelectedItem().toString()); // Se actualiza el rango del soldado
                JOptionPane.showMessageDialog(this, "Soldado modificado correctamente.");
                actualizarLista();
            }
        }
    
        // Método para eliminar un soldado
        private void eliminarSoldado() {
            backupSoldados(); // Se realiza un backup de los soldados antes de eliminar
    
            // Se solicita el ID del soldado a eliminar
            String id = JOptionPane.showInputDialog(this, "Ingrese el ID del soldado a eliminar:");
            Soldado soldado = buscarID(id);
    
            if (soldado == null) { // Si el soldado no existe, se muestra un mensaje de error
                JOptionPane.showMessageDialog(this, "Soldado no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
    
            // Se elimina el soldado del arrayList y se actualiza la lista
            soldados.remove(soldado);
            JOptionPane.showMessageDialog(this, "Soldado eliminado correctamente.");
            actualizarLista();
        }
    
        // Método para actualizar la lista de soldados en la tabla
        private void actualizarLista() {
            tableModel.setRowCount(0);
            // Se recorren los soldados y se agregan a la tabla
            for (Soldado soldado : soldados) {
                tableModel.addRow(new Object[]{soldado.getNombre(), soldado.getId(), soldado.getRango()});
            }
        }
    
        //falta implementar
        private void gestionarOperaciones() {
            JOptionPane.showMessageDialog(this, "Gestión de operaciones aún no implementada.");
        }
    
        // Método para buscar un soldado por su ID
        private Soldado buscarID(String id) {
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
    
        // Método para deshacer los cambios realizados
        private void deshacerCambios() {
            if (soldadosBackup.isEmpty()) { // Si no hay cambios para deshacer, se muestra un mensaje
                JOptionPane.showMessageDialog(this, "No hay cambios para deshacer.", "Información", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
    
            soldados.clear(); // Se limpia la lista de soldados actual
            for (Soldado soldado : soldadosBackup) {
                SoldadoRaso raso = new SoldadoRaso(soldado.getNombre(), soldado.getId()); // Se recorren los soldados del backup y se agregan a la lista actual
                soldados.add(raso);
            }
    
            actualizarLista();
            JOptionPane.showMessageDialog(this, "Cambios deshechos correctamente.");
        }

}