/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Singleton;

import java.util.ArrayList;
import observador.SubjectRevista;

/**
 *
 * @author Juan Camilo Mesa, Simon Sanmiguel.
 */
public class EstanteriaRevistas {

    private static EstanteriaRevistas instance;
    private ArrayList<SubjectRevista> revistas;

    private EstanteriaRevistas() {
        revistas = new ArrayList<SubjectRevista>();
    }

    public static EstanteriaRevistas getInstance() {
        if (instance == null) {
            instance = new EstanteriaRevistas();
        }
        return instance;
    }

    public void addRevista(SubjectRevista revista) {
        revistas.add(revista);
    }

    public ArrayList<SubjectRevista> getRevistas() {
        return revistas;
    }
    
    public void deleteRevista(SubjectRevista revista){
        revistas.remove(revista);
    }
}
