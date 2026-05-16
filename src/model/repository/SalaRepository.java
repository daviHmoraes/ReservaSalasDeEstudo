package model.repository;

import model.entity.Sala;

import java.util.HashMap;

public class SalaRepository {

    private HashMap<Integer, Sala> salaHashMap;

    public SalaRepository() {

        salaHashMap = new HashMap<>();

    }

    public void salvar(Sala sala) {

        salaHashMap.put(sala.getId(), sala);

    }

    public Sala buscarID(int id) {

        return salaHashMap.get(id);

    }

    public HashMap<Integer, Sala> listarSala() {
        return salaHashMap;
    }

    public void removerSala(int id) {

        salaHashMap.remove(id);

    }

}
