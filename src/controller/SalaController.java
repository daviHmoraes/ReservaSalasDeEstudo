package controller;

import model.entity.Sala;
import model.service.SalaService;

public class SalaController {

    private SalaService salaService;

    public SalaController(SalaService salaService) {

        this.salaService = salaService;

    }

    public void cadastrarSala(int numero, int capacidade, boolean disponivel) {

        Sala sala = new Sala(numero, capacidade, disponivel);

        boolean sucesso = salaService.cadastrarSala(sala);

        if (sucesso) {
            System.out.println("Sala cadastrada com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar sala.");
        }

    }


    public void listarSalas() {
        if (salaService.listarSalas().isEmpty()) {
            System.out.println("Nenhuma sala cadastrada.");

            return;
        }

        for (Sala sala : salaService.listarSalas().values()) {
            sala.exibirDados();
            System.out.println();

        }

    }


    public void buscarSalaPorId(int id) {

        Sala sala = salaService.buscarPorID(id);

        if (sala != null) {

            sala.exibirDados();

        } else {

            System.out.println("Sala não encontrada.");

        }

    }


    public void atualizarSala(int id, int numero, int capacidade, boolean disponivel) {

        Sala sala = salaService.buscarPorID(id);

        if (sala == null) {

            System.out.println("Sala não encontrada.");

            return;

        }

        sala.setNumero(numero);
        sala.setCapacidade(capacidade);
        sala.setDisponivel(disponivel);

        boolean sucesso = salaService.atualizarSala(sala);

        if (sucesso) {

            System.out.println("Sala atualizada com sucesso!");

        } else {

            System.out.println("Erro ao atualizar sala.");

        }

    }


    public void removerSala(int id) {

        boolean sucesso = salaService.removerSala(id);

        if (sucesso) {

            System.out.println("Sala removida com sucesso!");

        } else {

            System.out.println("Sala não encontrada.");

        }

    }

}
