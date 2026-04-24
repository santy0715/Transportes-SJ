package co.edu.poligran.paradigmas.backend.vo;

public class RutaVO {

    private int id;
    private String origen;
    private String destino;
    private HorarioVO horario;
    private VehiculoVO vehiculo;

    public RutaVO(int id, String origen, String destino, HorarioVO horario, VehiculoVO vehiculo){
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.horario = horario;
        this.vehiculo = vehiculo;
    }

    public int getId(){ return id; }
    public void setId(int id){ this.id = id; }

    public String getOrigen(){ return origen; }
    public void setOrigen(String origen){ this.origen = origen; }

    public String getDestino(){ return destino; }
    public void setDestino(String destino){ this.destino = destino; }

    public HorarioVO getHorario(){ return horario; }
    public void setHorario(HorarioVO horario){ this.horario = horario; }

    public VehiculoVO getVehiculo(){ return vehiculo; }
    public void setVehiculo(VehiculoVO vehiculo){ this.vehiculo = vehiculo; }
}