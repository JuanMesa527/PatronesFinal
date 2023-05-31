/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decorador;

/**
 *
 * @author Juan Camilo Mesa, Simon Sanmiguel.
 */
public class ConcreteComponent extends Component {

    @Override
    public String notificar(String medio) {
        return medio+" \nsu revserva esta disponible!!!!\n"
                + "solicitelo ya :D";
    }
}
