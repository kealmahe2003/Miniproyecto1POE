package vista.gestion_config;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class botonesGestion {

    private JPanel panelOperaciones = new JPanel();
    private JLabel tituloOper = new JLabel("GESTION DE OPERACIONES MILITARES");
    private JPanel panelBtnsOperaciones = new JPanel();

    public botonesGestion() {
        this.mostrarPanelOperaciones();
        this.mostrarTituloOperaciones();
        this.mostrarBotonesOperaciones();
    }

    private void mostrarPanelOperaciones() {
        panelOperaciones.setLayout(null);
        panelOperaciones.setBounds(0, 0, 1200, 680);
        panelOperaciones.setBackground(Color.LIGHT_GRAY);
        panelOperaciones.setVisible(false);
    }

    private void mostrarTituloOperaciones() {
        tituloOper.setBounds(520, 20, 500, 70);
        tituloOper.setForeground(Color.white);
        tituloOper.setFont(new Font("Arial", Font.BOLD, 20));
        tituloOper.setBorder(null);
        tituloOper.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void mostrarBotonesOperaciones() {
        panelBtnsOperaciones.setBounds(400, 90, 740, 450);
        panelBtnsOperaciones.setLayout(new GridLayout(4, 1));
        panelBtnsOperaciones.setBackground(Color.gray);
    }

    public JPanel getPanelOperaciones() {
        return this.panelOperaciones;
    }

    public JLabel getTituloOperaciones() {
        return this.tituloOper;
    }

    public JPanel getPanelBtnsOperaciones() {
        return this.panelBtnsOperaciones;
    }

}
