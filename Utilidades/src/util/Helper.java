package util;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Helper {

    // Valida un número entero positivo
    public static int validarEntero(Scanner entrada, String mensaje) {
        int cantidad;
        while (true) {
            try {
                System.out.print(mensaje);
                cantidad = Integer.parseInt(entrada.nextLine().trim());

                if (cantidad < 0) {
                    System.out.println("El número debe ser mayor o igual que cero. Intenta de nuevo.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: No ingresaste un número entero válido. Intenta otra vez.");
            }
        }
        return cantidad;
    }

    // Valida un string no vacío ingresado por el usuario
    public static String validarStringNoVacio(Scanner entrada, String mensaje) {
        String valorIngresado;
        while (true) {

            System.out.println(mensaje);
            valorIngresado = entrada.nextLine().trim();
            if (!valorIngresado.isEmpty()) {
                return valorIngresado;
            } else {
                System.out.println("Error!!! El texto no puede estar vacío.");
            }
        }
    }

    // Valida un string que contiene solo letras
    public static String validarSoloLetras(Scanner entrada, String mensaje) {
        String valorIngresado;
        while (true) {
            System.out.println(mensaje);
            valorIngresado = entrada.nextLine().trim();
            if (valorIngresado.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                return valorIngresado;
            } else {
                System.out.println("Error!!! El texto solo puede contener letras.");
            }
        }
    }

    // Valida un número double
    public static double validarDouble(Scanner entrada, String mensaje) {
        double numero;
        while (true) {
            try {
                System.out.println(mensaje);
                numero = Double.parseDouble(entrada.nextLine().trim());
                break;

            } catch (NumberFormatException e) {
                System.out.println("Error!!! Debe ingresar un número de tipo double.");
            }
        }
        return numero;
    }

    // Valida un email simple
    public static String validarEmail(Scanner entrada, String mensaje) {
        while (true) {
            System.out.println(mensaje);
            String valorIngresado = entrada.nextLine().trim();
            int arroba = valorIngresado.indexOf("@");

            if (!valorIngresado.isEmpty() && arroba > 0
                    && arroba < valorIngresado.length() - 1
                    && valorIngresado.contains(".")) {
                return valorIngresado;
            } else {
                System.out.println("Error: correo inválido. Intentelo de nuevo.");
            }
        }
    }

    // Pide al usuario una fecha válida en formato yyyy-MM-dd y la devuelve como LocalDate
    public static LocalDate pedirFechaValida(Scanner entrada, String mensaje) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fecha;
        while (true) {
            System.out.print(mensaje);
            String fechaTexto = entrada.nextLine().trim();
            try {

                fecha = LocalDate.parse(fechaTexto, formato);
                break;
            } catch (DateTimeException e) {
                System.out.println("Fecha inválida. Use el formato correcto: yyyy-MM-dd (ej: 2000-10-15)");
            }
        }
        return fecha;
    }
    
 // Valida un entero estrictamente positivo (mayor a cero)
    public static int validarEnteroPositivo(Scanner entrada, String mensaje) {
        int numero;
        while (true) {
            try {
                System.out.print(mensaje);
                numero = Integer.parseInt(entrada.nextLine().trim());
                if (numero > 0) {
                    return numero;
                } else {
                    System.out.println("Error: el valor debe ser mayor a cero.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un número entero válido.");
            }
        }
    }

    // Valida un entero dentro de un rango [min, max] (ambos inclusive)
    public static int validarEnteroEnRango(Scanner entrada, String mensaje, int min, int max) {
        int numero;
        while (true) {
            try {
                System.out.print(mensaje);
                numero = Integer.parseInt(entrada.nextLine().trim());
                if (numero >= min && numero <= max) {
                    return numero;
                } else {
                    System.out.println("Error: el valor debe estar entre " + min + " y " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un número entero válido.");
            }
        }
    }

    // Valida un double que no puede ser negativo (permite 0)
    public static double validarDoubleNoNegativo(Scanner entrada, String mensaje) {
        double numero;
        while (true) {
            try {
                System.out.print(mensaje);
                numero = Double.parseDouble(entrada.nextLine().trim());
                if (numero >= 0) {
                    return numero;
                } else {
                    System.out.println("Error: el valor no puede ser negativo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un número válido.");
            }
        }
    }

    // Valida un double estrictamente positivo
    public static double validarDoublePositivo(Scanner entrada, String mensaje) {
        double numero;
        while (true) {
            try {
                System.out.print(mensaje);
                numero = Double.parseDouble(entrada.nextLine().trim());
                if (numero > 0) {
                    return numero;
                } else {
                    System.out.println("Error: el valor debe ser mayor a cero.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un número válido.");
            }
        }
    }

    // Valida que se ingrese un único carácter
    public static char validarChar(Scanner entrada, String mensaje) {
        String linea;
        while (true) {
            System.out.print(mensaje);
            linea = entrada.nextLine();
            if (linea.length() == 1) {
                return linea.charAt(0);
            } else {
                System.out.println("Error, ingrese solo un caracter.");
            }
        }
    }
}