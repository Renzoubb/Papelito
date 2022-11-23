package com.api.Api.Rest;

import com.api.Api.Rest.entities.Rol;
import com.api.Api.Rest.entities.Usuario;
import com.api.Api.Rest.services.UsuarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;

@SpringBootApplication
public class ApiRestApplication {

	public static void main(String[] args) {

		final ApplicationContext ctx = SpringApplication.run(ApiRestApplication.class, args);
	}


	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UsuarioService usuarioService) {


		return args -> {
			usuarioService.saveRol(new Rol(null, "ROL_USUARIO"));
			usuarioService.saveRol(new Rol(null, "ROL_ADMIN"));

			usuarioService.saveUsuario(new Usuario("John","Trabalta","johntrabalta@gmail.com", "1234",null,new ArrayList<>(), null));
			usuarioService.saveUsuario(new Usuario("Jim","Carrey","jimcarrey@gmail.com", "123456",null,new ArrayList<>(), null));

			usuarioService.addRoleToUser("johntrabalta@gmail.com","ROL_USUARIO");
			usuarioService.addRoleToUser("jimcarrey@gmail.com","ROL_ADMIN");

		};
	}
	/*@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://127.0.0.1:5173");
			}
		};
	}*/
}
