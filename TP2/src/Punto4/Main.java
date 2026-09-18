package Punto4;

import java.util.Random;
import java.util.Scanner;
import util.Helper;

public class Main {
	
	public static void main (String[] args) {
		Scanner teclado = new Scanner(System.in);
		Random random = new Random();
		
		int cantidadEquipos = Helper.validarEnteroPositivo(teclado,"Ingrese la cantidad de equipos del torneo: ");
		Equipo[] equipos = cargarEquipos(teclado, cantidadEquipos);
		
		simularTorneo(equipos,random);
		
		int opcion;
		do {
			mostrarMenu();
			opcion = Helper.validarEnteroEnRango(teclado, "Elija una opción: ", 0, 5);
			
			switch (opcion) {
			case 1:
				mostrarTablaDePosiciones(equipos);
				break;
			case 2:
				mostrarTotalPartidosJugados(equipos);
				break;
			case 3:
				mostrarPromedioGeneral(equipos);
				break;
			case 4:
				mostrarLider(equipos);
				break;
			case 5:
				listarZonaDescenso(equipos);
				break;
			case 0:
				System.out.println("Saliendo del programa...");
				break;
			}
		} while (opcion !=0);
		teclado.close();
	}
	
	 public static void mostrarMenu() {
	        System.out.println("\n===== MENÚ TORNEO =====");
	        System.out.println("1) Mostrar tabla de posiciones");
	        System.out.println("2) Mostrar total de partidos jugados");
	        System.out.println("3) Mostrar promedio general de puntos");
	        System.out.println("4) Mostrar equipo líder");
	        System.out.println("5) Listar equipos en zona de descenso");
	        System.out.println("0) Salir");
	    }
	 
	 //Carga el arreglo con os equipos
	 public static Equipo[] cargarEquipos(Scanner teclado, int cantidad) {
		 Equipo[] equipos = new Equipo[cantidad];
		 for (int i=0; i<cantidad; i++) {
			 String nombre = Helper.validarStringNoVacio(teclado, "Nombre del equipo: " + (i+1) + " : ");
			 equipos[i] = new Equipo(i+1, nombre);
		 }
		 return equipos;
	 }
	 
	 //Todos los partidos posibles sin repetir
	 public static void simularTorneo(Equipo[] equipos, Random random) {
		 System.out.println("\n---Partidos---");
		 for (int i=0; i< equipos.length ; i++) {
			 for (int j=i+1; j<equipos.lenght; j++) {
				 int golesLocal = random.nextInt(4);
				 int golesVisitante = random.nextInt(4);
				 
				 equipos[i].registrarPartido(golesLocal, golesVisitante);
				 equipos[j].registrarPartidos(golesVisitante, golesLocal);
				 
				 System.out.println("");
			 }
		 }
	 }


}
