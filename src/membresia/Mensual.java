/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package membresia;

/**
 *
 * @author elizabeth
 */

// Clase que se hereda de Membresia
public class Mensual extends Membresia{
    
     // Constructor con los precios de la membresia mensual
    public Mensual() {
        
        //nombre, precio mensual, meses, inscripcion y desc
        super("Mensual", 600, 1, 300, true);
    }
    
}
