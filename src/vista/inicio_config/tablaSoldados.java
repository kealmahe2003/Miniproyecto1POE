package vista.inicio_config;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class tablaSoldados {

    private JLabel tituloTabla = new JLabel("LISTA DE SOLDADOS");
    private DefaultTableModel modelo = new DefaultTableModel(
            new Object[][]{}, // Datos de la tabla
            new String[]{"Nombre", "ID", "Rango"} // Encabezados de columna
    );
    private JTable table = new JTable(modelo);
    private JScrollPane tablaDeSoldados = new JScrollPane(table);
    private JPanel panelLateral = new JPanel();

    public tablaSoldados() {
        this.mostrarTituloTabla();
        this.mostrarTablaSoldados();
        this.mostrarPanelLateral();
    }

    private void mostrarPanelLateral() {
        panelLateral.setBounds(0, 0, 350, 680);
        panelLateral.setLayout(null);
        panelLateral.setBackground(Color.DARK_GRAY);
    }

    private void mostrarTituloTabla() {
        tituloTabla.setBounds(20, 60, 300, 30);
        tituloTabla.setForeground(Color.white);
        tituloTabla.setFont(new Font("Arial", Font.BOLD, 16));
        tituloTabla.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void mostrarTablaSoldados() {
        tablaDeSoldados.setBounds(10, 90, 330, 450);
        table.getTableHeader().setResizingAllowed(false);
        table.getColumnModel().getColumn(0).setPreferredWidth(120);
        table.getColumnModel().getColumn(1).setPreferredWidth(40);
        table.getColumnModel().getColumn(2).setPreferredWidth(70);
    }

    public JPanel getPanelLateral() {
        return this.panelLateral;
    }

    public JLabel getTituloTabla() {
        return this.tituloTabla;
    }

    public JScrollPane getTablaSoldados() {
        return this.tablaDeSoldados;
    }

    public JTable getTable() {
        return this.table;
    }

    public DefaultTableModel getTableModelo() {
        return this.modelo;
    }

}
