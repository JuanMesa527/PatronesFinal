/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proxy;

import Decorador.*;
import Singleton.*;
import observador.*;

/**
 *
 * @author Juan Camilo Mesa, Simon Sanmiguel.
 */
public class ThirdPartyLibClass implements ThirdPartyLib {

    @Override
    public void listLibros() {
        for (SubjectLibro x : EstanteriaLibros.getInstance().getLibros()) {
            System.out.println(x);
        }
    }

    @Override
    public void listRevistas() {
        for (SubjectRevista x : EstanteriaRevistas.getInstance().getRevistas()) {
            System.out.println(x);
        }
    }

    @Override
    public String getLibroInfo(int id) {
        for (SubjectLibro x : EstanteriaLibros.getInstance().getLibros()) {
            if (x.getId() == id) {
                return x.toString();
            }
        }
        return "El libro con id " + id + " no se encuentra en nuestro catalogo.";
    }

    @Override
    public String getRevistaInfo(int id) {
        for (SubjectRevista x : EstanteriaRevistas.getInstance().getRevistas()) {
            if (x.getId() == id) {
                return x.toString();
            }
        }
        return "La revista con id " + id + " no se encuentra en nuestro catalogo.";
    }

    @Override
    public void addLibro(SubjectLibro libro) {
        EstanteriaLibros.getInstance().addLibro(libro);
    }

    @Override
    public void addRevista(SubjectRevista revista) {
        EstanteriaRevistas.getInstance().addRevista(revista);
    }

    @Override
    public void deleteLibro(int id) {
        for (SubjectLibro x : EstanteriaLibros.getInstance().getLibros()) {
            if (x.getId() == id) {
                EstanteriaLibros.getInstance().deleteLibro(x);
                System.out.println("se elimino el libro: " + x.toString());
                return;
            }
        }
        System.out.println("El libro con id " + id + " no se encuentra en nuestro catalogo.");
    }

    @Override
    public void deleteRevista(int id) {
        for (SubjectRevista x : EstanteriaRevistas.getInstance().getRevistas()) {
            if (x.getId() == id) {
                EstanteriaRevistas.getInstance().deleteRevista(x);
                System.out.println("se elimino la revista: " + x.toString());
                return;
            }
        }
        System.out.println("La revista con id " + id + " no se encuentra en nuestro catalogo.");
    }

    @Override
    public void addMiembro(Observer miembro) {
        ListaMiembros.getInstance().addMiembro(miembro);
    }

    @Override
    public void deleteMiembro(int id) {
        for (Observer x : ListaMiembros.getInstance().getMiembros()) {
            if (x.getId() == id) {
                ListaMiembros.getInstance().deleteMiembro(x);
                System.out.println("se elimino el miembro: " + x.toString());
                return;
            }
        }
        System.out.println("El miembro con id " + id + " no es parte de la biblioteca.");
    }

    @Override
    public void listMiembros() {
        for (Observer x : ListaMiembros.getInstance().getMiembros()) {
            System.out.println(x);
        }
    }

    @Override
    public String getMiembroRol(int id) {
        for (Observer x : ListaMiembros.getInstance().getMiembros()) {
            if (x.getId() == id) {
                return x.getRol();
            }
        }
        return "El miembro con id " + id + " no es parte de la biblioteca.";
    }

    @Override
    public boolean cambiarDispLibro(int id) {
        for (SubjectLibro x : EstanteriaLibros.getInstance().getLibros()) {
            if (x.getId() == id) {
                if (x.isDisponibilidad()) {
                    x.setDisponibilidad(false);
                } else {
                    x.setDisponibilidad(true);
                }
                return x.isDisponibilidad();
            }
        }
        System.out.println("El libro con id " + id + " no se encuentra en nuestro catalogo.");
        return false;
    }

    @Override
    public boolean cambiarDispRevista(int id) {
        for (SubjectRevista x : EstanteriaRevistas.getInstance().getRevistas()) {
            if (x.getId() == id) {
                x.setDisponibilidad(false);
                return x.isDisponibilidad();
            }
        }
        System.out.println("La revista con id " + id + " no se encuentra en nuestro catalogo.");
        return false;
    }

    @Override
    public String reservarLib(int id, int idMiembro) {
        Observer ob = null;
        for (Observer x : ListaMiembros.getInstance().getMiembros()) {
            if (x.getId() == idMiembro) {
                ob = x;
            }
        }
        for (SubjectLibro x : EstanteriaLibros.getInstance().getLibros()) {
            if (x.getId() == id) {
                x.register(ob);
                return "reserva registrada";
            }
        }
        return "El libro con id " + id + " no se encuentra en nuestro catalogo o El miembro con id " + idMiembro + " no es parte de la biblioteca.";
    }

    @Override
    public String reservarRev(int id, int idMiembro) {
        Observer ob = null;
        for (Observer x : ListaMiembros.getInstance().getMiembros()) {
            if (x.getId() == idMiembro) {
                ob = x;
            }
        }
        for (SubjectRevista x : EstanteriaRevistas.getInstance().getRevistas()) {
            if (x.getId() == id) {
                x.register(ob);
                return "reserva registrada";
            }
        }
        return "La revista con id " + id + " no se encuentra en nuestro catalogo o El miembro con id " + idMiembro + " no es parte de la biblioteca.";
    }

    @Override
    public String notificar(int id) {
        String medio="";
        for (Observer x : ListaMiembros.getInstance().getMiembros()) {
            if (x.getId() == id) {
                medio=x.getMedio();
            }
        }
        ConcreteComponent notificacion = new ConcreteComponent();
        notificacion.notificar(medio);
        ConcreteDecoratorEmail email = new ConcreteDecoratorEmail();
        email.setComponente(notificacion);
        return email.notificar(medio);
    }

}
