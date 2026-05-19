package model.entity;

public class SalaEntity {

    private int id;
    private static int idContador = 1;
    private int numero;
    private int capacidade;
    private boolean disponivel;

    public SalaEntity(int numero, int capacidade, boolean disponivel) {

        this.id = idContador++;
        this.numero = numero;
        this.capacidade = capacidade;
        this.disponivel = disponivel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }


    public void exibirDados() {
        System.out.println("ID: " + id);
        System.out.println("Número: " + numero);
        System.out.println("Capacidade: " + capacidade);
        System.out.println("Status: " + disponivel);

    }
}

