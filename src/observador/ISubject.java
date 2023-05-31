/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package observador;

/**
 *
 * @author Juan Camilo Mesa, Simon Sanmiguel.
 */
public interface ISubject {
    
    public void register (Observer ob);
    public void notifyObservers();
    
}
