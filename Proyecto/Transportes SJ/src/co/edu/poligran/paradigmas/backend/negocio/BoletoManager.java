package co.edu.poligran.paradigmas.backend.negocio;

import java.util.*;
import co.edu.poligran.paradigmas.backend.vo.*;

public class BoletoManager {

    private List<BoletoVO> lista = new ArrayList<>();

    public void crear(BoletoVO b) {
        lista.add(b);
    }

    public List<BoletoVO> listar() {
        return lista;
    }

    public BoletoVO buscar(int id) {
        for (BoletoVO b : lista) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    public void actualizar(BoletoVO boletoActualizado) throws Exception {
        BoletoVO b = buscar(boletoActualizado.getId());
        if (b == null) {
            throw new Exception("Boleto no existe");
        }

        b.setPrecio(boletoActualizado.getPrecio());
        b.setFecha(boletoActualizado.getFecha());
        b.setPasajero(boletoActualizado.getPasajero());
        b.setRuta(boletoActualizado.getRuta());
        b.setAsiento(boletoActualizado.getAsiento());
    }

    public void eliminar(int id) throws Exception {
        BoletoVO b = buscar(id);
        if (b == null) {
            throw new Exception("Boleto no existe");
        }
        lista.remove(b);
    }
}