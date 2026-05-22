package view;

import controller.ReservaController;
import controller.SalaController;
import controller.UsuarioController;
import model.entity.Reserva;
import model.entity.Status;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class View {

    private UsuarioController usuarioController;
    private SalaController salaController;
    private ReservaController reservaController;
    private Scanner scanner;

    public View(UsuarioController usuarioController, SalaController salaController, ReservaController reservaController, Scanner scanner) {
        this.usuarioController = usuarioController;
        this.salaController = salaController;
        this.reservaController = reservaController;
        this.scanner = scanner;
    }

    public void exibirMenu() {

        int opcao = -1;

        do {

            System.out.println("======= SISTEMA DE RESERVAS =======");
            System.out.println("1. Gerenciar Usuários.");
            System.out.println("2. Gerenciar Salas");
            System.out.println("3. Gerenciar Reservas");
            System.out.println("0. Sair");
            System.out.println("====================================");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {

                case 1 -> { menuUsuario(); }
                case 2 -> { menuSala(); }
                case 3 -> { menuReserva(); }
                case 0 -> { System.out.println("Encerrando o sistema. Até logo!"); }
                default -> { System.out.println("Opção inválida. Tente novamente."); }

            }

            System.out.println();

        } while (opcao != 0);
    }

    private void menuUsuario() {

        int opcao = -1;

        do {

            System.out.println("========== MENU USUÁRIO ==========");
            System.out.println("1. Cadastrar Usuário");
            System.out.println("2. Listar Usuários");
            System.out.println("3. Buscar Usuário por ID");
            System.out.println("4. Atualizar Usuário");
            System.out.println("5. Remover Usuário");
            System.out.println("0. Voltar");
            System.out.println("==================================");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1 -> { cadastrarUsuario(); }
                case 2 -> { usuarioController.listarUsuarios(); }
                case 3 -> { buscarUsuario(); }
                case 4 -> { atualizarUsuario(); }
                case 5 -> { removerUsuario(); }
                case 0 -> { System.out.println("Voltando..."); }
                default -> { System.out.println("Opção inválida. Tente novamente."); }

            }

            System.out.println();

        } while (opcao != 0);
    }

    private void cadastrarUsuario() {

        System.out.println("\n--- Cadastrar Usuário ---");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        try {

            usuarioController.cadastrarUsuario(nome, cpf);

        } catch (RuntimeException e) {

            System.out.println(e.getMessage());
        }
    }

    private void buscarUsuario() {

        System.out.println("\n--- Buscar Usuário por ID ---");

        System.out.print("ID do usuário: ");
        int id = scanner.nextInt();

        try {

            usuarioController.buscarUsuario(id);

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
        }
    }

    private void atualizarUsuario() {

        System.out.println("\n--- Atualizar Usuário ---");

        System.out.print("ID do usuário: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();

        System.out.print("Novo CPF: ");
        String cpf = scanner.nextLine();

        try {

            usuarioController.atualizarUsuario(id, nome, cpf);

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
        }
    }

    private void removerUsuario() {

        System.out.println("\n--- Remover Usuário ---");

        System.out.print("ID do usuário: ");
        int id = scanner.nextInt();

        usuarioController.removerUsuario(id);
    }

    private void menuSala() {

        int opcao = -1;

        do {

            System.out.println("========== MENU SALA ==========");
            System.out.println("1. Cadastrar Sala");
            System.out.println("2. Listar Salas");
            System.out.println("3. Buscar Sala por ID");
            System.out.println("4. Atualizar Sala");
            System.out.println("5. Remover Sala");
            System.out.println("0. Voltar");
            System.out.println("================================");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1 -> { cadastrarSala(); }
                case 2 -> { salaController.listarSalas(); }
                case 3 -> { buscarSala(); }
                case 4 -> { atualizarSala(); }
                case 5 -> { removerSala(); }
                case 0 -> { System.out.println("Voltando..."); }
                default -> { System.out.println("Opção inválida. Tente novamente."); }

            }

            System.out.println();

        } while (opcao != 0);
    }

    private void cadastrarSala() {

        System.out.println("\n--- Cadastrar Sala ---");

        System.out.print("Número da sala: ");
        int numero = scanner.nextInt();

        System.out.print("Capacidade: ");
        int capacidade = scanner.nextInt();

        System.out.print("Disponível (true/false): ");
        boolean disponivel = scanner.nextBoolean();

        salaController.cadastrarSala(numero, capacidade, disponivel);
    }

    private void buscarSala() {

        System.out.println("\n--- Buscar Sala por ID ---");

        System.out.print("ID da sala: ");
        int id = scanner.nextInt();

        salaController.buscarSalaPorId(id);
    }

    private void atualizarSala() {

        System.out.println("\n--- Atualizar Sala ---");

        System.out.print("ID da sala: ");
        int id = scanner.nextInt();

        System.out.print("Novo número: ");
        int numero = scanner.nextInt();

        System.out.print("Nova capacidade: ");
        int capacidade = scanner.nextInt();

        System.out.print("Disponível (true/false): ");
        boolean disponivel = scanner.nextBoolean();

        salaController.atualizarSala(id, numero, capacidade, disponivel);
    }

    private void removerSala() {

        System.out.println("\n--- Remover Sala ---");

        System.out.print("ID da sala: ");
        int id = scanner.nextInt();

        salaController.removerSala(id);
    }

    private void menuReserva() {

        int opcao = -1;

        while (opcao != 0) {

            System.out.println("========== MENU RESERVA ==========");
            System.out.println("1. Cadastrar Reserva");
            System.out.println("2. Listar Reservas");
            System.out.println("3. Buscar Reserva por ID");
            System.out.println("4. Atualizar Reserva");
            System.out.println("5. Remover Reserva");
            System.out.println("0. Voltar");
            System.out.println("===================================");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1 -> { cadastrarReserva(); }
                case 2 -> { reservaController.listar(); }
                case 3 -> { buscarReserva(); }
                case 4 -> { atualizarReserva(); }
                case 5 -> { removerReserva(); }
                case 0 -> { System.out.println("Voltando..."); }
                default -> { System.out.println("Opção inválida. Tente novamente."); }

            }

            System.out.println();
        }
    }

    private void cadastrarReserva() {

        System.out.println("\n--- Cadastrar Reserva ---");

        System.out.print("ID do usuário: ");
        int idUsuario = scanner.nextInt();

        System.out.print("ID da sala: ");
        int idSala = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Data (AAAA-MM-DD): ");
        LocalDate data = LocalDate.parse(scanner.nextLine());

        System.out.print("Horário (HH:MM): ");
        LocalTime horario = LocalTime.parse(scanner.nextLine());

        try {

            Reserva reserva = new Reserva(null, null, data, horario, Status.AGUARDANDO);
            reservaController.cadastrar(reserva, idUsuario, idSala);
            System.out.println("Reserva cadastrada com sucesso!");

        } catch (RuntimeException e) {

            System.out.println(e.getMessage());
        }
    }

    private void buscarReserva() {

        System.out.println("\n--- Buscar Reserva por ID ---");

        System.out.print("ID da reserva: ");
        int id = scanner.nextInt();

        Reserva reserva = reservaController.buscarPorId(id);

        if (reserva != null) {

            reserva.exibirDados();

        } else {

            System.out.println("Reserva não encontrada.");
        }
    }

    private void atualizarReserva() {

        System.out.println("\n--- Atualizar Reserva ---");

        System.out.print("ID da reserva: ");
        int id = scanner.nextInt();

        Reserva reserva = reservaController.buscarPorId(id);

        if (reserva == null) {

            System.out.println("Reserva não encontrada.");
            return;
        }

        System.out.print("Nova data (AAAA-MM-DD): ");
        LocalDate data = LocalDate.parse(scanner.nextLine());

        System.out.print("Novo horário (HH:MM): ");
        LocalTime horario = LocalTime.parse(scanner.nextLine());

        System.out.println("Novo status:");
        System.out.println("1. AGUARDANDO");
        System.out.println("2. FINALIZADA");
        System.out.print("Escolha: ");

        int opcaoStatus = scanner.nextInt();
        Status status = (opcaoStatus == 2) ? Status.FINALIZADA : Status.AGUARDANDO;

        reserva.setData(data);
        reserva.setHorario(horario);
        reserva.setStatus(status);

        try {

            reservaController.atualizar(reserva);
            System.out.println("Reserva atualizada com sucesso!");

        } catch (RuntimeException e) {

            System.out.println(e.getMessage());
        }
    }

    private void removerReserva() {

        System.out.println("\n--- Remover Reserva ---");

        System.out.print("ID da reserva: ");
        int id = scanner.nextInt();

        Reserva reserva = reservaController.buscarPorId(id);

        if (reserva == null) {

            System.out.println("Reserva não encontrada.");
            return;
        }

        try {

            reservaController.remover(reserva);
            System.out.println("Reserva removida com sucesso!");

        } catch (RuntimeException e) {

            System.out.println(e.getMessage());
        }
    }
}