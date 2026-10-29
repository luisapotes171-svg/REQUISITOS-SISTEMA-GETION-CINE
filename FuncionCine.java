package cine;

public class FuncionCine {

    private String tituloPelicula;
    private String sala;
    private int asientosOcupados;
    private double recaudacion;
    private double tarifaBase;

    public FuncionCine() {
        this.tituloPelicula = "";
        this.sala = "";
        this.asientosOcupados = 0;
        this.recaudacion = 0;
        this.tarifaBase = 12000;
    }
    
    public FuncionCine(String tituloPelicula, String sala, int asientosOcupados, double recaudacion) {
        this.tituloPelicula = "";
        this.sala = "";
        this.asientosOcupados = 0;
        this.recaudacion = 0;
        this.tarifaBase = 12000;
        setTituloPelicula(tituloPelicula);
        setSala(sala);
        setAsientosOcupados(asientosOcupados);
        setRecaudacion(recaudacion);
    }

    public String getTituloPelicula() {
        return tituloPelicula;
    }

    public boolean setTituloPelicula(String tituloPelicula) {
        if (tituloPelicula != null && !tituloPelicula.trim().isEmpty()) {
            this.tituloPelicula = tituloPelicula;
            return true;
        }
        System.out.println("ERROR EL TITULO DE LA PELICULA NO PUEDE ESTAR VACIO");
        return false;
    }

    public String getSala() {
        return sala;
    }

    public boolean setSala(String sala) {
        if (sala != null && !sala.trim().isEmpty()) {
            this.sala = sala;
            return true;
        }
        System.out.println("ERROR LA SALA NO PUEDE ESTAR VACIA");
        return false;
    }

    public int getAsientosOcupados() {
        return asientosOcupados;
    }

    public boolean setAsientosOcupados(int asientosOcupados) {
        if (asientosOcupados >= 0) {
            this.asientosOcupados = asientosOcupados;
            return true;
        }
        System.out.println("ERROR LOS ASIENTOS OCUPADOS NO PUEDEN SER NEGATIVOS");
        return false;
    }

    public double getRecaudacion() {
        return recaudacion;
    }

    public boolean setRecaudacion(double recaudacion) {
        if (recaudacion >= 0) {
            this.recaudacion = recaudacion;
            return true;
        }
        System.out.println("ERROR LA RECAUDACION NO PUEDE SER NEGATIVA");
        return false;
    }

    public double getTarifaBase() {
        return tarifaBase;
    }

    public double calcularRecaudacion() {
        return asientosOcupados * tarifaBase;
    }

    public void mostrarInformacion() {
        System.out.println("===== DATOS DE LA FUNCION =====");
        System.out.println("PELICULA: " + tituloPelicula);
        System.out.println("SALA: " + sala);
        System.out.println("ASIENTOS OCUPADOS: " + asientosOcupados);
        System.out.println("RECAUDACION: $" + recaudacion);
    }
}