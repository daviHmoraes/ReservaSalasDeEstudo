package controller;

import model.entity.Reserva;
import model.service.ReservaService;

public class ReservaController {

    private ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    public void cadastrar(Reserva reserva, int idUsuario, int idSala) {
        reservaService.cadastrar(reserva, idUsuario, idSala);
    }

    public void listar() {
        reservaService.listar();
    }

    public Reserva buscarPorId(int id) {
        return reservaService.buscarPorId(id);
    }

    public void atualizar(Reserva reserva) {
        reservaService.atualizar(reserva);
    }

    public void remover(Reserva reserva) {
        reservaService.remover(reserva);
    }

}
