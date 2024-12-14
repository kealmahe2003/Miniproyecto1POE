import controlador.ControladorM;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;





public class App {
    
    ControladorM controlador = new ControladorM();
    public static void main(String[] args) {
        try {
            // Look and feel
            // Se coloca el look and feel del sistema operativo en el que se esta ejecutando el programa
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        // Instanciar el modelo
        ControladorM controlador = new ControladorM();
        
        // Obtener la vista desde el controlador y hacerla visible
        controlador.obtenerVistaGui().setVisible(true);
    }
    }
