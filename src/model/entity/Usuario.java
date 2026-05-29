package model.entity;

public class Usuario {

    private static int idPlus = 1;
    private String nome;
    private int id;
    private String cpf;

    public Usuario(String nome, String cpf) {
        this.id = idPlus++;
        setNome(nome);
        setCpf(cpf);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {

        if(!nome.isBlank()) {
            this.nome = nome;
        } else {
            throw new RuntimeException("ERRO: Nome não pode ser vazio");
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPlus() {
        return idPlus;
    }

    public void setIdPlus(int idPlus) {
        this.idPlus = idPlus;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {

        if (!cpf.isBlank()) {
            this.cpf = cpf;
        } else {
            throw new RuntimeException("ERRO: CPF não pode ser vazio");
        }

    }

    public void exibirDados(){
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
    }
}
