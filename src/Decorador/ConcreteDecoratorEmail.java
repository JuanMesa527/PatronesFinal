/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decorador;

/**
 *
 * @author Juan Camilo Mesa, Simon Sanmiguel.
 */
public class ConcreteDecoratorEmail extends AbstractDecorator {
    
    public String notificar(String medio) {
        String mensaje=super.notificar(medio);
        return mensaje;
    }
    
}
