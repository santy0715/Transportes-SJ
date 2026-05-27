package co.edu.poligran.paradigmas.backend.negocio;

import java.util.ArrayList;
import java.util.List;
import co.edu.poligran.paradigmas.backend.vo.ParadaVO;

public class ParadaManager {

    private List<ParadaVO> lista = new ArrayList<>();

    public void crear(ParadaVO p) throws Exception {
        if (buscar(p.getId()) != null) {
            throw new Exception("Parada ya existe");
        }
        lista.add(p);
    }

    public List<ParadaVO> listar() {
        return lista;
    }

    public ParadaVO buscar(int id) {
        for (ParadaVO p : lista) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void actualizar(ParadaVO parada) throws Exception {
        ParadaVO existente = buscar(parada.getId());

        if (existente == null) {
            throw new Exception("Parada no existe");
        }

        existente.setNombre(parada.getNombre());
        existente.setUbicacion(parada.getUbicacion());
    }

    public void eliminar(int id) throws Exception {
        ParadaVO p = buscar(id);
        if (p == null) {
            throw new Exception("Parada no existe");
        }
        lista.remove(p);
    }
}