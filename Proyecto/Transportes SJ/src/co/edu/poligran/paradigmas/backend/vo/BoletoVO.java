package co.edu.poligran.paradigmas.backend.vo;

public class BoletoVO {

    private int id;
    private double precio;
    private String fecha;
    private PasajeroVO pasajero;
    private RutaVO ruta;
    private AsientoVO asiento;

    public BoletoVO(int id, double precio, String fecha, PasajeroVO pasajero, RutaVO ruta, AsientoVO asiento) {
        this.id = id;
        this.precio = precio;
        this.fecha = fecha;
        this.pasajero = pasajero;
        this.ruta = ruta;
        this.asiento = asiento;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public PasajeroVO getPasajero() { return pasajero; }
    public void setPasajero(PasajeroVO pasajero) { this.pasajero = pasajero; }

    public RutaVO getRuta() { return ruta; }
    public void setRuta(RutaVO ruta) { this.ruta = ruta; }

    public AsientoVO getAsiento() { return asiento; }
    public void setAsiento(AsientoVO asiento) { this.asiento = asiento; }
}