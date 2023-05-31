/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Singleton;

import java.util.ArrayList;
import observador.SubjectLibro;

/**
 *
 * @author Juan Camilo Mesa, Simon Sanmiguel.
 */
public class EstanteriaLibros {

    private static EstanteriaLibros instance;
    private ArrayList<SubjectLibro> libros;

    private EstanteriaLibros() {
        libros = new ArrayList<SubjectLibro>();
    }

    public static EstanteriaLibros getInstance() {
        if (instance == null) {
            instance = new EstanteriaLibros();
        }
        return instance;
    }

    public void addLibro(SubjectLibro libro) {
        libros.add(libro);
    }

    public ArrayList<SubjectLibro> getLibros() {
        return libros;
    }
    
    public void deleteLibro(SubjectLibro libro){
        libros.remove(libro);
    }
}
