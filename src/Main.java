import model.repository.ReservaRepository;
import model.repository.SalaRepository;
import model.repository.UsuarioRepository;
import model.service.ReservaService;
import model.service.SalaService;
import model.service.UsuarioService;
import view.View;
import java.util.Scanner;

import controller.*;

public class Main {
    public static void main(String[] args) {

        SalaRepository salaRepository = new SalaRepository();
        SalaService salaService = new SalaService(salaRepository);
        SalaController salaController = new SalaController(salaService);

        UsuarioRepository usuarioRepository = new UsuarioRepository();
        UsuarioService usuarioService = new UsuarioService(usuarioRepository);
        UsuarioController usuarioController = new UsuarioController(usuarioService);

        ReservaRepository reservaRepository = new ReservaRepository();
        ReservaService reservaService = new ReservaService(reservaRepository);
        ReservaController reservaController = new ReservaController(reservaService);

        Scanner scanner = new Scanner(System.in);

        View view = new View(usuarioController, salaController, reservaController, scanner);

        while (true) {
            view.exibirMenu();
        }
    }
}