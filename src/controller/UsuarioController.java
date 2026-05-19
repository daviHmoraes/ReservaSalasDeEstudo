package controller;

import model.entity.Usuario;
import model.service.UsuarioService;

public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public void cadastrarUsuario(String nome, String cpf) {

        Usuario usuario = new Usuario(nome, cpf);

        boolean sucesso = usuarioService.cadastrar(usuario);

        if (sucesso) {

            System.out.println("Usuário cadastrado com sucesso!");

        } else {

            throw new IllegalArgumentException("ERRO: CPF já cadastrado.");
        }
    }

    public void listarUsuarios() {

        usuarioService.listar(null);
    }

    public void buscarUsuario(int id) {

        Usuario usuario = usuarioService.buscarPorId(id);

        if (usuario != null) {

            usuario.exibirDados();

        } else {
            throw new IllegalArgumentException("ERRO: Usuário não encontrado.");
        }
    }

    public void atualizarUsuario(int id, String nome, String cpf) {

        Usuario usuario = usuarioService.buscarPorId(id);

        if (usuario != null) {

            usuario.setNome(nome);
            usuario.setCpf(cpf);

            usuarioService.atualizar(usuario);

            System.out.println("Usuário atualizado com sucesso!");

        } else {

            throw new IllegalArgumentException("ERRO: Usuário não encontrado.");
        }
    }

    public void removerUsuario(int id) {

        try {

            usuarioService.remover(id);

            System.out.println("Usuário removido com sucesso!");

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
        }
    }
}