package Punto6;

import java.util.Scanner;
import util.Helper;

public class Main {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int vendedores = Helper.validarEnteroPositivo(teclado, "Ingrese el numero de vendedores: ");
		int dias = Helper.validarEnteroPositivo(teclado, "Ingrese el numero de dias: ");
		
		double [][] ventas= cargarMatriz (teclado, vendedores, dias);
		
		//a)
		double[] totalesPorVendedor = calcularTotalesPorVendedor (ventas);
		mostrarTotalesPorVendedor(totalesPorVendedor);
		
		//b)
		double[] promediosPorDia = calcularPromediosPorDia(ventas);
		mostrarPromediosPorDia(promediosPorDia);
		
		//c)
		mostrarMaximoMinimo(ventas);
		
		//d)
		double objetivo = Helper.validarDoublePositivo(teclado, "Ingrese el monto objetivo: ");
		contarVendedoresQueSuperanObjetivo(totalesPorVendedor, objetivo);
		
		//e)
		int diaConsulta= Helper.validarEnteroEnRango(teclado, "Ingrese el dia a consultar (1 a " + dias + "):", 1, dias);
		contarVentasQueSuperanPromedioDelDia(ventas, promediosPorDia, diaConsulta);
		
		//f)
		double[] promediosPorVendedor = calcularPromediosPorVendedor(totalesPorVendedor, dias);
		mostrarPromediosPorVendedor(promediosPorVendedor);
		
		teclado.close();
		
	}
	
	//Carga la matriz
	public static double [][] cargarMatriz(Scanner teclado, int filas, int columnas){
		double [][] matriz = new double[filas][columnas];
		for (int i=0; i<filas ; i++) {
			for (int j=0; j< columnas; j++) {
				String mensaje = "Venta del vendedor " + (i+1) + " en pesos (SIN $) en el dia " + (j+1) + ":";
				matriz[i][j] = Helper.validarDoubleNoNegativo(teclado, mensaje);	
			}
		}
		return matriz;
	}
	
	//a)
	public static double[] calcularTotalesPorVendedor(double[][] ventas) {
		double[] totales = new double [ventas.length];
		for (int i=0; i < ventas.length; i++) {
			double suma =0;
			for (int j=0; j< ventas[i].length; j++) {
				suma += ventas[i][j];
			}
			totales[i] = suma;
		}
		return totales;
	}
	
	public static void mostrarTotalesPorVendedor(double[] totales) {
		System.out.println("\n--- Total de ventas por vendedor ---");
		for (int i=0; i < totales.length; i++) {
			System.out.printf("Vendedor %d: %.2f%n", i+1, totales[i]);
		}
	}
	
	//b)Promedio de ventas de cada dia
	public static double[] calcularPromediosPorDia(double[][]ventas) {
		int filas = ventas.length;
		int columnas = ventas[0].length;
		double[] promedios = new double[columnas];
		
		for (int j=0; j < columnas; j++) {
			double suma = 0;
			for (int i = 0; i< filas; i++) {
				suma += ventas[i][j];
			}
			promedios[j] = suma / filas;
		}
		return promedios;
	}
	
	public static void mostrarPromediosPorDia(double[] promedios) {
		System.out.println("\n---Promedio de ventas por dia---");
		for (int j= 0; j< promedios.length; j++) {
			System.out.printf("Dia %d: %.2f%n", j+1, promedios[j]);
		}
	}
	
	//c Busca el mayor y menor monto de la matriz
	public static void mostrarMaximoMinimo(double[][] ventas) {
		double max = ventas[0][0];
		double min = ventas[0][0];
		int filaMax = 0, colMax = 0;
		int filaMin = 0, colMin = 0;
		
		for (int i= 0; i< ventas.length; i++) {
			for (int j=0; j< ventas[i].length; j++ ) {
				if (ventas[i][j] > max) {
					max = ventas[i][j];
					filaMax = i;
					colMax = j;
				}
				if (ventas[i][j] < min) {
					min = ventas[i][j];
					filaMin = i;
					colMin =j;
				}
			}
		}
		
		System.out.println("\n---Venta maxima y minima---");
		System.out.printf("Maxima: %.2f (Vendedor %d, Dia %d)%n", max, filaMax + 1, colMax + 1);
		System.out.printf("Minima: %.2f (Vendedor %d, Dia %d)%n", min, filaMin + 1, colMin + 1);
	}
	
	//d) cuenta cuantos vendedores superan el objetivo
	public static void contarVendedoresQueSuperanObjetivo(double[] totales, double objetivo ) {
		int cantidad = 0;
		for(double total : totales) {
			if(total > objetivo) {
				cantidad++;	
			}
		}
		System.out.println("\n---Vendedores que superan el objeivo de " +objetivo+ "---");
		System.out.println("Cantidad: " + cantidad);
	}
	
	//e) Cuenta cuantas ventas de un dia especifico superan el promedio
	public static void contarVentasQueSuperanPromedioDelDia(double[][] ventas, double[] promediosPorDia, int diaConsulta) {
		int indiceDia = diaConsulta - 1;
		double promedioDelDia = promediosPorDia[indiceDia];
		int cantidad = 0;
		
		for (int i=0; i < ventas.length; i++) {
			if (ventas[i][indiceDia] > promedioDelDia) {
				cantidad++;
			}
		}
		
		System.out.println("\n---Ventas que superan el promedio del dia" + diaConsulta + "---");
		System.out.printf("Promedio del dia: %.2f%n", promedioDelDia);
		System.out.println("Cantidad de ventas que lo superan:" + cantidad);
	}
	
	//f) arreglo con el promedio de ventas de cada vendedor
	public static double[] calcularPromediosPorVendedor(double[] totalesPorVendedor, int dias) {
		double[] promedios = new double[totalesPorVendedor.length];
		for (int i = 0; i < totalesPorVendedor.length; i++) {
			promedios[i] = totalesPorVendedor[i]/dias;
		}
		return promedios;
	}
	
	public static void mostrarPromediosPorVendedor(double[] promedios) {
		System.out.println("\n---Promedio de ventas por vendedor---");
		for (int i = 0; i < promedios.length; i++) {
			System.out.printf("Vendedor %d:  %.2f%n", i + 1, promedios[i]);
		}
	}

}
