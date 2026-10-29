package cine;

import java.util.Scanner;

public class Main {

    private static String leerTexto(Scanner teclado, String mensaje) {
        while (true) {
            System.out.println(mensaje);
            String texto = teclado.nextLine().trim();
            if (!texto.isEmpty()) {
                return texto;
            }
            System.out.println("ERROR EL DATO NO PUEDE ESTAR VACIO");
        }
    }

    private static int leerEntero(Scanner teclado, String mensaje) {
        while (true) {
            System.out.println(mensaje);
            if (teclado.hasNextInt()) {
                int valor = teclado.nextInt();
                teclado.nextLine();
                if (valor >= 0) {
                    return valor;
                }
                System.out.println("ERROR EL VALOR NO PUEDE SER NEGATIVO");
            } else {
                System.out.println("ERROR SOLO SE RECIBEN DATOS NUMERICOS ENTEROS");
                teclado.nextLine();
            }
        }
    }

    private static double leerDecimal(Scanner teclado, String mensaje) {
        while (true) {
            System.out.println(mensaje);
            if (teclado.hasNextDouble()) {
                double valor = teclado.nextDouble();
                teclado.nextLine();
                if (valor >= 0) {
                    return valor;
                }
                System.out.println("ERROR EL VALOR NO PUEDE SER NEGATIVO");
            } else {
                System.out.println("ERROR SOLO SE RECIBEN DATOS NUMERICOS");
                teclado.nextLine();
            }
        }
    }

    private static boolean respondioSi(Scanner teclado, String mensaje) {
        System.out.println(mensaje);
        String respuesta = teclado.nextLine().trim().toLowerCase();
        return respuesta.equals("si");
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("===== REGISTRO FUNCION NORMAL =====");
        FuncionNormal normal = new FuncionNormal();
        normal.setTituloPelicula(leerTexto(teclado, "INGRESE EL TITULO DE LA PELICULA: "));
        normal.setSala(leerTexto(teclado, "INGRESE LA SALA: "));
        normal.setCapacidadTotal(leerEntero(teclado, "INGRESE LA CAPACIDAD TOTAL DE LA SALA: "));

        int ocupados = leerEntero(teclado, "INGRESE LOS ASIENTOS OCUPADOS: ");
        while (ocupados > normal.getCapacidadTotal()) {
            System.out.println("ERROR LOS ASIENTOS OCUPADOS SUPERAN LA CAPACIDAD");
            ocupados = leerEntero(teclado, "INGRESE LOS ASIENTOS OCUPADOS: ");
        }
        normal.setAsientosOcupados(ocupados);
        normal.setRecaudacion(normal.calcularRecaudacion());

        System.out.println("===== INFORMACION ANTES DE LA VENTA =====");
        normal.mostrarInformacion();

        if (respondioSi(teclado, "DESEA VENDER ENTRADAS (SI)/(NO): ")) {
            int cantidad = leerEntero(teclado, "INGRESE LA CANTIDAD DE ENTRADAS: ");
            if (normal.venderEntradas(cantidad)) {
                System.out.println("VENTA REALIZADA");
            } else {
                System.out.println("VENTA NO REALIZADA");
            }
        }

        System.out.println("===== RESULTADOS FINALES FUNCION NORMAL =====");
        System.out.println("PELICULA: " + normal.getTituloPelicula());
        System.out.println("SALA: " + normal.getSala());
        System.out.println("ASIENTOS OCUPADOS: " + normal.getAsientosOcupados());
        System.out.println("ASIENTOS DISPONIBLES: " + normal.getAsientosDisponibles());
        System.out.println("RECAUDACION: $" + normal.getRecaudacion());

        System.out.println("===== REGISTRO FUNCION ESTRENO =====");
        FuncionEstreno estreno = new FuncionEstreno();
        estreno.setTituloPelicula(leerTexto(teclado, "INGRESE EL TITULO DE LA PELICULA: "));
        estreno.setSala(leerTexto(teclado, "INGRESE LA SALA: "));
        estreno.setAsientosOcupados(leerEntero(teclado, "INGRESE LOS ASIENTOS OCUPADOS: "));
        estreno.setRecargoPorcentaje(leerDecimal(teclado, "INGRESE EL RECARGO DE ESTRENO (%): "));
        estreno.setRecaudacion(estreno.calcularRecaudacion());

        System.out.println("===== INFORMACION ANTES DE LA VENTA =====");
        estreno.mostrarInformacion();

        if (respondioSi(teclado, "DESEA VENDER ENTRADAS (SI)/(NO): ")) {
            int cantidad = leerEntero(teclado, "INGRESE LA CANTIDAD DE ENTRADAS: ");
            if (estreno.venderEntradas(cantidad)) {
                System.out.println("VENTA REALIZADA");
            } else {
                System.out.println("VENTA NO REALIZADA");
            }
        }

        System.out.println("===== RESULTADOS FINALES FUNCION ESTRENO =====");
        System.out.println("PELICULA: " + estreno.getTituloPelicula());
        System.out.println("SALA: " + estreno.getSala());
        System.out.println("ASIENTOS OCUPADOS: " + estreno.getAsientosOcupados());
        System.out.println("RECARGO: " + estreno.getRecargoPorcentaje() + "%");
        System.out.println("RECAUDACION: $" + estreno.getRecaudacion());

        teclado.close();
        System.out.println("SISTEMA DE CINE FINALIZADO");
    }
}