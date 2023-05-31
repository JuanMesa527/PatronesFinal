/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observador;

import java.util.ArrayList;

/**
 *
 * @author Juan Camilo Mesa, Simon Sanmiguel.
 */
public class SubjectLibro implements ISubject {

    //Declarar estructura para manejar suscriptores
    private ArrayList<Observer> observerListLibro;
    private String titulo;
    private int id;
    private boolean disponibilidad;

    public SubjectLibro(String titulo, int id, boolean disponibilidad) {
        observerListLibro = new ArrayList<>();
        this.titulo = titulo;
        this.id = id;
        this.disponibilidad = disponibilidad;
    }

    @Override
    public void register(Observer ob) {
        observerListLibro.add(ob);
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observerListLibro.size(); i++) {
            observerListLibro.get(i).update();
        }
    }

    public int getId() {
        return id;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Libro{" + "titulo=" + titulo + ", id=" + id + ", disponibilidad=" + disponibilidad + '}';
    }
}
