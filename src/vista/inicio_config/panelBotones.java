package vista.inicio_config;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class panelBotones {

    private JLabel tituloBotones = new JLabel("SISTEMA DE GESTION DE RANGOS MILITARES");
    private JPanel panelFondo = new JPanel();
    private JPanel panelBotones = new JPanel();


    public panelBotones() {
        this.mostrarPanelFondo();
        this.mostrarTituloTabla();
        this.mostrarPanelBotones();
    }

    private void mostrarTituloTabla() {
        tituloBotones.setBounds(520, 20, 500, 70);
        tituloBotones.setForeground(Color.white);
        tituloBotones.setFont(new Font("Arial", Font.BOLD, 20));
        tituloBotones.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void mostrarPanelFondo() {
        panelFondo.setBounds(0, 0, 1200, 680);
        panelFondo.setBackground(Color.LIGHT_GRAY);
        panelFondo.setLayout(null);
        panelFondo.setVisible(false);
    }

    private void mostrarPanelBotones() {
        panelBotones.setBounds(400, 90, 740, 450);
        panelBotones.setLayout(new GridLayout(4, 1));
        panelBotones.setBackground(Color.gray);
    }

    public JPanel getPanelBotones() {
        return this.panelBotones;
    }

    public JLabel getTituloBotones() {
        return this.tituloBotones;
    }

    public JPanel getPanelFondo() {
        return this.panelFondo;
    }

}
