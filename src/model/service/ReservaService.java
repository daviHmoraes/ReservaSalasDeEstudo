package model.service;

import model.entity.Reserva;
import model.entity.Sala;
import model.entity.Usuario;
import model.repository.*;

public class ReservaService {

    private final ReservaRepository reservaRepository = new ReservaRepository();
    private final UsuarioRepository usuarioRepository = new UsuarioRepository();
    private final SalaRepository salaRepository = new SalaRepository();

    public void cadastrar(Reserva reserva, int idUsuario, int idSala) {

        Usuario usuario = usuarioRepository.buscarPorId(idUsuario);
        Sala sala = salaRepository.buscarID(idSala);

        if(usuario == null || sala == null) {
            throw new RuntimeException("ERRO: Sala e/ou Usuario invalido");
        }

        if(!sala.isDisponivel()){
            throw new RuntimeException("ERRO: Sala indisponivel");
        }

        reserva.setSala(sala);
        reserva.setUsuario(usuario);

        sala.setDisponivel(false);
        salaRepository.atualizar(sala);

        reservaRepository.salvar(reserva);
    }

    public void listar() {
        for(Reserva reserva : reservaRepository.listar().values()) {
            reserva.exibirDados();
        }
    }

    public Reserva buscarPorId(int id) {
        return reservaRepository.buscarPorId(id);
    }

    public void atualizar(Reserva reserva) {
        if (reservaRepository.buscarPorId(reserva.getId()) != null) {
            reservaRepository.atualizar(reserva);
        } else {
            throw new RuntimeException("ERRO: Reserva não encontrada");
        }
    }

    public void remover(Reserva reserva) {
        if (reservaRepository.buscarPorId(reserva.getId()) != null) {
            reserva.getSala().setDisponivel(true);
            salaRepository.atualizar(reserva.getSala());
            reservaRepository.remover(reserva);
        } else {
            throw new RuntimeException("ERRO: Reserva não encontrada");
        }
    }

}
