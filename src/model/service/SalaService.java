package model.service;

import model.entity.Sala;
import model.repository.SalaRepository;

import java.util.HashMap;

public class SalaService {

    private SalaRepository salaRepository;

    public SalaService() {

        salaRepository = new SalaRepository();

    }

    public boolean cadastrarSala(Sala sala) {
        if (sala.getCapacidade() <= 0) {

            System.out.println("Capacidade inválida. ");
            return false;

        }

        //verifica se já existe sala com esse ID
        if (salaRepository.buscarID(sala.getId()) != null) {

            System.out.println("Já existe uma sala cadastrada com esse ID. ");
            return false;

        }

        salaRepository.salvar(sala);

        System.out.println();

        System.out.println("Sala cadastrada com sucesso. ");
        return true;
    }

    //buscar por ID

    public Sala buscarPorID(int id){

    return salaRepository.buscarID(id);

    }

    //listar
    public HashMap<Integer, Sala> listarSalas() {

        return salaRepository.listarSala();

    }

    //atualizar
    public boolean atualizarSala(Sala salaAtualizada) {

        if (salaRepository.buscarID(salaAtualizada.getId()) == null) {

            System.out.println("Sala não encontrada. ");
            return false;

        }

        if (salaAtualizada.getCapacidade() <= 0) {

            System.out.println("Capacidade inválida. ");
            return false;


        }

        salaRepository.atualizar(salaAtualizada);

        System.out.println("Sala atualizada com sucesso. ");
        return true;

    }

    //remover
    public boolean removerSala(int id){

        if (salaRepository.buscarID(id) == null){

            System.out.println("Sala não encontrada. ");
            return false;

        }

        salaRepository.removerSala(id);

        System.out.println("Sala removida com sucesso. ");

        return true;

    }

}