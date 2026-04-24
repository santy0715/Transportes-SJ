package co.edu.poligran.paradigmas.backend.vo;
public class VehiculoVO {

    private int id;
    private int capacidad;
    private String placa;
    private String modelo;

    public VehiculoVO(int id, int capacidad, String placa, String modelo){
        this.id = id;
        this.capacidad = capacidad;
        this.placa = placa;
        this.modelo = modelo;
    }

    public int getId(){ return id; }
    public void setId(int id){ this.id = id; }

    public int getCapacidad(){ return capacidad; }
    public void setCapacidad(int capacidad){ this.capacidad = capacidad; }

    public String getPlaca(){ return placa; }
    public void setPlaca(String placa){ this.placa = placa; }

    public String getModelo(){ return modelo; }
    public void setModelo(String modelo){ this.modelo = modelo; }
}