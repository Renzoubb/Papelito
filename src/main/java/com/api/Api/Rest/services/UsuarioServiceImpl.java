package com.api.Api.Rest.services;
import com.api.Api.Rest.entities.Rol;
import com.api.Api.Rest.entities.Usuario;
import com.api.Api.Rest.repositories.RolRepository;
import com.api.Api.Rest.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findUsuario(email);
        if(usuario==null){
            log.error("usuario no encontrado en la base de datos");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("Usuario encontrado en la base de datos: {}", email);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        usuario.getRoles().forEach(rol -> {
            authorities.add(new SimpleGrantedAuthority(rol.getName()));
        });
        return new org.springframework.security.core.userdetails.User(usuario.getEmail(), usuario.getPassword(), authorities);
    }

    public Usuario saveUsuario(Usuario usuario) {

        if(usuario.getId() == null && usuario.getPassword() == null){
            Usuario usuario1 = usuarioRepository.findUsuarioById(usuario.getId());
            usuario.setPassword(usuario1.getPassword());

        }else{
            log.info("Guardando un nuevo usuario en la base de datos");
            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        }
        return usuarioRepository.save(usuario);

    }


    public Rol saveRol(Rol rol) {
        log.info("Guardando un nuevo rol en la base de datos " + rol.getName());
        return rolRepository.save(rol);
    }


    public void addRoleToUser(String email, String rolName) {
        log.info("Agregando rol {} a usuario {} ",rolName,email);
        Usuario usuario = usuarioRepository.findUsuario(email);
        Rol rol = rolRepository.findByName(rolName);
        usuario.getRoles().add(rol);
    }


    public Usuario getUsuario(String email) {
        log.info("Trayendo usuario {}",email);
        return usuarioRepository.findUsuario(email);
    }
    public Usuario getUserById(Long id) {
        log.info("Trayendo usuario {}",id);
        return usuarioRepository.findUsuarioById(id);
    }


    public List<Usuario> getUsuarios() {
        log.info("Trayendo todos los usuarios");
        return usuarioRepository.findAll();
    }


}