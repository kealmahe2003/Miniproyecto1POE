import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import militar.rangos.*;
import militar.soldados.Soldado;

public class GUI extends JFrame {

        //Listas de soldados, misiones y demas
        private final List<Soldado> soldados = new ArrayList<>();
        private final List<Soldado> soldadosBackup = new ArrayList<>();
        private final List<Datos> datos = new ArrayList<>();
        private final List<Rango> rangos = new ArrayList<>();

        //Tabla datos
        private final DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Nombre","ID","Rango"}, 0);
        private final JTable table = new JTable(tableModel);    

        //Tabla Operaciones 
        private final DefaultTableModel tablaOperaciones = new DefaultTableModel(new String[]{"ID", "Rango", "Cualidad", "Mision"}, 0);
        private final JTable tabla = new JTable(tablaOperaciones); 
        

        public GUI() {

            // Configuración de la ventana principal
            setTitle("Sistema de Gestión de Rangos Militares");
            setSize(1200, 680);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setResizable(false);
            setLayout(null);
    
            
            //Pantalla de carga

            JPanel pantallaCarga = new JPanel();
            pantallaCarga.setBounds(0, 0, 1200, 680);
            pantallaCarga.setBackground(Color.LIGHT_GRAY);
            pantallaCarga.setLayout(null);
            pantallaCarga.setVisible(true);

            JProgressBar barraProgreso = new JProgressBar();
            barraProgreso.setValue(0);
            barraProgreso.setStringPainted(true); 
            barraProgreso.setPreferredSize(new Dimension(300, 30)); 
            barraProgreso.setBackground(new Color(230, 230, 230)); 
            barraProgreso.setForeground(new Color(76, 175, 80));
            barraProgreso.setBorder(BorderFactory.createLineBorder(new Color(0, 128, 0), 2)); 
            barraProgreso.setBorderPainted(true); 
            barraProgreso.setBounds(350, 250, 500, 30);

            //Carga de la barra de progreso
            Timer timer = new Timer(25, e -> {
                if (barraProgreso.getValue() < 100) {
                    barraProgreso.setValue(barraProgreso.getValue() + 1);
                }
            });
            timer.start();
    
            JLabel mensaje = new JLabel("Cargando, por favor espere...", SwingConstants.CENTER);
            mensaje.setFont(new Font("Arial", Font.PLAIN, 16));
            mensaje.setBounds(350, 200, 500, 30);

            add(pantallaCarga);
            pantallaCarga.add(mensaje);
            pantallaCarga.add(barraProgreso);



            //Panel de fondo
            JPanel panelFondo = new JPanel();
            panelFondo.setBounds(0, 0, 1200, 680);
            panelFondo.setBackground(Color.LIGHT_GRAY);
            panelFondo.setLayout(null);
            panelFondo.setVisible(false);
    
    
            // Crear imagen
            ImageIcon img = new ImageIcon("src/images/Camuflaje.jpg");


            // JLabel imagen1
            JLabel imagenFondo1 = new JLabel();
            imagenFondo1.setBounds(1, 1, 1200, 680);
            imagenFondo1.setIcon(img);


            // JLabel imagen2
            JLabel imagenFondo2 = new JLabel();
            imagenFondo2.setBounds(1, 1, 1200, 680);
            imagenFondo2.setIcon(img);
    
    
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
            panelFondo.add(imagenFondo1);


            // Panel Fondo Operaciones
            JPanel panelOperaciones = new JPanel();
            panelOperaciones.setLayout(null);
            panelOperaciones.setBounds(0, 0, 1200, 680);
            panelOperaciones.setBackground(Color.LIGHT_GRAY);
            panelOperaciones.setVisible(false);
            

            // Titulo Operaciones
            JLabel tituloOper = new JLabel("GESTION DE OPERACIONES MILITARES", SwingConstants.CENTER);
            tituloOper.setBounds(520, 20, 500, 70);
            tituloOper.setForeground(Color.white);
            tituloOper.setFont(new Font("Arial", Font.BOLD, 20));
            tituloOper.setBorder(null);
            tituloOper.setHorizontalAlignment(SwingConstants.CENTER);
            

            // Titulo Tabla
            JLabel tituloTablaO = new JLabel("DATOS SOLDADOS");
            tituloTablaO.setBounds(20, 60, 300, 30);
            tituloTablaO.setForeground(Color.white);
            tituloTablaO.setFont(new Font("Arial", Font.BOLD, 16));
            tituloTablaO.setBorder(null);
            tituloTablaO.setHorizontalAlignment(SwingConstants.CENTER);


            // Panel de botones de operaciones
            JPanel panelBtnsOperaciones = new JPanel();
            panelBtnsOperaciones.setBounds(400, 90, 740, 450);
            panelBtnsOperaciones.setLayout(new GridLayout(4, 1));
            panelBtnsOperaciones.setBackground(Color.gray);


            // Botones de operaciones
            JButton btnAsignarMision = new JButton("Asignar misión a un soldado");
            btnAsignarMision.setBounds(350, 50, 300, 43);
            btnAsignarMision.setFont(new Font("Arial", Font.PLAIN, 14));
            btnAsignarMision.setBackground(Color.DARK_GRAY);
            btnAsignarMision.setForeground(Color.white);
            btnAsignarMision.setBorder(null);
            btnAsignarMision.setHorizontalAlignment(SwingConstants.CENTER);

            JButton btnVerEstado = new JButton("Ver estado del soldado");
            btnVerEstado.setBounds(350, 110, 300, 43);
            btnVerEstado.setFont(new Font("Arial", Font.PLAIN, 14));
            btnVerEstado.setBackground(Color.DARK_GRAY);
            btnVerEstado.setForeground(Color.white);
            btnVerEstado.setBorder(null);
            btnVerEstado.setHorizontalAlignment(SwingConstants.CENTER);

            JButton btnRealizarAccion = new JButton("Acciones");
            btnRealizarAccion.setBounds(350, 150, 300, 43);
            btnRealizarAccion.setFont(new Font("Arial", Font.PLAIN, 14));
            btnRealizarAccion.setBackground(Color.DARK_GRAY);
            btnRealizarAccion.setForeground(Color.white);
            btnRealizarAccion.setBorder(null);
            btnRealizarAccion.setHorizontalAlignment(SwingConstants.CENTER);

            JButton btnSalir = new JButton("Volver");
            btnSalir.setBounds(350, 150, 300, 43);
            btnSalir.setFont(new Font("Arial", Font.PLAIN, 14));
            btnSalir.setBackground(Color.DARK_GRAY);
            btnSalir.setForeground(Color.white);
            btnSalir.setBorder(null);
            btnSalir.setHorizontalAlignment(SwingConstants.CENTER);


            // Agregar botones a su panel correspondiente
            panelBtnsOperaciones.add(btnAsignarMision);
            panelBtnsOperaciones.add(btnVerEstado);
            panelBtnsOperaciones.add(btnRealizarAccion);
            panelBtnsOperaciones.add(btnSalir);
            

            // Panel lateral operaciones
            JPanel panelLateralOper = new JPanel();
            panelLateralOper.setBounds(0, 0, 350, 680);
            panelLateralOper.setLayout(null);
            panelLateralOper.setBackground(Color.DARK_GRAY);
            panelLateralOper.setVisible(false);
    

            // Tabla para informacion de operaciones y soldados
            tabla.getTableHeader().setResizingAllowed(false);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(40); 
            tabla.getColumnModel().getColumn(1).setPreferredWidth(70); 
            tabla.getColumnModel().getColumn(2).setPreferredWidth(130); 
            JScrollPane tablaOperaciones = new JScrollPane(tabla);
            tablaOperaciones.setBounds(10, 90,330,450);


            // Agregar componentes al JFrame para la gestion de operaciones
            add(panelOperaciones);
            panelOperaciones.add(tituloOper);
            panelOperaciones.add(panelLateralOper);
            panelOperaciones.add(panelBtnsOperaciones);
            panelLateralOper.add(tituloTablaO);
            panelLateralOper.add(tablaOperaciones);
            panelOperaciones.add(imagenFondo2);


            //Temporizador de la pantalla de carga antes de entrar a la App
            //(artificial porque no demora nada cargando)
            
            Timer tiempo = new Timer(5000, e -> {
                pantallaCarga.setVisible(false);
                panelFondo.setVisible(true);
            });
            // Llamamos al timer para ejecutar la aplicacion
            sonido(2);
            tiempo.setRepeats(false);
            tiempo.start();


            // Configurar eventos de botones PRINCIPALES
            btnAgregar.addActionListener(e -> agregarSoldado());
            btnModificar.addActionListener(e -> modificarSoldado());
            btnEliminar.addActionListener(e -> eliminarSoldado());


            // Configurar eventos de botones OPERACIONES
            btnGestionar.addActionListener(e -> {

                //Ocultar el menu Principal
                actualizarListaOperaciones();
                panelFondo.setVisible(false);
                panelLateral.setVisible(false);

                //Mostrar menu Operaciones
                panelOperaciones.setVisible(true);
                panelLateralOper.setVisible(true);
                
            });

            btnAsignarMision.addActionListener(e -> asignarMision());
            btnVerEstado.addActionListener(e -> verEstado());
            btnRealizarAccion.addActionListener(e -> realizarAccion());
            btnSalir.addActionListener(e -> {
                
                //Mostrar el menu Principal
                panelFondo.setVisible(true);
                panelLateral.setVisible(true);

                //Ocultar el menu Operaciones
                panelOperaciones.setVisible(false);
                panelLateralOper.setVisible(false);

            });

            //Deshacer cambios
            btnDeshacerCambios.addActionListener(e ->  deshacerCambios());

            

            // Mejora de los botones al hacer hover

            //Lista con los botones existentes
            JButton[] botones = {btnAgregar, btnAsignarMision, btnDeshacerCambios, btnEliminar,
            btnGestionar, btnSalir, btnModificar, btnVerEstado, btnRealizarAccion};
            
            // Iteracion para aplicar a todos los botones
            for (JButton boton : botones) {
            hoverBotones(boton);}
            }


        // Void para gestionar el hover de los botones
        private static void hoverBotones(JButton boton){
            boton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    boton.setBackground(Color.GRAY); // Color al pasar el mouse
                    sonido(3);
                }
    
                @Override
                public void mouseExited(MouseEvent e) {
                    boton.setBackground(Color.DARK_GRAY); // Color al salir el mouse
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    sonido(4); // Sonido al clickar
                }
            });}
            
    

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
                
                // Validar que el ID solo contenga números y tenga un máximo de 6 caracteres
                if (!id.matches("\\d{1,5}")) {
                    JOptionPane.showMessageDialog(this, "El ID debe contener solo números y tener un máximo de 6 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Verificar si el soldado existe o no mediante el ID
                if (buscarID(id) != null) {
                    JOptionPane.showMessageDialog(this, "El ID ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
    
                // Se crea el nuevo soldado y se almacena en el arrayList soldados
                SoldadoRaso raso = new SoldadoRaso(nombre, id);
                soldados.add(raso);
                Datos dato = new Datos(id ,"Soldado Raso", "No tiene", "Sin asignar", nombre);
                datos.add(dato);
                JOptionPane.showMessageDialog(this, "Soldado agregado correctamente.");
                // Al final del proceso se actualiza la lista de soldados
                actualizarLista();
                actualizarListaOperaciones();
            }
        }
    
        // Método para modificar un soldado
        private void modificarSoldado() {
            backupSoldados(); // Se realiza un backup de los soldados antes de modificar
    
            // Se solicita el ID del soldado a modificar
            String id = JOptionPane.showInputDialog(this, "Ingrese el ID del soldado a modificar:");
            Soldado soldado = buscarID(id);
            Datos dato = buscarDatos(id);
    
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
            if (option == JOptionPane.OK_OPTION){ 
                // Si se presiona OK, se actualizan los datos del soldado
                soldado.setNombre(ingresarNombre.getText()); // Se actualiza el nombre del soldado
                dato.setNombre(ingresarNombre.getText()); // Se actualiza el nombre del soldado para operaciones
                soldado.setRango(ingresarRango.getSelectedItem().toString()); // Se actualiza el rango del soldado
                dato.setRango(ingresarRango.getSelectedItem().toString()); // Se actualiza el rango del soldado para operaciones
                JOptionPane.showMessageDialog(this, "Soldado modificado correctamente.");
                actualizarLista();
                actualizarListaOperaciones();
            }
        }
    
        // Método para eliminar un soldado
        private void eliminarSoldado() {
            backupSoldados(); // Se realiza un backup de los soldados antes de eliminar
    
            // Se solicita el ID del soldado a eliminar
            String id = JOptionPane.showInputDialog(this, "Ingrese el ID del soldado a eliminar:");
            Soldado soldado = buscarID(id);
            Datos dato = buscarDatos(id);
    
            if (soldado == null) { // Si el soldado no existe, se muestra un mensaje de error
                JOptionPane.showMessageDialog(this, "Soldado no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
    
            soldados.remove(soldado); // Se elimina el soldado de la lista de soldados
            datos.remove(dato); // Se elimina el soldado de la lista de operaciones
            JOptionPane.showMessageDialog(this, "Soldado eliminado correctamente.");
            actualizarLista();
            actualizarListaOperaciones();
        }
    
        // Método para actualizar la lista de soldados en la tabla
        private void actualizarLista() {
            tableModel.setRowCount(0);
            // Se recorren los soldados y se agregan a la tabla
            for (Soldado soldado : soldados) {
                tableModel.addRow(new Object[]{soldado.getNombre(), soldado.getId(), soldado.getRango()});
            }
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

        private Datos buscarDatos(String id){
            for (Datos datos : datos) {
                if (datos.getId().equals(id)){
                    return datos;
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


        //Gestion Operaciones Militares

        //Asignar Mision
        private void asignarMision(){
            // Se ingresa la id del soldado
            String id = JOptionPane.showInputDialog(this, "Ingrese la ID del soldado:");
                    if (id != null && !id.isEmpty()) {
                        Datos dato = buscarDatos(id);
                        if (dato != null) {
                            String rango = dato.getRango();

                            //Si es un soldado raso no se pueden asignar misiones

                            if ("Soldado Raso".equals(rango)) {
                                JOptionPane.showMessageDialog(this, "El Soldado Raso no puede recibir misiones directamente.");
                            }

                            //Si no entonces evaluamos su rango para darle su cualidad 
                            else {
                                switch (rango) {
                                    case "Teniente" -> {
                                        String unidad = JOptionPane.showInputDialog(this, "Ingrese la unidad a la que pertenece (en numeros):");
                                        String mision = JOptionPane.showInputDialog(this, "Ingrese la misión:");
                                        if (unidad != null && mision != null) {
                                            dato.setCualidad(("Unidad #" + unidad));
                                            dato.setMision(mision);
                                            JOptionPane.showMessageDialog(this, "Misión: " + mision + " asignada al Teniente.");
                                        }   
                                    }
                                    case "Capitán" -> {
                                        String cantidadSoldadosStr = JOptionPane.showInputDialog(this, "Ingrese la cantidad de soldados a su mando:");
                                        String mision = JOptionPane.showInputDialog(this, "Ingrese la misión:");
                                        if (cantidadSoldadosStr != null && mision != null) {
                                            int cantidadSoldados = Integer.parseInt(cantidadSoldadosStr);
                                            dato.setCualidad(cantidadSoldados + " soldados a su mando");
                                            dato.setMision(mision);
                                            JOptionPane.showMessageDialog(this, "Misión: " + mision + " asignada al Capitán.");
                                        }
                                    }
                                    case "Coronel" -> {
                                        String estrategia = JOptionPane.showInputDialog(this, "Ingrese la estrategia a implementar:");
                                        String mision = JOptionPane.showInputDialog(this, "Ingrese la misión:");
                                        if (estrategia != null && mision != null) {
                                            dato.setCualidad(estrategia);
                                            dato.setMision(mision);
                                            JOptionPane.showMessageDialog(this, "El coronel esta implementando la estrategia " + estrategia + " para la mision " + mision + " asignada al Coronel.");
                                        } 
                                    }
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Soldado no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                actualizarListaOperaciones();
                }
        

        // Aqui se mira el estado del solado que se muestra en un panel
        private void verEstado(){
            String id = JOptionPane.showInputDialog(this, "Ingrese la ID del soldado para ver su estado:");
            if (id != null && !id.isEmpty()) {
                Soldado soldado = buscarID(id);
                Datos dato = buscarDatos(id);
                    if (soldado != null) {
                        String rango = dato.getRango();
                        switch (rango) {
                            //Switch para definir que estado mostrar
                            case "Soldado Raso" -> {
                            String message = ("El Soldado " + id + " se encuentra activo.");                                  
                            JOptionPane.showMessageDialog(this, message);
                            }
                            case "Teniente" -> {
                                if (dato.getCualidad().equals("No tiene") && dato.getMision().equals("Sin asignar")) {
                                    JOptionPane.showMessageDialog(this, "El Teniente no tiene mision asignada.");
                                } else {
                                    String message = ("El Teniente " + id + " pertenece a la " + dato.getCualidad() + " y tiene la misión de " + dato.getMision() + ".");                                   
                                    JOptionPane.showMessageDialog(this, message);
                                }
                            }
                            case "Capitán" -> {
                                if (dato.getCualidad().equals("No tiene") && dato.getMision().equals("Sin asignar")) {
                                    JOptionPane.showMessageDialog(this, "El Capitán no tiene mision asignada.");
                                } else {
                                    String message = ("El Capitán " + id + " tiene a " + dato.getCualidad() + " y tiene la misión de " + dato.getMision() + ".");                                 
                                    JOptionPane.showMessageDialog(this, message);
                                }
                            }
                            case "Coronel" -> {
                                if (dato.getCualidad().equals("No tiene") && dato.getMision().equals("Sin asignar")) {
                                    JOptionPane.showMessageDialog(this, "El Coronel no tiene mision asignada.");
                                } else {
                                    String message = ("El Coronel " + id + " esta implementando la estrategia " + dato.getCualidad() + " para la misión " + dato.getMision() + ".");                                      
                                    JOptionPane.showMessageDialog(this, message);
                                }
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Soldado no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
        }

        public void realizarAccion(){
            String id = JOptionPane.showInputDialog(this, "Ingrese el ID del soldado:");
            Datos dato = buscarDatos(id);
            String rango = dato.getRango();
            
            switch (rango) {

                case "Soldado Raso" ->  {
                    // Se crea un objeto del tipo SoldadoRaso con los datos del soldado
                    SoldadoRaso soldado = new SoldadoRaso(dato.getNombre(), dato.getId());
                    JComboBox<String> ingresarAccion = new JComboBox<>(new String[]{"Patrullar", "Saludar"});
                    Object[] message = {
                        "Accion a realizar:", ingresarAccion,
                     }; // Se crea un objeto con los componentes a mostrar
                    int option = JOptionPane.showConfirmDialog(this, message, "Realizar accion", JOptionPane.OK_CANCEL_OPTION); 
                    if (option == JOptionPane.OK_OPTION){ 
                        // Se muestra la accion patrullar
                        if ("Patrullar".equals(ingresarAccion.getSelectedItem().toString())){
                            JOptionPane.showMessageDialog(this, soldado.patrullar(), "Accion", JOptionPane.OK_CANCEL_OPTION);
                        }
                        // Se muestra la accion saludar
                        if("Saludar".equals(ingresarAccion.getSelectedItem().toString())){
                            JOptionPane.showMessageDialog(this, soldado.saludar(), "Accion", JOptionPane.OK_CANCEL_OPTION);
                        }
                    }else {
                        return;
                    }
                }

                case "Teniente" -> {
                    // Se crea objeto del tipo Teniente con los datos del soldado
                    Teniente teniente = new Teniente(dato.getCualidad());
                    JComboBox<String> ingresarAccion = new JComboBox<>(new String[]{"Regañar", "Supervisar"});
                    Object[] message = {
                        "Accion a realizar:", ingresarAccion,
                     }; // Se crea un objeto con los componentes a mostrar
                    int option = JOptionPane.showConfirmDialog(this, message, "Realizar accion", JOptionPane.OK_CANCEL_OPTION); 
                    if (option == JOptionPane.OK_OPTION){ 
                        //Se realiza un sondeo
                        if ("Sondear".equals(ingresarAccion.getSelectedItem().toString())){
                            JOptionPane.showMessageDialog(this, teniente.realizarAccion(), "Accion", JOptionPane.OK_CANCEL_OPTION);
                        }
                        //Se regaña a un soldado
                        if ("Regañar".equals(ingresarAccion.getSelectedItem().toString())){
                            // Se pide la id del soldado a regañar
                            String idSoldado = JOptionPane.showInputDialog(this, "Ingrese el ID del soldado:");
                                // Se busca si el soldado es un Soldado Raso
                                Datos soldadoRaso = buscarDatos(idSoldado);
                                // Si es un soldado raso entonces lo regañara
                                if("Soldado Raso".equals(soldadoRaso.getRango())){
                                JOptionPane.showMessageDialog(this, teniente.regañar(Integer.parseInt(idSoldado)), "Accion", JOptionPane.OK_CANCEL_OPTION);
                                // Por implementar: añadir la funcionalidad de bajar su nivel al momento de llamar a
                                // .regañar() y eliminarlo de la lista si es necesario
                                }
                        }
                    }else {
                        return;
                    }
                }

                case "Capitán" -> {
                    // Se crea objeto del tipo Capitan con los datos del soldado
                    Capitan capitan = new Capitan(Integer.parseInt(dato.getCualidad()));
                    JComboBox<String> ingresarAccion = new JComboBox<>(new String[]{"Humillar"});
                    Object[] message = {
                        "Accion a realizar:", ingresarAccion,
                     }; // Se crea un objeto con los componentes a mostrar
                    int option = JOptionPane.showConfirmDialog(this, message, "Realizar accion", JOptionPane.OK_CANCEL_OPTION); 
                    if (option == JOptionPane.OK_OPTION){ 
                        // Se realiza un ataque
                        if ("Atacar".equals(ingresarAccion.getSelectedItem().toString())){
                            JOptionPane.showMessageDialog(this, capitan.realizarAccion(), "Accion", JOptionPane.OK_CANCEL_OPTION);
                        }
                    }else{
                        return;
                    }
                }

                case "Coronel" -> {
                    // Se crea objeto del tipo Coronel con los datos del soldado
                    Coronel coronel = new Coronel(dato.getCualidad());
                    JComboBox<String> ingresarAccion = new JComboBox<>(new String[]{"Saludar", "Humillar"});
                    Object[] message = {
                        "Accion a realizar:", ingresarAccion,
                     }; // Se crea un objeto con los componentes a mostrar
                    int option = JOptionPane.showConfirmDialog(this, message, "Realizar accion", JOptionPane.OK_CANCEL_OPTION); 
                    if (option == JOptionPane.OK_OPTION){ 
                        // Se realiza un ataque
                        if ("Humillar".equals(ingresarAccion.getSelectedItem().toString())){
                            JOptionPane.showMessageDialog(this, coronel.realizarAccion(),  "Accion", JOptionPane.OK_CANCEL_OPTION);
                        }
                        if ("Saludar".equals(ingresarAccion.getSelectedItem().toString())){
                            sonido(1);
                            JOptionPane.showMessageDialog(this, coronel.saludar(), "Accion", JOptionPane.OK_CANCEL_OPTION);
                        }
                    }else {
                        return;
                    }
                }
            }
        }

        //Manejo de sonidos en la interfaz
        public static void sonido(int sonido) {
            File archivoSonido = null;

            //Switch para seleccionar el sonido segun sea el caso
            switch (sonido) {
                case 1 -> archivoSonido = new File("src/sounds/sonidoCoronel.wav");
                case 2 -> archivoSonido = new File("src/sounds/sonidoInicio.wav");
                case 3 -> archivoSonido = new File("src/sounds/sonidoHover.wav");
                case 4 -> archivoSonido = new File("src/sounds/sonidoBoton.wav");
                default -> {
                    System.out.println("Sonido no válido.");
                    return;
                }
            }
            //Manejo de excepciones del sonido
            try {
                
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);

                // Crear el Clip y abrirlo
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);

                // Reproducir el audio una vez
                clip.start();
            }catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                System.out.println("Error al reproducir el sonido: " + ex.getMessage());
            }
        }

        private void actualizarListaOperaciones() {
            tablaOperaciones.setRowCount(0);
            for (Datos datos : datos) {
                tablaOperaciones.addRow(new Object[]{datos.getId(), datos.getRango(), datos.getCualidad(), datos.getMision()});
            }
        }

        
}