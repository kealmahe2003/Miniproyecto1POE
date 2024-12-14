package vista.fondo_config;
import java.awt.*;
import javax.swing.*;

public class PantallaLabels {

    // Labels para la pantalla de carga
    private JPanel pantallaCarga = new JPanel();
    private JProgressBar barraProgreso = new JProgressBar();
    
        // Constructor
    public PantallaLabels() {
        
        this.mostrarPantallaCarga();
        this.inicializarBarraProgreso();

    }

    private void mostrarPantallaCarga(){
        pantallaCarga.setBounds(0, 0, 1200, 680);
        pantallaCarga.setBackground(Color.LIGHT_GRAY);
        pantallaCarga.setLayout(null);
        pantallaCarga.setVisible(true);
    }


    // metodo para inicializar la barra de progreso
    private void inicializarBarraProgreso(){
        barraProgreso.setValue(0);
        barraProgreso.setStringPainted(true);
        barraProgreso.setPreferredSize(new Dimension(300, 30));
        barraProgreso.setBackground(new Color(230, 230, 230));
        barraProgreso.setForeground(new Color(76, 175, 80));
        barraProgreso.setBorder(BorderFactory.createLineBorder(new Color(0, 128, 0), 2));
        barraProgreso.setBorderPainted(true);
        barraProgreso.setBounds(350, 250, 500, 30);
    }

    public void cargarBarraProgreso(){
        Timer timer = new Timer(25, e -> {
            if (barraProgreso.getValue() < 100) {
                barraProgreso.setValue(barraProgreso.getValue() + 1);
            }
        });
        timer.start();

        JLabel mensaje = new JLabel("CARGANDO, POR FAVOR ESPERE...", SwingConstants.CENTER);
        mensaje.setFont(new Font("Arial", Font.BOLD, 16));
        mensaje.setBounds(350, 200, 500, 30);
    }
    public JPanel getPantallaCarga(){
        return this.pantallaCarga;
    }
    public JProgressBar getBarraProgreso(){
        return this.barraProgreso;
    }
    

}
