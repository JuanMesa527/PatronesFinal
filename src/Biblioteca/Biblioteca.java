/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Biblioteca;

import Proxy.*;
import java.util.Scanner;
import observador.*;

/**
 *
 * @author Juan Camilo Mesa, Simon Sanmiguel.
 */
public class Biblioteca {

    static Scanner sc = new Scanner(System.in);

    public static int pregunta() {
        System.out.println("libro o revista?\n"
                + "1. libro\n"
                + "2. revista");
        int res;
        return res = sc.nextInt();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ThirdPartyLib service = new ThirdPartyLibClass();
        CachedLibClass proxy = new CachedLibClass(service);

        System.out.println("Bienvenido a la biblioteca\n");
        while (true) {
            System.out.println("seleccione una opcion a continuacion: \n"
                    + "1. ingresar o eliminar libros/revistas\n"
                    + "2. listar libros/revistas en la biblioteca\n"
                    + "3. buscar libros/revistas\n"
                    + "4. ingresar, eliminar y listar miembros de la biblioteca\n"
                    + "5. solicitar prestamo libro/revista\n"
                    + "6. hacer reserva de un libro/revista\n"
                    + "7. devolver un libro/revista\n"
                    + "8. comprobar disponibilidad libro/revista\n"
                    + "9. salir");
            int opcion;
            switch (opcion = sc.nextInt()) {
                case 1:
                    if (pregunta() == 1) {
                        System.out.println("1. ingresar\n"
                                + "2. eliminar");
                        switch (opcion = sc.nextInt()) {
                            case 1:
                                sc.nextLine();
                                System.out.println("ingrese titulo, id, disponibilidad separado por espacios");
                                String datos[] = sc.nextLine().split(" ");
                                SubjectLibro libro = new SubjectLibro(datos[0], Integer.parseInt(datos[1]), Boolean.parseBoolean(datos[2]));
                                proxy.addLibro(libro);
                                break;
                            case 2:
                                System.out.println("ingrese el id del libro a eliminar:");
                                int id = sc.nextInt();
                                proxy.deleteLibro(id);
                                break;
                            default:
                                System.out.println("opcion no valida");
                        }
                    } else {
                        System.out.println("1. ingresar\n"
                                + "2. eliminar\n");
                        switch (opcion = sc.nextInt()) {
                            case 1:
                                sc.nextLine();
                                System.out.println("ingrese titulo, id, disponibilidad separado por espacios");
                                String datos[] = sc.nextLine().split(" ");
                                SubjectRevista revista = new SubjectRevista(datos[0], Integer.parseInt(datos[1]), Boolean.parseBoolean(datos[2]));
                                proxy.addRevista(revista);
                                break;
                            case 2:
                                System.out.println("ingrese el id de la revista a eliminar:");
                                int id = sc.nextInt();
                                proxy.deleteRevista(id);
                                break;
                            default:
                                System.out.println("opcion no valida");
                        }
                    }
                    break;
                case 2:
                    System.out.println("libros: ");
                    proxy.listLibros();
                    System.out.println("revistas: ");
                    proxy.listRevistas();
                    break;
                case 3:
                    System.out.println("ingrese el id a buscar: ");
                    int id = sc.nextInt();
                    if (pregunta() == 1) {
                        System.out.println(proxy.getLibroInfo(id));
                    } else {
                        System.out.println(proxy.getRevistaInfo(id));
                    }
                    break;
                case 4:
                    System.out.println("1. ingresar\n"
                            + "2. eliminar\n"
                            + "3. listar");
                    switch (opcion = sc.nextInt()) {
                        case 1:
                            sc.nextLine();
                            System.out.println("ingrese nombre, id, rol y correo electronico separado por espacios");
                            String datos[] = sc.nextLine().split(" ");
                            Observer miembro = new Observer(datos[0], Integer.parseInt(datos[1]), datos[2], datos[3]);
                            proxy.addMiembro(miembro);
                            break;
                        case 2:
                            System.out.println("ingrese el id del miembro a eliminar:");
                            id = sc.nextInt();
                            proxy.deleteMiembro(id);
                            break;
                        case 3:
                            System.out.println("lista de miembros: ");
                            proxy.listMiembros();
                            break;
                        default:
                            System.out.println("opcion no valida");
                    }
                    break;
                case 5:
                    System.out.println("ingrese su id: ");
                    id = sc.nextInt();
                    switch (proxy.getMiembroRol(id).toLowerCase()) {
                        case "socio":
                            System.out.println("su rol es socio, es decir que unicamente puede solicitar el prestamo de libros\n"
                                    + "la siguiente es la lista de libros: ");
                            proxy.listLibros();
                            System.out.println("ingrese el id del libro a solicitar: ");
                            id = sc.nextInt();
                            if (proxy.getLibroInfo(id).contains("true")) {
                                proxy.cambiarDispLibro(id);
                                System.out.println("usted recibio el libro y tiene un plazo de 3 semanas de prestamo");
                            } else {
                                System.out.println("el libro que busca no existe o no tenemos disponibilidad, dado el caso intente hacer una reserva");
                            }
                            break;
                        case "vip":
                            System.out.println("su rol es vip, es decir que puede solicitar el prestamo de libros y revistas\n"
                                    + "la siguiente es la lista de libros: ");
                            proxy.listLibros();
                            System.out.println("y esta la lista de revistas: ");
                            proxy.listRevistas();
                            if (pregunta() == 1) {
                                System.out.println("ingrese el id del libro a solicitar: ");
                                id = sc.nextInt();
                                if (proxy.getLibroInfo(id).contains("true")) {
                                    proxy.cambiarDispLibro(id);
                                    System.out.println("usted recibio el libro y tiene un plazo de 3 semanas de prestamo");
                                } else {
                                    System.out.println("el libro que busca no existe o no tenemos disponibilidad, dado el caso intente hacer una reserva");
                                }
                            } else {
                                System.out.println("ingrese el id de la revista a solicitar: ");
                                id = sc.nextInt();
                                if (proxy.getRevistaInfo(id).contains("true")) {
                                    proxy.cambiarDispRevista(id);
                                    System.out.println("usted recibio la revista y tiene un plazo de 3 semanas de prestamo");
                                } else {
                                    System.out.println("la revista que busca no existe o no tenemos disponibilidad, dado el caso intente hacer una reserva");
                                }
                            }
                            break;
                        default:
                            System.out.println("hay un problema con el miembro, no se puede comprobar su rol o no existe");
                    }
                    break;
                case 6:
                    System.out.println("Ingrese su ID: ");
                    int idMiembro = sc.nextInt();
                    switch (proxy.getMiembroRol(idMiembro).toLowerCase()) {
                        case "socio":
                            System.out.println("su rol es socio, es decir que unicamente puede reservar libros\n"
                                    + "la siguiente es la lista de libros: ");
                            proxy.listLibros();
                            System.out.println("ingrese el id del libro a reservar: ");
                            id = sc.nextInt();
                            if (proxy.getLibroInfo(id).contains("true")) {
                                System.out.println("El libro ya está disponible. No es necesario hacer una reserva.");
                            } else {
                                System.out.println(proxy.reservarLib(id, idMiembro));
                            }
                            break;
                        case "vip":
                            System.out.println("su rol es vip, es decir que puede reservar libros y revistas\n"
                                    + "la siguiente es la lista de libros: ");
                            proxy.listLibros();
                            System.out.println("y esta la lista de revistas: ");
                            proxy.listRevistas();
                            if (pregunta() == 1) {
                                System.out.println("ingrese el id del libro a reservar: ");
                                id = sc.nextInt();
                                if (proxy.getLibroInfo(id).contains("true")) {
                                    System.out.println("El libro ya está disponible. No es necesario hacer una reserva.");
                                } else {
                                    System.out.println(proxy.reservarRev(id, idMiembro));
                                }
                            } else {
                                System.out.println("ingrese el id de la revista a solicitar: ");
                                id = sc.nextInt();
                                if (proxy.getRevistaInfo(id).contains("true")) {
                                    System.out.println("La revista ya está disponible. No es necesario hacer una reserva.");
                                } else {
                                    System.out.println(proxy.reservarRev(id, idMiembro));
                                }
                            }
                            break;
                        default:
                            System.out.println("Hay un problema con el miembro. No se puede comprobar su rol o no existe.");
                    }
                    break;
                case 7:
                    System.out.println("Ingrese su ID: ");
                    idMiembro = sc.nextInt();
                    switch (proxy.getMiembroRol(idMiembro).toLowerCase()) {
                        case "socio":
                            System.out.println("Usted es socio con lo cual solo podra devolver libros");
                            System.out.println("Ingrese el ID del libro a devolver: ");
                            id = sc.nextInt();
                            if (proxy.getLibroInfo(id).contains("false")) {
                                proxy.cambiarDispLibro(id);
                                System.out.println("Se ha devuelto el libro a la biblioteca");
                                System.out.println(proxy.notificar(idMiembro));
                            } else {
                                System.out.println("El libro todavia esta en la biblioteca!");
                            }
                            break;
                        case "vip":
                            System.out.println("Usted es vip con lo cual podra devolver libros y revistas!");
                            if (pregunta() == 1) {
                                System.out.println("Ingrese el ID del libro a devolver: ");
                                id = sc.nextInt();
                                if (proxy.getLibroInfo(id).contains("false")) {
                                    proxy.cambiarDispLibro(id);
                                    System.out.println("Se ha devuelto el libro a la biblioteca");
                                    System.out.println(proxy.notificar(idMiembro));
                                } else {
                                    System.out.println("El libro todavia esta en la biblioteca!");
                                }
                            } else {
                                System.out.println("Ingrese el ID de la  revista a devolver: ");
                            }
                            id = sc.nextInt();
                            if (proxy.getRevistaInfo(id).contains("false")) {
                                proxy.cambiarDispLibro(id);
                                System.out.println("Se ha devuelto la revista a la biblioteca");
                                System.out.println(proxy.notificar(idMiembro));
                            } else {
                                System.out.println("La revista todavia esta en la biblioteca!");
                            }
                    }
                    break;
                case 8:
                    System.out.println("Ingrese el id del libro/revista que desea buscar: ");
                    id = sc.nextInt();
                    if (proxy.getLibroInfo(id).contains("true")) {
                        System.out.println("Hay disponiblidad de " + proxy.getLibroInfo(id));
                    } else if (proxy.getRevistaInfo(id).contains("true")) {
                        System.out.println("Hay disponiblidad de " + proxy.getRevistaInfo(id));
                    }
                    else {
                        System.out.println("No hay disponibilidad en estos momnetos de la revista con id: " + id);
                    }
                    break;
                case 9:
                    System.exit(0);
                default:
                    System.out.println("opcion no valida, intente nuevamente...\n");
            }
        }
    }
}
