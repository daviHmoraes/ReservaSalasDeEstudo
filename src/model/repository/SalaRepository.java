package model.repository;

import model.entity.SalaEntity;

import java.util.HashMap;

public class SalaRepository {

    private HashMap<Integer, SalaEntity> salaHashMap;

    public SalaRepository() {

        salaHashMap = new HashMap<>();

    }

    public void salvar(SalaEntity salaEntity) {

        salaHashMap.put(salaEntity.getId(), salaEntity);

    }

    public SalaEntity buscarID(int id) {

        return salaHashMap.get(id);

    }

    public HashMap<Integer, SalaEntity> listarSala() {
        return salaHashMap;
    }

    public void removerSala(int id) {

        salaHashMap.remove(id);

    }

    public void atualizar(SalaEntity salaEntity) {

        salaHashMap.put(salaEntity.getId(), salaEntity);

    }

}
