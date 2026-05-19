package model.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva {

    private int id;
    private static int idContador = 1;
    private Usuario usuario;
    private Sala sala;
    private LocalDate data;
    private LocalTime horario;
    private Status status;

    public Reserva(Usuario usuario, Sala sala, LocalDate data, LocalTime horario, Status status) {
        this.id = idContador++;
        this.usuario = usuario;
        this.sala = sala;
        this.data = data;
        this.horario = horario;
        this.status = status;
    }

    // |-------------| Getters e Setters |-------------|

    public int getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void exibirDados() {
        System.out.println("ID: " + id);
        System.out.println("Usuario: " + usuario.getNome());
        System.out.println("Sala: " + sala.getNumero());
        System.out.println("Data: " + data);
        System.out.println("Horario: " + horario);
        System.out.println("Status: " + status);
    }

}
