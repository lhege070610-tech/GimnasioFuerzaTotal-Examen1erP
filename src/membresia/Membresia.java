/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package membresia;

/**
 *
 * @author elizabeth
 */


//clase padre abstrata que tiene los datos de todas las membresias
public abstract class Membresia {
    
    //atributos privados
    private String nombre;
    private double precioMensual;
    private int meses;
    private double inscripcion;
    private boolean permiteDescuento;
    
    //cosntructor que recibe los datos de cada membresia
    public Membresia(String nombre, double precioMensual, int meses, double inscripcion, boolean permiteDescuento) {
        this.nombre = nombre;
        this.precioMensual = precioMensual;
        this.meses = meses;
        this.inscripcion = inscripcion;
        this.permiteDescuento = permiteDescuento;
    }

    //Getter que devuelve el nombre de la membesia
    public String getNombre() {
        return nombre;
    }
    
    
    
    //Caluar total de la membresia (es la misma formula para todos)
    public double calcularTotal() {
        return (precioMensual * meses) + inscripcion;
    }
    
    //Método para ver si es estudiante, asi permitir descuento
    public boolean permiteDescuento() {
        return permiteDescuento;
    }
    
}
