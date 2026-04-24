package co.edu.poligran.paradigmas.backend.vo;

public class PersonaVO {

    protected int id;
    protected String nombre;

    public PersonaVO(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    public int getId(){ return id; }
    public void setId(int id){ this.id = id; }

    public String getNombre(){ return nombre; }
    public void setNombre(String nombre){ this.nombre = nombre; }
}