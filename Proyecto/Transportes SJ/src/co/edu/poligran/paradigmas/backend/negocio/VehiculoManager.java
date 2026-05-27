package co.edu.poligran.paradigmas.backend.negocio;

import java.util.*;
import co.edu.poligran.paradigmas.backend.vo.*;

public class VehiculoManager {

    private List<VehiculoVO> lista = new ArrayList<>();

    public void crear(VehiculoVO v) throws Exception {
        if(buscar(v.getId()) != null){
            throw new Exception("Vehiculo ya existe");
        }
        lista.add(v);
    }

    public List<VehiculoVO> listar(){
        return lista;
    }

    public VehiculoVO buscar(int id){
        for(VehiculoVO v : lista){
            if(v.getId() == id) return v;
        }
        return null;
    }
    public void actualizar(VehiculoVO nuevo) throws Exception {

        VehiculoVO existente = buscar(nuevo.getId());

        if(existente == null){
            throw new Exception("Vehiculo no existe");
        }

        existente.setPlaca(nuevo.getPlaca());
        existente.setModelo(nuevo.getModelo());
        existente.setCapacidad(nuevo.getCapacidad());

    }

    public void eliminar(int id) throws Exception {
        VehiculoVO v = buscar(id);
        if(v == null){
            throw new Exception("Vehiculo no existe");
        }
        lista.remove(v);
    }

}