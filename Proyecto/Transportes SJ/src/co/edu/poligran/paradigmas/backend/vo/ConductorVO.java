package co.edu.poligran.paradigmas.backend.vo;

public class ConductorVO extends EmpleadoVO {

    private String licencia;
    private int experiencia;

    public ConductorVO(int id, String nombre, double salario, String cargo, String licencia, int experiencia){
        super(id, nombre, salario, cargo);
        this.licencia = licencia;
        this.experiencia = experiencia;
    }

    public String getLicencia(){ return licencia; }
    public void setLicencia(String licencia){ this.licencia = licencia; }

    public int getExperiencia(){ return experiencia; }
    public void setExperiencia(int experiencia){ this.experiencia = experiencia; }
}