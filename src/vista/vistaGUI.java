package vista;
import controlador.ControladorM;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;
import javax.swing.*;
import vista.fondo_config.PantallaLabels;
import vista.gestion_config.botonesGestion;
import vista.gestion_config.tablaGestion;
import vista.inicio_config.panelBotones;
import vista.inicio_config.tablaSoldados;

public class vistaGUI extends JFrame {

    public JButton btnAgregar;
    public JButton btnModificar;
    public JButton btnEliminar;
    public JButton btnDeshacerCambios;
    public JTextField txtNombre = new JTextField();
    public JTextField txtID = new JTextField();
    public boolean guardarSoldado = false;
    public boolean modificarSoldado = false;
    //public JTable tablaSoldados = new JTable();
    public tablaSoldados tablaSoldados = new tablaSoldados();

    //Tabla Operaciones 
    public vistaGUI() {

        PantallaLabels pantallasDeCarga = new PantallaLabels();
        panelBotones pantallaDeinicio = new panelBotones();
        JLabel mensaje = new JLabel("...", SwingConstants.CENTER);
        
        botonesGestion botonesGestion = new botonesGestion();
        tablaGestion tablaGestion = new tablaGestion();

        // Configuración de la ventana principal
        setTitle("Sistema de Gestión de Rangos Militares");
        setSize(1200, 680);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);

        //Pantalla de carga
        JPanel pantallaCarga = pantallasDeCarga.getPantallaCarga();
        JProgressBar barraProgreso = pantallasDeCarga.getBarraProgreso();
        pantallasDeCarga.cargarBarraProgreso();

        // Pantalla de inicio Botones
        JPanel panelFondo = pantallaDeinicio.getPanelFondo();
        JLabel tituloBotones = pantallaDeinicio.getTituloBotones();
        JPanel panelBotones = pantallaDeinicio.getPanelBotones();

        // panel de inicio Tabla
        JLabel tituloTabla = tablaSoldados.getTituloTabla();
        JPanel panelLateral = tablaSoldados.getPanelLateral();

        // Panel de operaciones Botones
        JPanel panelOperaciones = botonesGestion.getPanelOperaciones();
        JLabel tituloOper = botonesGestion.getTituloOperaciones();
        JPanel panelBtnsOperaciones = botonesGestion.getPanelBtnsOperaciones();

        // Panel de operaciones Tabla
        JLabel tituloTablaO = tablaGestion.getTituloTablaO();
        JPanel panelLateralOper = tablaGestion.getPanelLateralOper();

        // Crear imagen1
        ImageIcon img1 = new ImageIcon("src/vista/images/Camuflaje.jpg");

        // Crear imagen2
        ImageIcon img2 = new ImageIcon("src/vista/images/fondo-militar.jpg");

        // JLabel imagen1
        JLabel imagenFondo1 = new JLabel();
        imagenFondo1.setBounds(1, 1, 1200, 680);
        imagenFondo1.setIcon(img1);

        // JLabel imagen2
        JLabel imagenFondo2 = new JLabel();
        imagenFondo2.setBounds(1, 1, 1200, 680);
        imagenFondo2.setIcon(img1);

        // JLabel imagen3
        JLabel imagenFondo3 = new JLabel();
        imagenFondo3.setBounds(1, 1, 1200, 680);
        imagenFondo3.setIcon(img2);

        // Definicion de botones con sus caracteristicas
        this.btnAgregar = new JButton("Agregar Soldado");
        this.btnAgregar.setFont(new Font("Arial", Font.PLAIN, 14));
        this.btnAgregar.setBackground(Color.DARK_GRAY);
        this.btnAgregar.setForeground(Color.white);
        this.btnAgregar.setBorder(null);
        this.btnAgregar.setHorizontalAlignment(SwingConstants.CENTER);
        
        this.btnModificar = new JButton("Modificar Soldado");
        this.btnModificar.setFont(new Font("Arial", Font.PLAIN, 14));
        this.btnModificar.setBackground(Color.DARK_GRAY);
        this.btnModificar.setForeground(Color.white);
        this.btnModificar.setBorder(null);
        this.btnModificar.setHorizontalAlignment(SwingConstants.CENTER);

        this.btnEliminar = new JButton("Eliminar Soldado");
        this.btnEliminar.setFont(new Font("Arial", Font.PLAIN, 14));
        this.btnEliminar.setBackground(Color.DARK_GRAY);
        this.btnEliminar.setForeground(Color.white);
        this.btnEliminar.setBorder(null);
        this.btnEliminar.setHorizontalAlignment(SwingConstants.CENTER);

        JButton btnGestionar = new JButton("Gestionar Operaciones");
        btnGestionar.setFont(new Font("Arial", Font.PLAIN, 14));
        btnGestionar.setBackground(Color.DARK_GRAY);
        btnGestionar.setForeground(Color.white);
        btnGestionar.setBorder(null);
        btnGestionar.setHorizontalAlignment(SwingConstants.CENTER);

        this.btnDeshacerCambios = new JButton("Deshacer Cambios");
        this.btnDeshacerCambios.setBounds(700, 570, 150, 30);
        this.btnDeshacerCambios.setFont(new Font("Arial", Font.PLAIN, 14));
        this.btnDeshacerCambios.setBackground(Color.DARK_GRAY);
        this.btnDeshacerCambios.setForeground(Color.white);
        this.btnDeshacerCambios.setBorder(null);
        this.btnDeshacerCambios.setHorizontalAlignment(SwingConstants.CENTER);

        // Se agregan los botones al panel de botones
        panelBotones.add(btnAgregar);
        panelBotones.add(btnModificar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnGestionar);

        // Tabla para mostrar soldados
        add(pantallaCarga);
        pantallaCarga.add(mensaje);
        pantallaCarga.add(barraProgreso);
        pantallaCarga.add(imagenFondo3);

        // Agregar componentes a la ventana
        add(panelFondo);

        panelFondo.add(panelLateral);
        panelLateral.add(tablaSoldados.getTituloTabla());
        panelLateral.add(tablaSoldados.getTablaSoldados());
        panelFondo.add(panelBotones);
        panelFondo.add(btnDeshacerCambios);
        panelFondo.add(imagenFondo1);

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

        // Agregar componentes al JFrame para la gestion de operaciones
        add(panelOperaciones);
        panelOperaciones.add(tituloOper);
        panelOperaciones.add(panelLateralOper);
        panelOperaciones.add(panelBtnsOperaciones);
        panelLateralOper.add(tituloTablaO);
        panelLateralOper.add(tablaGestion.getTablaOperaciones());
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
        //btnAgregar.addActionListener(e -> agregarSoldado());
        //btnModificar.addActionListener(e -> modificarSoldado());
        //btnEliminar.addActionListener(e -> eliminarSoldado());
        // Configurar eventos de botones OPERACIONES
        btnGestionar.addActionListener(e -> {

            //Ocultar el menu Principal
            //actualizarListaOperaciones();
            panelFondo.setVisible(false);
            panelLateral.setVisible(false);

            //Mostrar menu Operaciones
            panelOperaciones.setVisible(true);
            panelLateralOper.setVisible(true);

        });

        //btnAsignarMision.addActionListener(e -> asignarMision());
        //btnVerEstado.addActionListener(e -> verEstado());
        //btnRealizarAccion.addActionListener(e -> realizarAccion());
        btnSalir.addActionListener(e -> {

            //Mostrar el menu Principal
            panelFondo.setVisible(true);
            panelLateral.setVisible(true);

            //Ocultar el menu Operaciones
            panelOperaciones.setVisible(false);
            panelLateralOper.setVisible(false);

        });

        //Deshacer cambios
        //btnDeshacerCambios.addActionListener(e ->  ControladorM.deshacerCambios());
        // Mejora de los botones al hacer hover
        // Iteracion para aplicar a todos los botones
        JButton[] botones = {btnAgregar, btnAsignarMision, btnDeshacerCambios, btnEliminar,
            btnGestionar, btnSalir, btnModificar, btnVerEstado, btnRealizarAccion};

        for (JButton boton : botones) {
            hoverBotones(boton);
        }
    }

    // Void para gestionar el hover de los botones
    private static void hoverBotones(JButton boton) {
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
        });
    }

    //Manejo de sonidos en la interfaz
    public static void sonido(int sonido) {
        File archivoSonido = null;

        //Switch para seleccionar el sonido segun sea el caso
        switch (sonido) {
            case 1 ->
                archivoSonido = new File("src/vista/sounds/sonidoCoronel.wav");
            case 2 ->
                archivoSonido = new File("src/vista/sounds/sonidoInicio.wav");
            case 3 ->
                archivoSonido = new File("src/vista/sounds/sonidoHover.wav");
            case 4 ->
                archivoSonido = new File("src/vista/sounds/sonidoBoton.wav");
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
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.out.println("Error al reproducir el sonido: " + ex.getMessage());
        }
    }

    public void setControlador(ControladorM controlador) {

    }
}
