package model.entity;

public class UsuarioEntity {

    private String nome;
    private int id = 1;
    private int idPlus;
    private String cpf;

    public UsuarioEntity(String nome, String cpf) {
        this.id = idPlus++;
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        this.cpf = cpf;
    }

    public void exibirDados(){
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
    }
}
