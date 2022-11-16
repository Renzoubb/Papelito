package com.api.Api.Rest.services;

import com.api.Api.Rest.entities.Rol;
import com.api.Api.Rest.entities.Usuario;

import java.util.List;


public interface UsuarioService  {

    Usuario saveUsuario(Usuario usuario);
    Rol saveRol(Rol rol);

    void addRoleToUser(String username, String rolName);

    Usuario getUsuario(String nombreUsuario);

    List<Usuario> getUsuarios();

}