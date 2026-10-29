package cine;

public class FuncionNormal extends FuncionCine {

    private int capacidadTotal;

    public FuncionNormal() {
        super();
        this.capacidadTotal = 0;
    }

    public FuncionNormal(String tituloPelicula, String sala, int asientosOcupados,
                         double recaudacion, int capacidadTotal) {
        super(tituloPelicula, sala, asientosOcupados, recaudacion);
        setCapacidadTotal(capacidadTotal);
    }

    public int getCapacidadTotal() {
        return capacidadTotal;
    }

    public boolean setCapacidadTotal(int capacidadTotal) {
        if (capacidadTotal > 0) {
            this.capacidadTotal = capacidadTotal;
            return true;
        }
        System.out.println("ERROR LA CAPACIDAD TOTAL DEBE SER MAYOR A CERO");
        return false;
    }

    public int getAsientosDisponibles() {
        return capacidadTotal - getAsientosOcupados();
    }

    public boolean venderEntradas(int cantidad) {
        if (cantidad <= 0) {
            System.out.println("ERROR LA CANTIDAD DE ENTRADAS DEBE SER MAYOR A CERO");
            return false;
        }
        if (cantidad > getAsientosDisponibles()) {
            System.out.println("ERROR NO HAY SUFICIENTES ASIENTOS DISPONIBLES");
            return false;
        }
        setAsientosOcupados(getAsientosOcupados() + cantidad);
        setRecaudacion(calcularRecaudacion());
        return true;
    }

    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("CAPACIDAD TOTAL: " + capacidadTotal);
        System.out.println("ASIENTOS DISPONIBLES: " + getAsientosDisponibles());
    }
}
