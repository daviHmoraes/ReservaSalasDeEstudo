package model.repository;

import model.entity.UsuarioEntity;

import java.util.Collection;
import java.util.HashMap;

public class UsuarioRepository {

    private UsuarioEntity usuario;
    private HashMap<Integer, UsuarioEntity> listaUsuarios = new HashMap<>();

    public void salvar(UsuarioEntity usuario){
        listaUsuarios.put(usuario.getId(), usuario);
    }

    public UsuarioEntity buscarPorId(int id){
        return listaUsuarios.get(id);
    }

    public HashMap<Integer, UsuarioEntity> listar(){
        return listaUsuarios;
    }

    public void atualizar(UsuarioEntity usuario){
        listaUsuarios.put(usuario.getId(), usuario);
    }

    public void remover(int id){
        listaUsuarios.remove(id);
    }

}