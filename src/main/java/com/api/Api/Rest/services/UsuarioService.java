package com.api.Api.Rest.services;

import com.api.Api.Rest.entities.Producto;
import com.api.Api.Rest.entities.Usuario;


import java.util.List;


public interface UsuarioService extends BaseService<Usuario, Long > {
    public List<Usuario> MostrarUsuarios() throws Exception;
    public Usuario BuscarUsuarioPorId(Long id) throws Exception;
    public Usuario CreateUsuario(Usuario entity) throws Exception;
    public Usuario ActualizarUsuario(Long id, Usuario entity) throws Exception;
    public boolean EliminarUsuario(Long id) throws Exception;

}