package vista.gestion_config;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class tablaGestion {

    private JLabel tituloTablaO = new JLabel("DATOS SOLDADOS");
    private JTable tableO = new JTable(new DefaultTableModel(new String[]{"Nombre","ID","Rango"}, 0));
    private JScrollPane tablaGestion = new JScrollPane(tableO);
    private JPanel panelLateralOper = new JPanel();

    public tablaGestion() {
        this.mostrarTituloOperaciones();
        this.mostrarPanelTablaOperaciones();
        this.mostrarTablaOperaciones();
    }

    private void mostrarTituloOperaciones() {
        tituloTablaO.setBounds(20, 60, 300, 30);
        tituloTablaO.setForeground(Color.white);
        tituloTablaO.setFont(new Font("Arial", Font.BOLD, 16));
        tituloTablaO.setBorder(null);
        tituloTablaO.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void mostrarPanelTablaOperaciones() {
        panelLateralOper.setBounds(0, 0, 350, 680);
        panelLateralOper.setLayout(null);
        panelLateralOper.setBackground(Color.DARK_GRAY);
        panelLateralOper.setVisible(false);
    }

    private void mostrarTablaOperaciones() {
        tablaGestion.setBounds(20, 90, 300, 450);
        tableO.getTableHeader().setResizingAllowed(false);
        tableO.getColumnModel().getColumn(0).setPreferredWidth(120);
        tableO.getColumnModel().getColumn(1).setPreferredWidth(40);
        tableO.getColumnModel().getColumn(2).setPreferredWidth(70);
    }

    public JPanel getPanelLateralOper() {
        return this.panelLateralOper;
    }
    
    public JLabel getTituloTablaO() {
        return this.tituloTablaO;
    }

    public JScrollPane getTablaOperaciones() {
        return this.tablaGestion;
    }


}
