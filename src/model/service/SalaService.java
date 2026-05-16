package model.service;

import model.entity.Sala;
import model.repository.SalaRepository;


public class SalaService {

    public SalaService() {

        SalaRepository salaRepository;

    }

    public boolean cadastrarSala(Sala sala) {
        if (sala.getCapacidade() <= 0) {

            System.out.println("Capacidade inválida. ");
            return false;

        }
    }
}