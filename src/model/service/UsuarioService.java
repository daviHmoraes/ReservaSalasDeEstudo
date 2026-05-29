package model.service;

import model.entity.Usuario;
import model.repository.UsuarioRepository;

public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public boolean cadastrar(Usuario usuario) {

        for (Usuario usuarios : usuarioRepository.listar().values()) {
                if(usuarios.getCpf().equals(usuario.getCpf())){
                    return false;
                }
        }
        usuarioRepository.salvar(usuario);
        return true;
    }

    public void listar(UsuarioRepository usuario){
        for(Usuario usuarios : usuarioRepository.listar().values()){
            usuarios.exibirDados();
            System.out.println("------------");
        }
    }

    public Usuario buscarPorId(int id){
        return usuarioRepository.buscarPorId(id);
    }

    public void atualizar(Usuario usuarios){
        if(usuarioRepository.buscarPorId(usuarios.getId()) !=null){
            usuarioRepository.atualizar(usuarios);
        }else{
            throw new IllegalArgumentException("ERRO: ID não encontrado.");
        }
    }

    public void remover(int id){
        if(usuarioRepository.buscarPorId(id) != null){
            usuarioRepository.remover(id);
        }else {
            throw new IllegalArgumentException("ERRO: ID não encontrado.");
        }
    }
}