/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socio;

import membresia.Membresia;

/**
 *
 * @author elizabeth
 */

//clase para cada socio del gimnasio 
public class Socio {
    // Datos del socio y membresia 
    private String nombre;
    private int edad;
    private boolean estudiante;
    private Membresia membresia;

    //constructor privado para evitar registros sin validar
    private Socio(String nombre, int edad, boolean estudiante, Membresia membresia) {
        this.nombre = nombre;
        this.edad = edad;
        this.estudiante = estudiante;
        this.membresia = membresia;
    }
    
    //metodos para validar datos antes de hacer el resgisro
    public static Socio registrar(String nombre, int edad,boolean estudiante,Membresia membresia) {

        //verifucar que el nombre no este nulo o vacio
        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println("Verifica el nombre");
            return null;
        }
        //verificar edad mayor que 15
        if (edad < 15) {
            System.out.println("La edad minima es de 15 años");
            return null;
        }
        //verificar que exista la membresia
        if (membresia == null) {
            System.out.println("Debe seleccionar una membresia");
            return null;
        }
        //si todo esta bien, crear al socio
        return new Socio(nombre.trim(), edad, estudiante, membresia);
    }
    
    // Devuelve el nombre del socio
    public String getNombre() {
        return nombre;
    }
    // Devuelve el nombre de la membresia que se eligio
    public String getTipoMembresia() {
        return membresia.getNombre();
    }
    //ver si el socio puede recibir descuento
    public boolean tieneDescuento() {
        //debe ser estudiante y tener una membresia que lo permita- manda un true o false
        // Debe ser estudiante y tener una membresia que lo permita
        if (estudiante && membresia.permiteDescuento()) {
            return true;
        } else {
            return false;
        }
    }
    
    //calcular cuanto debe de pagar el socio
    public double calcularPago() {
        // obtiene el precio normal de la membresia
        double total = membresia.calcularTotal();
        
        //si tiene descuento, se le descuenta el 10%
        if (tieneDescuento()) {
            total = total * 0.90;
        }

        return total;
    }
    
    //mostrar informacion del socio
    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Estudiante: " + (estudiante ? "Si" : "No"));
        System.out.println("Membresia: " + getTipoMembresia());
        System.out.println("Total a pagar: $" + calcularPago());
        System.out.println("Recibio descuento: "+ (tieneDescuento() ? "Si" : "No"));
        System.out.println("------------------------------");
    }
    
    
    
    
    
    
}
