/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Proxy;

import observador.*;

/**
 *
 * @author Juan Camilo Mesa, Simon Sanmiguel.
 */
public interface ThirdPartyLib {
     public void addLibro(SubjectLibro libro);
    public void addRevista(SubjectRevista revista);
    public void addMiembro(Observer miembro);
    public void deleteLibro(int id);
    public void deleteRevista(int id);
    public void deleteMiembro(int id);
    public void listLibros();
    public void listRevistas();
    public void listMiembros();
    public String getLibroInfo(int id);
    public String getRevistaInfo(int id);
    public String getMiembroRol(int id);
    public boolean cambiarDispLibro(int id);
    public boolean cambiarDispRevista(int id);
    public String reservarLib(int id, int idMiembro);
    public String reservarRev(int id, int idMiembro);
    public String notificar(int id);
}