/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decorador;

/**
 *
 * @author Juan Camilo Mesa, Simon Sanmiguel.
 */
public class AbstractDecorator extends Component {

    protected Component componente;

    @Override
    public String notificar(String medio) {
        if (componente != null) {
            return componente.notificar(medio);
        }
        return componente.notificar(medio);
    }

    public void setComponente(Component componente) {
        this.componente = componente;
    }

}
