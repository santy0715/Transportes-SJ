package co.edu.poligran.paradigmas.backend.vo;

public class AsientoVO {

    private int numero;
    private boolean ocupado;

    public AsientoVO(int numero){
        this.numero = numero;
        this.ocupado = false;
    }

    public int getNumero(){
        return numero;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }

    public boolean isOcupado(){
        return ocupado;
    }

    public void setOcupado(boolean ocupado){
        this.ocupado = ocupado;
    }

    public void asignar(){
        this.ocupado = true;
    }
}