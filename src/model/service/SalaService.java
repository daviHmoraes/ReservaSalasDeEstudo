package model.service;

import model.entity.SalaEntity;
import model.repository.SalaRepository;

import java.util.HashMap;

public class SalaService {

    private SalaRepository salaRepository;

    public SalaService() {

        salaRepository = new SalaRepository();

    }

    public boolean cadastrarSala(SalaEntity salaEntity) {
        if (salaEntity.getCapacidade() <= 0) {

            System.out.println("Capacidade inválida. ");
            return false;

        }

        //verifica se já existe sala com esse ID
        if (salaRepository.buscarID(salaEntity.getId()) != null) {

            System.out.println("Já existe uma sala cadastrada com esse ID. ");
            return false;

        }

        salaRepository.salvar(salaEntity);

        System.out.println();

        System.out.println("Sala cadastrada com sucesso. ");
        return true;
    }

    //buscar por ID

    public SalaEntity buscarPorID(int id){

    return salaRepository.buscarID(id);

    }

    //listar
    public HashMap<Integer, SalaEntity> listarSalas() {

        return salaRepository.listarSala();

    }

    //atualizar
    public boolean atualizarSala(SalaEntity salaEntityAtualizada) {

        if (salaRepository.buscarID(salaEntityAtualizada.getId()) == null) {

            System.out.println("Sala não encontrada. ");
            return false;

        }

        if (salaEntityAtualizada.getCapacidade() <= 0) {

            System.out.println("Capacidade inválida. ");
            return false;


        }

        salaRepository.atualizar(salaEntityAtualizada);

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