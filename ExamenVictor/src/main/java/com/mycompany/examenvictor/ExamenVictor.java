/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.examenvictor;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author enriq
 */
public class ExamenVictor {

       public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> tareas = new ArrayList<>(); // Lista para almacenar las tareas
        int opcion;
        
        do {
            System.out.println("=== Gestor de Tareas Pendientes ===");
            System.out.println("1. Agregar Tarea");
            System.out.println("2. Eliminar Tarea");
            System.out.println("3. Consultar Tarea");
            System.out.println("4. Mostrar Todas las Tareas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            
            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer
                
                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese la descripcion de la tarea: ");
                        String tarea = scanner.nextLine();
                        if (!tarea.matches(".*[a-zA-Z].*")) { // Verificamos que contenga al menos una letra
                            System.out.println("Error: La descripcion debe contener al menos una letra.");
                        } else {
                            tareas.add(tarea);
                            System.out.println("Tarea agregada correctamente.");
                        }
                        break;
                    
                    case 2:
                        System.out.print("Ingrese el indice de la tarea a eliminar(si desconoce los indices consulte la opcion 4): ");
                        try {
                            int indiceEliminar = scanner.nextInt();
                            scanner.nextLine();
                            tareas.remove(indiceEliminar);
                            System.out.println("Tarea eliminda correctamente.");
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Error: Indice fuera de rango.");
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Debe ingresar un número valido.");
                            scanner.nextLine(); // Limpiar buffer
                        }
                        break;
                    
                    case 3:
                        System.out.print("Ingrese el indice de la tarea a consultar(si desconoce los indices consulte la opcion 4): ");
                        try {
                            int indiceConsultar = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Tarea en indice " + indiceConsultar + ": " + tareas.get(indiceConsultar));
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Error: Indice fuera de rango.");
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Debe ingresar un número valido.");
                            scanner.nextLine(); // Limpiar buffer
                        }
                        break;
                    
                    case 4:
                        if (tareas.isEmpty()) {
                            System.out.println("No hay tareas en la lista.");
                        } else {
                            System.out.println("Lista de tareas:");
                            for (int i = 0; i < tareas.size(); i++) {
                                System.out.println(i + ". " + tareas.get(i));
                            }
                        }
                        break;
                    
                    case 5:
                        System.out.println("Saliendo del programa...");
                        break;
                    
                    default:
                        System.out.println("Opción no valida. Intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número valido.");
                scanner.nextLine(); // Limpiar buffer para evitar bucle infinito
                opcion = 0; // Evitar salida del bucle por error
            }
        } while (opcion != 5);
        
        scanner.close();
    }
}