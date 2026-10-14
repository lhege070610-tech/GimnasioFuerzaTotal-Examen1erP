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
public class Trimestral extends Membresia{
    
    // Constructor con los datos de la membresia trimestral
    public Trimestral() {
        
        // Se pagan 3 meses y se cobra inscripcion
        // Tambien permite descuento a estudiantes
        super("Trimestral", 550, 3, 300, true);
    }
    
}
