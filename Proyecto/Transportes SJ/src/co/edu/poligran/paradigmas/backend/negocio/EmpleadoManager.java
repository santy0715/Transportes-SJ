package co.edu.poligran.paradigmas.backend.negocio;

import java.util.ArrayList;
import java.util.List;
import co.edu.poligran.paradigmas.backend.vo.EmpleadoVO;

public class EmpleadoManager {

    private List<EmpleadoVO> lista = new ArrayList<>();

    public void crear(EmpleadoVO e) throws Exception {
        if (buscar(e.getId()) != null) {
            throw new Exception("Empleado ya existe");
        }
        lista.add(e);
    }

    public List<EmpleadoVO> listar() {
        return lista;
    }

    public EmpleadoVO buscar(int id) {
        for (EmpleadoVO e : lista) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public void actualizar(EmpleadoVO empleado) throws Exception {
        EmpleadoVO existente = buscar(empleado.getId());

        if (existente == null) {
            throw new Exception("Empleado no existe");
        }

        existente.setNombre(empleado.getNombre());
        existente.setSalario(empleado.getSalario());
        existente.setCargo(empleado.getCargo());
    }

    public void eliminar(int id) throws Exception {
        EmpleadoVO e = buscar(id);

        if (e == null) {
            throw new Exception("Empleado no existe");
        }

        lista.remove(e);
    }
}