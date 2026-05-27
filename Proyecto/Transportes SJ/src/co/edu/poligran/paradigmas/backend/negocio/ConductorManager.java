package co.edu.poligran.paradigmas.backend.negocio;

import java.util.ArrayList;
import java.util.List;
import co.edu.poligran.paradigmas.backend.vo.ConductorVO;

public class ConductorManager {

    private List<ConductorVO> lista = new ArrayList<>();

    public void crear(ConductorVO c) throws Exception {
        if (buscar(c.getId()) != null) {
            throw new Exception("Conductor ya existe");
        }
        lista.add(c);
    }

    public List<ConductorVO> listar() {
        return lista;
    }

    public ConductorVO buscar(int id) {
        for (ConductorVO c : lista) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public void actualizar(ConductorVO conductor) throws Exception {
        ConductorVO existente = buscar(conductor.getId());

        if (existente == null) {
            throw new Exception("Conductor no existe");
        }

        existente.setNombre(conductor.getNombre());
        existente.setSalario(conductor.getSalario());
        existente.setCargo(conductor.getCargo());
        existente.setLicencia(conductor.getLicencia());
        existente.setExperiencia(conductor.getExperiencia());
    }

    public void eliminar(int id) throws Exception {
        ConductorVO c = buscar(id);

        if (c == null) {
            throw new Exception("Conductor no existe");
        }

        lista.remove(c);
    }
}