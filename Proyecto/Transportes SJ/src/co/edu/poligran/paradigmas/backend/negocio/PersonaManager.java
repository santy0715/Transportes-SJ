package co.edu.poligran.paradigmas.backend.negocio;

import java.util.ArrayList;
import java.util.List;
import co.edu.poligran.paradigmas.backend.vo.PersonaVO;

public class PersonaManager {

    private List<PersonaVO> lista = new ArrayList<>();

    public void crear(PersonaVO p) throws Exception {
        if (buscar(p.getId()) != null) {
            throw new Exception("Persona ya existe");
        }
        lista.add(p);
    }

    public List<PersonaVO> listar() {
        return lista;
    }

    public PersonaVO buscar(int id) {
        for (PersonaVO p : lista) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void actualizar(PersonaVO persona) throws Exception {
        PersonaVO existente = buscar(persona.getId());

        if (existente == null) {
            throw new Exception("Persona no existe");
        }

        existente.setNombre(persona.getNombre());
    }

    public void eliminar(int id) throws Exception {
        PersonaVO p = buscar(id);

        if (p == null) {
            throw new Exception("Persona no existe");
        }

        lista.remove(p);
    }
}