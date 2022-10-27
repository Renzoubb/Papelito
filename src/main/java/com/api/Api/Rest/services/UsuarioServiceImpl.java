package com.api.Api.Rest.services;
import com.api.Api.Rest.entities.Producto;
import com.api.Api.Rest.entities.Usuario;
import com.api.Api.Rest.repositories.BaseRepository;
import com.api.Api.Rest.repositories.ProductoRepository;
import com.api.Api.Rest.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Long> implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    public UsuarioServiceImpl(BaseRepository<Usuario,Long> baseRepository){
        super(baseRepository);
    }

    @Override
    @Transactional
    public List<Usuario> MostrarUsuarios() throws Exception{
        try{
            List<Usuario> usuarios = usuarioRepository.findAll();
            return usuarios;
        }catch (Exception e ){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Usuario BuscarUsuarioPorId (Long id) throws Exception{
        try{
            Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
            return usuarioOptional.get();
        }catch (Exception e ){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Usuario CreateUsuario(Usuario entity) throws Exception{
        try{
            entity = usuarioRepository.save(entity);
            return entity;
        }catch (Exception e ){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Usuario ActualizarUsuario(Long id, Usuario entity) throws Exception{
        try{
            Optional<Usuario> entityOptional = usuarioRepository.findById(id);
            Usuario usuario = entityOptional.get();
            usuario = usuarioRepository.save(entity);
            return usuario;
        }catch (Exception e ){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    @Transactional
    public boolean EliminarUsuario(Long id) throws Exception{
        try{
            if (usuarioRepository.existsById(id)){
                usuarioRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        }catch (Exception e ){
            throw new Exception(e.getMessage());
        }
    }
}
