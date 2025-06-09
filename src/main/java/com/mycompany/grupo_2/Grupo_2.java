/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.grupo_2;
import java.util.Scanner;
/**
 *
 * @author DAVID
 */
public class Grupo_2 {
    // Método para verificar si un número es primo
    public static boolean esPrimo(int num) {
    if (num <= 1) return false;
    for (int i = 2; i <= Math.sqrt(num); i++) {
    if (num % i == 0) return false;
    }
    return true;
    }
    
    // Método para convertir decimal a binario sin usar Integer.toBinaryString()
    public static String convertirnario(int numero) {
    if (numero == 0) {
    return "0";
    }

    String binario = "";
    while (numero > 0) {
        int residuo = numero % 2;
        binario = residuo + binario; // Concatenamos el bit al principio
        numero = numero / 2;
    }
    return binario;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opc=10;

        while (opc != 0) {
            System.out.println("1. Ecuación cuadrática (Lucas Mancheno)");
            System.out.println("2. Número primo (Gabriel Estrella)");
            System.out.println("3. Numero decimal a binario (Mathias León)");
            System.out.println("0. Salir");
            opc = scanner.nextInt();
            if (opc!=0 && opc!=1 && opc!=2 && opc!=3){
                System.out.println("El número tiene que estar entre los nombrados antes.");
            }

            switch (opc) {
                case 1 -> {
                    // Entrada de los coeficientes
                    System.out.print("Ingresa el valor de a: ");
                    double a = scanner.nextDouble();
                    System.out.print("Ingresa el valor de b: ");
                    double b = scanner.nextDouble();
                    System.out.print("Ingresa el valor de c: ");
                    double c = scanner.nextDouble();
                    // Calculando el numero dentro de la raiz o discriminante
                    double disc = b * b - 4 * a * c;
                    //Uso de condicionales para resolver la ecuacion cuadratica
                    //Saber si es posible resolver
                    if (a == 0) {
                        System.out.println("No es una ecuación cuadrática (a no puede ser = 0).");
                    }
                    //Saber los posibles resultados
                    else if (disc > 0) {
                        // Dos soluciones
                        //Math.sqrt sirve para calcular las raices cuadradas
                        double x1 = (-b + Math.sqrt(disc)) / (2 * a);
                        double x2 = (-b - Math.sqrt(disc)) / (2 * a);
                        System.out.println("Las soluciones reales son: x1 = " + x1 + ", x2 = " + x2);
                    }
                    //Saber si va a tener una unica solucion raiz = 0, eliminando la posibilidad del +-
                    else if (disc == 0) {
                        // Una unica solucion
                        double x = -b / (2 * a);
                        System.out.println("Hay una solucion: x = " + x);
                    }
                    else {
                        // Soluciones con decimales despues de la division
                        double complejo = -b / (2 * a);
                        System.out.println("Las soluciones complejas (raiz no es entera) son:");
                        System.out.println("x1 = " + complejo);
                        System.out.println("x2 = " + complejo);
                    }
                }

                case 2 -> {
                    System.out.print("Ingresa un número: ");
                    int numero = scanner.nextInt();
                    
                    if (esPrimo(numero)) {
                        System.out.println(numero + " es un número primo.");
                    }
                    else {
                        System.out.println(numero + " no es un número primo.");
                    }
                }

                case 3 -> {
                    int numeroDecimal = 25; // Cambia este número para probar otros valores
                    String binario = convertirnario(numeroDecimal);
                    System.out.println("El número " + numeroDecimal + " en binario es: " + binario);
                }
            }            
        }
    }
}
