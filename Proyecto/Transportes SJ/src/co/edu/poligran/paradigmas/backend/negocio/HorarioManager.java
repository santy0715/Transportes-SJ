package co.edu.poligran.paradigmas.backend.negocio;

import java.util.*;
import co.edu.poligran.paradigmas.backend.vo.*;

public class HorarioManager {

    private List<HorarioVO> lista = new ArrayList<>();

    public void crear(HorarioVO h) throws Exception {
        if(buscar(h.getId()) != null){
            throw new Exception("Horario ya existe");
        }
        lista.add(h);
    }

    public List<HorarioVO> listar(){
        return lista;
    }

    public HorarioVO buscar(int id){
        for(HorarioVO h : lista){
            if(h.getId() == id) return h;
        }
        return null;
    }

    public void eliminar(int id) throws Exception {
        HorarioVO h = buscar(id);
        if(h == null){
            throw new Exception("Horario no existe");
        }
        lista.remove(h);
    }
}