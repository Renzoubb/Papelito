package com.api.Api.Rest.controllers;

import com.api.Api.Rest.entities.Usuario;
import com.api.Api.Rest.services.UsuarioService;
import com.api.Api.Rest.services.UsuarioServiceImpl;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/usuarios")
public class UsuarioController extends BaseControllerImpl<Usuario, UsuarioServiceImpl> {

    private UsuarioService usuarioService;
    public UsuarioController (UsuarioService usuarioService){
       this.usuarioService = usuarioService;
   }
    @GetMapping("")
    public ResponseEntity<?> MostrarUsuarios(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(usuarioService.MostrarUsuarios());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error.Por favor intente mas tarde.\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> BuscarUsuarioPorId(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error.Por favor intente mas tarde.\"}");
        }
    }
    @PostMapping("")
    public ResponseEntity<?> CreateUsuario(@RequestBody Usuario entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioService.save(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error.Por favor intente mas tarde.\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> ActualizarUsuario(@PathVariable Long id,@RequestBody Usuario entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioService.update(id,entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error.Por favor intente mas tarde.\"}");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> EliminarUsuario(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(usuarioService.delete(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error.Por favor intente mas tarde.\"}");
        }
    }
}