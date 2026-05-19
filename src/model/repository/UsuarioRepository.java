package model.repository;

import model.entity.Usuario;

import java.util.HashMap;

public class UsuarioRepository {

    private HashMap<Integer, Usuario> listaUsuarios = new HashMap<>();

    public void salvar(Usuario usuario){
        listaUsuarios.put(usuario.getId(), usuario);
    }

    public Usuario buscarPorId(int id){
        return listaUsuarios.get(id);
    }

    public HashMap<Integer, Usuario> listar(){
        return listaUsuarios;
    }

    public void atualizar(Usuario usuario){
        listaUsuarios.put(usuario.getId(), usuario);
    }

    public void remover(int id){
        listaUsuarios.remove(id);
    }

}