import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import militar.rangos.Capitan;
import militar.rangos.Coronel;
import militar.rangos.SoldadoRaso;
import militar.rangos.Teniente;
import militar.soldados.Soldado;

public class Consola {

    private static final Scanner scanner = new Scanner(System.in);

    private static final List<Soldado> soldados = new ArrayList<>();
    private static final List<Teniente> tenientes = new ArrayList<>();
    private static final List<Capitan> capitanes = new ArrayList<>();
    private static final List<Coronel> coroneles = new ArrayList<>();


    public Consola() {

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
        
        if (buscarID(id) != null) {
            System.out.println("Ya existe un soldado con este ID.");
            return;
        }


        
        String rango = "Soldado Raso";
        SoldadoRaso soldadoRaso = new SoldadoRaso(nombre, id);
        soldados.add(soldadoRaso);
    
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
    
            System.out.println("Ingrese el nuevo rango del soldado(o presione Enter para no cambiar):");
            String nuevoRango = scanner.nextLine();
            if (!nuevoRango.isEmpty()){
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
                        soldado.mostrarInformacion();
    
                        String rango = soldado.getRango();
                        if (rango.equals("Soldado Raso")) {
                            System.out.println("El Soldado Raso no puede recibir misiones directamente.");
                        } else {
                            if(rango.equals("Teniente")){
                                System.out.println("Ingrese la unidad a la que pertenece:");
                                String unidad = scanner.nextLine();
                                Teniente teniente = new Teniente(unidad);
                                System.out.println("Ingrese la mision que se le va a asignar:");
                                String mision = scanner.nextLine();
                                teniente.asignarMision(mision);
                                tenientes.add(teniente);
                                System.out.println("Misión asignada.");
                            }

                            if(rango.equals("Capitan")){
                                System.out.println("Ingrese la cantidad de soldados a su mando:");
                                String cantidadSoldados = scanner.nextLine();
                                int cantidadSoldadosBajoSuMando = Integer.parseInt(cantidadSoldados);
                                Capitan capitan = new Capitan(cantidadSoldadosBajoSuMando);
                                System.out.println("Ingrese la mision a la que va a asignar la estrategia:");
                                String mision = scanner.nextLine();
                                capitan.asignarMision(mision);
                                capitanes.add(capitan);
                                System.out.println("Misión asignada.");
                            }

                            if(rango.equals("Coronel")){
                                System.out.println("Ingrese la estrategia que va a implementar:");
                                String estrategia = scanner.nextLine();
                                Coronel coronel = new Coronel(estrategia);
                                coronel.realizarAccion();
                                System.out.println("Ingrese la mision a la que va a asignar la estrategia:");
                                String mision = scanner.nextLine();
                                coronel.asignarMision(mision);
                                coroneles.add(coronel);
                                System.out.println("Misión asignada.");
                            }
                        }
                    } else {
                        System.out.println("Soldado no encontrado.");
                    }
                }
    
                case 2 -> {
                    System.out.println("Ingrese la id del soldado para ver su estado: ");
                    String id = scanner.nextLine();
                    Soldado soldado = buscarID(id);
                    soldado.mostrarInformacion();
                    if (soldado != null) {
                        String rango = soldado.getRango();
                        System.out.println(soldado.getRango());
                        if (rango.equals("Soldado Raso")){
                            SoldadoRaso raso = (SoldadoRaso) soldado;
                            raso.reportarEstado();
                        }
                        if (rango.equals("Teniente")){
                            Teniente teniente = tenientes.get(0);
                            teniente.reportarEstado();
                        }
                        if (rango.equals("Capitan")){
                            Capitan capitan = capitanes.get(0);
                            capitan.reportarEstado();
                        }
                        if (rango.equals("Coronel")){
                            Coronel coronel = coroneles.get(0);
                            coronel.reportarEstado();
                        }
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