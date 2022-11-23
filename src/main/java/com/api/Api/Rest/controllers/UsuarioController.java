package com.api.Api.Rest.controllers;

import com.api.Api.Rest.entities.Rol;
import com.api.Api.Rest.entities.Usuario;
import com.api.Api.Rest.services.UsuarioService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> getUsuarios(){
        return ResponseEntity.ok().body(usuarioService.getUsuarios());
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> getUser(@PathVariable Long id){
        return ResponseEntity.ok().body(usuarioService.getUserById(id));
    }
    @PostMapping("/usuarios/save")
    public ResponseEntity<Usuario> getUsuarios(@RequestBody Usuario usuario){
        URI uri =URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");
        responseHeaders.set("Access-Control-Allow-Headers","origin, content-type, accept, authorization");
        responseHeaders.set("Access-Control-Allow-Credentials", "true");

        responseHeaders.set("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");

        return ResponseEntity.created(uri).headers(responseHeaders)
                .body(usuarioService.saveUsuario(usuario));
    }
    @PostMapping("/rol/save")
    public ResponseEntity<Rol> saveRol(@RequestBody Rol rol){
        URI uri =URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/rol/save").toUriString());
        return ResponseEntity.created(uri).body(usuarioService.saveRol(rol));
    }

    @PostMapping("/rol/addtouser")
    public ResponseEntity<?> addRolToUser(@RequestBody RolToUserForm form){
        usuarioService.addRoleToUser(form.getEmail(),form.getRolName());
        return ResponseEntity.ok().build();
    }

    @Data
    class RolToUserForm {
        private String email;
        private String rolName;
    }
}