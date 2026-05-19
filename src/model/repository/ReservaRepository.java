package model.repository;

import java.util.HashMap;

import model.entity.Reserva;

public class ReservaRepository {

    private HashMap<Integer, Reserva> listaReservas;

    public void salvar(Reserva reserva) {
        listaReservas.put(reserva.getId(), reserva);
    }

    public Reserva buscarPorId(int id) {
        return listaReservas.get(id);
    }

    public HashMap<Integer, Reserva> lista() {
        return listaReservas;
    }

    public void atualizar(Reserva reserva) {
        listaReservas.put(reserva.getId(), reserva);
    }

    public void remover(Reserva reserva) {
        listaReservas.remove(reserva.getId());
    }

}
