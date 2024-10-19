import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import militar.rangos.Capitan;
import militar.rangos.Coronel;
import militar.soldados.Soldado;

public class App {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Soldado> soldados = new ArrayList<>();
    public static void main(String[] args) throws Exception{

        Capitan capitan = new Capitan(10);
        capitan.asignarMision("Romper dique");
        capitan.reportarEstado();
        Coronel coronel = new Coronel("gays");
        coronel.asignarMision("matar heteros");
        coronel.reportarEstado();
        boolean a = true;
        while (a) {
            int opcion;
            System.out.println("----------------------------------------");
            System.out.println("Sistema de Gestión de Rangos Militares");
            System.out.println("----------------------------------------");
            System.out.println("Bienvenido");
            System.out.println("----------------------------------------");
            System.out.println("1. Agregar soldado");
            System.out.println("2. Modificar soldado");
            System.out.println("3. Eliminar soldado");
            System.out.println("4. Ver lista de soldados");
            System.out.println("0. Salir del sistema");
            System.out.println("----------------------------------------");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> agregarSoldado();

                case 2 -> modificarSoldado();
                
                case 3 -> eliminarSoldado();

                case 4 -> listaSoldados();

                case 0 -> {
                    System.out.println("Saliendo...");
                    a = false;
                }

                default -> System.out.println("Opcion invalida");
            }
        }
    }
        
    public static void agregarSoldado(){
        System.out.println("----------------------------------------");
        System.out.println("Ingrese el nombre del soldado:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el ID: ");
        String id = scanner.nextLine();
        String rango = "Soldado Raso";
        Soldado soldado = new Soldado(nombre, id, rango);
        soldados.add(soldado);

        System.out.println("----------------------------------------");
        System.out.println("Soldado agregado exitosamente");
        System.out.println("----------------------------------------");
    }
    
    
    public static void modificarSoldado(){
        
    }

    public static void eliminarSoldado(){
        System.out.println("Ingrese la id para eliminarlo: ");
        String id = scanner.nextLine();
        Soldado soldado = buscarID(id);

        if(soldado != null){
            
            soldados.remove(soldado);
            System.out.println("Soldado eliminado");

        }else{
            System.out.println("Id no encontrada");
        }
    }

    public static void listaSoldados(){

        System.out.println("Soldados activos:");
        for(Soldado soldado : soldados){
            soldado.mostrarInformacion();
            System.out.println("-" + 100);
        }

    }

    private static Soldado buscarID(String id){
        for (Soldado soldado : soldados){
            if(soldado.getId().equals(id)){
               return soldado; 
            }
        }
        return null;
    }
}
