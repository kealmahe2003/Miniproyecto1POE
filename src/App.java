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
            System.out.println("5. Gestionar operaciones militares");
            System.out.println("0. Salir del sistema");
            System.out.println("----------------------------------------");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> agregarSoldado();

                case 2 -> modificarSoldado();
                
                case 3 -> eliminarSoldado();

                case 4 -> listaSoldados();

                case 5 -> gestionarOperacionesMilitares();

                case 0 -> {
                    System.out.println("Saliendo...");
                    a = false;
                }

                default -> System.out.println("Opcion invalida");
            }
        }
    }
        
    public static void agregarSoldado() {
        System.out.println("----------------------------------------");
        System.out.println("Ingrese el nombre del soldado:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el ID: ");
        String id = scanner.nextLine();
        
        // Verificar si ya existe un soldado con el mismo ID
        if (buscarID(id) != null) {
            System.out.println("Ya existe un soldado con este ID.");
            return;
        }
        
        String rango = "Soldado Raso";
        Soldado soldado = new Soldado(nombre, id, rango);
        soldados.add(soldado);
    
        System.out.println("----------------------------------------");
        System.out.println("Soldado agregado exitosamente");
        System.out.println("----------------------------------------");
    }
    
    
    public static void modificarSoldado() {
        System.out.println("Ingrese la id del soldado: ");
        String id = scanner.nextLine();
        Soldado soldado = buscarID(id);
    
        if (soldado != null) {
            System.out.println("Soldado encontrado:");
            soldado.mostrarInformacion();
            
            System.out.println("Ingrese el nuevo nombre del soldado (o presione Enter para no cambiar):");
            String nuevoNombre = scanner.nextLine();
            if (!nuevoNombre.isEmpty()) {
                soldado.setNombre(nuevoNombre);
            }
    
            System.out.println("Ingrese el nuevo rango del soldado (o presione Enter para no cambiar):");
            String nuevoRango = scanner.nextLine();
            if (!nuevoRango.isEmpty()) {
                soldado.setRango(nuevoRango);
            }
    
            System.out.println("----------------------------------------");
            System.out.println("Soldado modificado exitosamente");
            System.out.println("----------------------------------------");
    
        } else {
            System.out.println("Id no encontrada");
        }
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
            System.out.println("---------------------------------------");
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

    public static void gestionarOperacionesMilitares() {
        boolean gestionando = true;
        while (gestionando) {
            System.out.println("----------------------------------------");
            System.out.println("Gestión de Operaciones Militares");
            System.out.println("1. Asignar misión a un soldado");
            System.out.println("2. Ver estado del soldado");
            System.out.println("0. Volver al menú principal");
            System.out.println("----------------------------------------");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Ingrese la id del soldado: ");
                    String id = scanner.nextLine();
                    Soldado soldado = buscarID(id);
                    if (soldado != null) {
                        System.out.println("Soldado encontrado:");
                        soldado.mostrarInformacion(); // Mostrar la información del soldado
    
                        // Verificar el rango del soldado
                        String rango = soldado.getRango();
                        if (rango.equals("Soldado Raso")) {
                            System.out.println("El Soldado Raso no puede recibir misiones directamente.");
                        } else {
                            System.out.println("Ingrese la misión que le va a asignar:");
                            String mision = scanner.nextLine();
                            //soldado.asignarMision(mision); // Asignar la misión si el rango es adecuado
                            System.out.println("Misión asignada.");
                        }
                    } else {
                        System.out.println("Soldado no encontrado.");
                    }
                }
    
                case 2 -> {
                    System.out.println("Ingrese la id del soldado para ver su estado: ");
                    String id = scanner.nextLine();
                    Soldado soldado = buscarID(id);
                    if (soldado != null) {
                        //soldado.reportarEstado(); // Reportar el estado del soldado
                    } else {
                        System.out.println("Soldado no encontrado.");
                    }
                }
    
                case 0 -> gestionando = false;
    
                default -> System.out.println("Opción inválida.");
            }
        }
    }
}