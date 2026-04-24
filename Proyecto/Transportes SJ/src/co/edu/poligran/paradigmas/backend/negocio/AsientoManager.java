package co.edu.poligran.paradigmas.backend.negocio;

import java.util.*;
import co.edu.poligran.paradigmas.backend.vo.*;

public class AsientoManager {

    private List<AsientoVO> lista = new ArrayList<>();

    public void crear(AsientoVO a) throws Exception {
        if(buscar(a.getNumero()) != null){
            throw new Exception("Asiento ya existe");
        }
        lista.add(a);
    }

    public List<AsientoVO> listar(){
        return lista;
    }

    public AsientoVO buscar(int num){
        for(AsientoVO a : lista){
            if(a.getNumero() == num) return a;
        }
        return null;
    }

    public void eliminar(int num) throws Exception {
        AsientoVO a = buscar(num);
        if(a == null){
            throw new Exception("Asiento no existe");
        }
        lista.remove(a);
    }
}