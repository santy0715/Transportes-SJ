package co.edu.poligran.paradigmas.backend.negocio;

import java.util.*;
import co.edu.poligran.paradigmas.backend.vo.*;

public class RutaManager {

    private List<RutaVO> lista = new ArrayList<>();

    public void crear(RutaVO r) throws Exception {
        if(buscar(r.getId()) != null){
            throw new Exception("Ruta ya existe");
        }
        lista.add(r);
    }

    public List<RutaVO> listar(){
        return lista;
    }

    public RutaVO buscar(int id){
        for(RutaVO r : lista){
            if(r.getId() == id) return r;
        }
        return null;
    }

    public void eliminar(int id) throws Exception {
        RutaVO r = buscar(id);
        if(r == null){
            throw new Exception("Ruta no existe");
        }
        lista.remove(r);
    }
}
