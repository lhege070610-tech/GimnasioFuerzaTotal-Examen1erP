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

//costructor con los datos de la membresia anual
public class Anual extends Membresia{
    public Anual() {
        
        // Se pagan 12 meses, sin inscripcion ni descuento
        super("Anual", 480, 12, 0, false);
    }
    
}
