package co.edu.poligran.paradigmas.backend.negocio;

import java.util.*;
import co.edu.poligran.paradigmas.backend.vo.*;

public class PasajeroManager {

    private List<PasajeroVO> lista = new ArrayList<>();

    public void crear(PasajeroVO p) throws Exception {
        if(buscar(p.getId()) != null){
            throw new Exception("Pasajero ya existe");
        }
        lista.add(p);
    }

    public List<PasajeroVO> listar(){
        return lista;
    }

    public PasajeroVO buscar(int id){
        for(PasajeroVO p : lista){
            if(p.getId() == id) return p;
        }
        return null;
    }

    public void eliminar(int id) throws Exception {
        PasajeroVO p = buscar(id);
        if(p == null){
            throw new Exception("Pasajero no existe");
        }
        lista.remove(p);
    }
}
