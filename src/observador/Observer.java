/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observador;

/**
 *
 * @author Juan Camilo Mesa, Simon Sanmiguel.
 */
public class Observer {

    private String nombre;
    private int id;
    private String rol;
    private String medio;

    public Observer(String nombre, int id, String rol, String medio) {
        this.nombre = nombre;
        this.id = id;
        this.rol = rol;
        this.medio = medio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMedio() {
        return medio;
    }

    public int getId() {
        return id;
    }

    public String getRol() {
        return rol;
    }

    public void update() {
        System.out.println("Estimado " + getNombre() + " nos comunicamos con usted mediante " + getMedio() + " \n"
                + "para informarle que la la disponibilidad libro/revista que reservo cambio, revise la lista");
    }

    @Override
    public String toString() {
        return "Observer{" + "nombre=" + nombre + ", id=" + id + ", rol=" + rol + ", medio=" + medio + '}';
    }

}
