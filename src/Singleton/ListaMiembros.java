/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Singleton;

import java.util.ArrayList;
import observador.Observer;

/**
 *
 * @author Juan Camilo Mesa, Simon Sanmiguel.
 */
public class ListaMiembros {
    private static ListaMiembros instance;
    private ArrayList<Observer> miembros;

    private ListaMiembros() {
        miembros = new ArrayList<Observer>();
    }

    public static ListaMiembros getInstance() {
        if (instance == null) {
            instance = new ListaMiembros();
        }
        return instance;
    }

    public void addMiembro(Observer miembro) {
        miembros.add(miembro);
    }

    public ArrayList<Observer> getMiembros() {
        return miembros;
    }
    
    public void deleteMiembro(Observer miembro){
        miembros.remove(miembro);
    }
}
