package co.edu.poligran.paradigmas.backend.negocio;

import java.util.ArrayList;
import java.util.List;
import co.edu.poligran.paradigmas.backend.vo.BoletoVO;

public class BoletoManager {

    private List<BoletoVO> lista = new ArrayList<>();

    public void crear(BoletoVO b) throws Exception {
        if (buscar(b.getId()) != null) {
            throw new Exception("Boleto ya existe");
        }
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

    public void actualizar(BoletoVO boleto) throws Exception {
        BoletoVO existente = buscar(boleto.getId());

        if (existente == null) {
            throw new Exception("Boleto no existe");
        }

        existente.setPrecio(boleto.getPrecio());
        existente.setFecha(boleto.getFecha());
        existente.setPasajero(boleto.getPasajero());
        existente.setRuta(boleto.getRuta());
        existente.setAsiento(boleto.getAsiento());
    }

    public void eliminar(int id) throws Exception {
        BoletoVO b = buscar(id);

        if (b == null) {
            throw new Exception("Boleto no existe");
        }

        lista.remove(b);
    }
}