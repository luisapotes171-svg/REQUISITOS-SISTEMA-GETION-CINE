package cine;

public class FuncionEstreno extends FuncionCine {

    private double recargoPorcentaje;

    public FuncionEstreno() {
        super();
        this.recargoPorcentaje = 0;
    }

    public FuncionEstreno(String tituloPelicula, String sala, int asientosOcupados,
                          double recaudacion, double recargoPorcentaje) {
        super(tituloPelicula, sala, asientosOcupados, recaudacion);
        this.recargoPorcentaje = 0;
        setRecargoPorcentaje(recargoPorcentaje);
    }

    public double getRecargoPorcentaje() {
        return recargoPorcentaje;
    }

    public boolean setRecargoPorcentaje(double recargoPorcentaje) {
        if (recargoPorcentaje >= 0) {
            this.recargoPorcentaje = recargoPorcentaje;
            return true;
        }
        System.out.println("ERROR EL RECARGO NO PUEDE SER NEGATIVO");
        return false;
    }

    public double calcularRecaudacion() {
        double tarifaEstreno = getTarifaBase() + (getTarifaBase() * recargoPorcentaje / 100);
        return getAsientosOcupados() * tarifaEstreno;
    }

    public boolean venderEntradas(int cantidad) {
        if (cantidad <= 0) {
            System.out.println("ERROR LA CANTIDAD DE ENTRADAS DEBE SER MAYOR A CERO");
            return false;
        }
        setAsientosOcupados(getAsientosOcupados() + cantidad);
        setRecaudacion(calcularRecaudacion());
        return true;
    }

    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("RECARGO DE ESTRENO: " + recargoPorcentaje + "%");
    }
}