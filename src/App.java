import java.util.Scanner;

import militar.soldados.Soldado;

public class App {

    private static Scanner scanner= new Scanner(System.in);
    
    public static void main(String[] args) throws Exception{

        boolean a = true;
        while (a) {
            int opcion = 0;
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
            switch (opcion) {
                case 1:
                    agregarSoldado();
                    break;

                case 2:

                    break;
                case 0:
                    a = false;
                    break;
                default:
                    break;
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

        System.out.println("----------------------------------------");
        System.out.println("Soldado agregado exitosamente");
        System.out.println("----------------------------------------");
    }
}
