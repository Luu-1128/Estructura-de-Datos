package Punto1;
import util.Helper;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Random rand = new Random();
        Scanner teclado = new Scanner(System.in);

        int N = Helper.validarEntero(teclado, "Ingrese un valor para cargar un arreglo: ");

        int[] Numeros = new int[N];

        // Cargar el arreglo con números aleatorios entre -50 y 50
        for (int i = 0; i < N; i++) {
            Numeros[i] = rand.nextInt(101) - 50;
            System.out.println(Numeros[i]);
        }

        // Desplazar una posición hacia la izquierda
        int[] desplazamiento = cambioposicion(Numeros);

        System.out.println("\nArreglo desplazado hacia la izquierda:");
        for (int i = 0; i < N; i++) {
            System.out.print(desplazamiento[i] + " ");
        }

        // Sumar positivos y negativos
        System.out.println("\n\nSuma de positivos y negativos:");
        mostrarSuma(Numeros);

        // Invertir el arreglo original
        pasaraviceversa(Numeros);

        System.out.println("\nArreglo invertido:");
        for (int i = 0; i < N; i++) {
            System.out.print(Numeros[i] + " ");
        }

        System.out.println();

        teclado.close();
    }


    // a) Desplazar una posición hacia la izquierda
    public static int[] cambioposicion(int[] arreglo) {

        int n = arreglo.length;
        int[] otroarreglo = new int[n];

        for (int i = 0; i < n - 1; i++) {
            otroarreglo[i] = arreglo[i + 1];
        }

        otroarreglo[n - 1] = arreglo[0];

        return otroarreglo;
    }


    // b) Sumar positivos y negativos
    public static void mostrarSuma(int[] arreglo) {

        int sumaPositivos = 0;
        int sumaNegativos = 0;

        for (int i = 0; i < arreglo.length; i++) {

            if (arreglo[i] > 0) {
                sumaPositivos += arreglo[i];

            } else if (arreglo[i] < 0) {
                sumaNegativos += arreglo[i];
            }
        }

        System.out.println("Suma de positivos: " + sumaPositivos);
        System.out.println("Suma de negativos: " + sumaNegativos);
    }


    // c) Invertir el arreglo original
    public static void pasaraviceversa(int[] arreglo) {

        int inicio = 0;
        int fin = arreglo.length - 1;

        while (inicio < fin) {

            int aux = arreglo[inicio];
            arreglo[inicio] = arreglo[fin];
            arreglo[fin] = aux;

            inicio++;
            fin--;
        }
    }
}