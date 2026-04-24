package co.edu.poligran.paradigmas.backend.vo;

public class EmpleadoVO extends PersonaVO {

    private double salario;
    private String cargo;

    public EmpleadoVO(int id, String nombre, double salario, String cargo){
        super(id, nombre);
        this.salario = salario;
        this.cargo = cargo;
    }

    public double getSalario(){ return salario; }
    public void setSalario(double salario){ this.salario = salario; }

    public String getCargo(){ return cargo; }
    public void setCargo(String cargo){ this.cargo = cargo; }
}