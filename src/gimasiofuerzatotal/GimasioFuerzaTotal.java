/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gimasiofuerzatotal;


import java.util.ArrayList;

import membresia.Membresia;
import membresia.Mensual;
import membresia.Trimestral;
import membresia.Anual;

import socio.Socio;

/**
 *
 * @author elizabeth
 */
public class GimasioFuerzaTotal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         // Crear ista para socios
        ArrayList<Socio> socios = new ArrayList<>();
        
        System.out.println("=== GIMNASIO FUERZA TOTAL ===");

        
        // Registrar los socios validos
        agregarSocio(socios, "Daniel", 22, true, new Mensual());
        agregarSocio(socios, "Carlos", 30, false, new Mensual());
        agregarSocio(socios, "Ricardo", 19, true, new Trimestral());
        agregarSocio(socios, "Luis", 25, false, new Trimestral());
        agregarSocio(socios, "Liz", 21, true, new Anual());
        agregarSocio(socios, "Pedro", 35, false, new Anual());
        agregarSocio(socios, "Sofia", 18, true, new Mensual());
        agregarSocio(socios, "Roberto", 28, true, new Trimestral());
        
        // Intentos de registro invalidos
        agregarSocio(socios, "", 20, true, new Mensual());
        agregarSocio(socios, "Juan", 13, false, new Anual());

        //mostrar la lista de socios
        mostrarSocios(socios);

        //Mostrar los reportes
        mostrarReportes(socios);

        // Mostrar estudiantes con descuento
        mostrarEstudiantes(socios);

        //dar de baja a un socio
        darDeBaja(socios, "Carlos");

        //intentar dar de baja a alguien que no existe
        darDeBaja(socios, "Fernando");

        // Mostrar lista y reportes actualizados
        System.out.println("\n=== DESPUES DE LAS BAJAS ===");
        mostrarSocios(socios);
        mostrarReportes(socios);
        mostrarEstudiantes(socios);
         
        
    }
    // Metodo para agregar socios
    public static void agregarSocio(ArrayList<Socio> socios, String nombre, int edad,boolean estudiante,Membresia membresia) {

        Socio nuevo = Socio.registrar(nombre, edad,estudiante, membresia);
        // Solo lo agrega si el registro fue valido
        if (nuevo != null) {
            socios.add(nuevo);
            System.out.println("Registrado:" + nuevo.getNombre());
        }
    }

    // Metodo para mostrar todos los socios
    public static void mostrarSocios(ArrayList<Socio> socios) {

        System.out.println("\n=== LISTA DE SUOCIOS ===");
        // Comprueba si hay socios registrados
        if (socios.isEmpty()) {
            System.out.println("No hay socios registrados.");
            return;
        }

        for (Socio s : socios) {
            s.mostrarDatos();
        }
    }

    // Metodo para mostrar reportes
    public static void mostrarReportes(ArrayList<Socio> socios) {

        System.out.println("\n=== REPORTES DEL GIMNASIO ===");

        double ingresoTotal = 0;
        Socio mayorPago = null;

        // Calcular ingresos y encontrar el mayor pago
        for (Socio socio : socios) {

            ingresoTotal += socio.calcularPago();

            if (mayorPago == null ||socio.calcularPago() > mayorPago.calcularPago()) {

                mayorPago = socio;
            }
        }

        System.out.println("Ingreso total: $" + ingresoTotal);
        System.out.println("Total de socios: " + socios.size());

        // Obtener los tipos de membresia sin repetirlos
        ArrayList<String> tipos = new ArrayList<>();

        for (Socio socio : socios) {

            String tipo = socio.getTipoMembresia();

            if (!tipos.contains(tipo)) {
                tipos.add(tipo);
            }
        }

        // Contar socios de cada tipo de membresia
        System.out.println("\nSocios por membresia:");

        for (String tipo : tipos) {

            int contador = 0;

            for (Socio socio : socios) {

                if (socio.getTipoMembresia().equals(tipo)) {
                    contador++;
                }
            }

            System.out.println(tipo + ": " + contador);
        }

        // Mostrar quien pago mas
        if (mayorPago != null) {
            System.out.println("\nSocio que pago mas:");
            System.out.println("Nombre: " + mayorPago.getNombre());
            System.out.println("Pago: $" + mayorPago.calcularPago());
        }
    }

    // Metodo para dar de baja a un socio
    public static void darDeBaja(ArrayList<Socio> socios, String nombre) {

        System.out.println("\n=== BAJA DE SOCIO ===");

        int posicion = -1;

        for (int i = 0; i < socios.size(); i++) {

            if (socios.get(i).getNombre().equalsIgnoreCase(nombre)) {
                posicion = i;
                break;
            }
        }

        if (posicion != -1) {
            socios.remove(posicion);
            System.out.println(nombre + " fue dado de baja.");
        } else {
            System.out.println("No se encontro al socio: " + nombre);
        }
    }

    // Metodo para mostrar estudiantes con descuento
    public static void mostrarEstudiantes(ArrayList<Socio> socios) {

        System.out.println("\n=== ESTUDIANTES CON DESCUENTO ===");

        int contador = 0;

        for (Socio socio : socios) {

            if (socio.tieneDescuento()) {
                System.out.println(socio.getNombre());
                contador++;
            }
        }

        if (contador == 0) {
            System.out.println("No hay estudiantes con descuento");
        }
    }

}
