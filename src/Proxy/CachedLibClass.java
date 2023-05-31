/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proxy;

import observador.*;

/**
 *
 * @author Juan Camilo Mesa, Simon Sanmiguel.
 */
public class CachedLibClass implements ThirdPartyLib {

    private ThirdPartyLib service;

    public CachedLibClass(ThirdPartyLib service) {
        this.service = service;
    }

    @Override
    public void listLibros() {
        if (service == null) {
            service = new ThirdPartyLibClass();
        }
        service.listLibros();
    }

    @Override
    public void listRevistas() {
        if (service == null) {
            service = new ThirdPartyLibClass();
        }
        service.listRevistas();
    }

    @Override
    public String getLibroInfo(int id) {
        if (service == null) {
            service = new ThirdPartyLibClass();
        }
        return service.getLibroInfo(id);
    }

    @Override
    public String getRevistaInfo(int id) {
        if (service == null) {
            service = new ThirdPartyLibClass();
        }
        return service.getRevistaInfo(id);
    }

    @Override
    public void addLibro(SubjectLibro libro) {
        if (service == null) {
            service = new ThirdPartyLibClass();
        }
        service.addLibro(libro);
    }

    @Override
    public void addRevista(SubjectRevista revista) {
        if (service == null) {
            service = new ThirdPartyLibClass();
        }
        service.addRevista(revista);
    }

    @Override
    public void deleteLibro(int id) {
        if (service == null) {
            service = new ThirdPartyLibClass();
        }
        service.deleteLibro(id);
    }

    @Override
    public void deleteRevista(int id) {
        if (service == null) {
            service = new ThirdPartyLibClass();
        }
        service.deleteRevista(id);
    }

    @Override
    public void addMiembro(Observer miembro) {
        if (service == null) {
            service = new ThirdPartyLibClass();
        }
        service.addMiembro(miembro);
    }

    @Override
    public void deleteMiembro(int id) {
        if (service == null) {
            service = new ThirdPartyLibClass();
        }
        service.deleteMiembro(id);
    }

    @Override
    public void listMiembros() {
        if (service == null) {
            service = new ThirdPartyLibClass();
        }
        service.listMiembros();
    }

    @Override
    public String getMiembroRol(int id) {
        if (service == null) {
            service = new ThirdPartyLibClass();
        }
        return service.getMiembroRol(id);
    }

    @Override
    public boolean cambiarDispLibro(int id) {
        if (service == null) {
            service = new ThirdPartyLibClass();
        }
        return service.cambiarDispLibro(id);
    }

    @Override
    public boolean cambiarDispRevista(int id) {
        if (service == null) {
            service = new ThirdPartyLibClass();
        }
        return service.cambiarDispRevista(id);
    }

    @Override
    public String reservarLib(int id, int idMiembro) {
        if (service == null) {
            service = new ThirdPartyLibClass();
        }
        return service.reservarLib(id,idMiembro);
    }

    @Override
    public String reservarRev(int id, int idMiembro) {
        if (service == null) {
            service = new ThirdPartyLibClass();
        }
        return service.reservarRev(id, idMiembro);
    }

    @Override
    public String notificar(int id) {
        if (service == null) {
            service = new ThirdPartyLibClass();
        }
        return service.notificar(id);
    }

}
