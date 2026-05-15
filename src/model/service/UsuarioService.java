package model.service;

import model.entity.UsuarioEntity;
import model.repository.UsuarioRepository;

public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public boolean cadastrar(UsuarioEntity usuario) {

        for (UsuarioEntity usuarios : usuarioRepository.listar().values()) {
                if(usuarios.getCpf().equals(usuarios.getCpf())){
                    return false;
                }
        }
        return true;
    }

    public void listar(UsuarioRepository usuario){
        for(UsuarioEntity usuarios : usuarioRepository.listar().values()){
            usuarios.exibirDados();
            System.out.println("------------");
        }
    }

    public UsuarioEntity buscarPorId(int id){
        return usuarioRepository.buscarPorId(id);
    }

    public void atualizar(UsuarioEntity usuarios){
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