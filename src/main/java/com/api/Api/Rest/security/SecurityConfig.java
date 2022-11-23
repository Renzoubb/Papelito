package com.api.Api.Rest.security;
import com.api.Api.Rest.filter.CustomAuthenticationFilter;
import com.api.Api.Rest.filter.CustomAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.security.config.http.SessionCreationPolicy.*;

@Configuration @EnableWebSecurity @RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter =  new CustomAuthenticationFilter(authenticationManagerBean());
        customAuthenticationFilter.setFilterProcessesUrl("/api/v1/login");
        http.cors().and().csrf().disable(); //con esto se deshabilita la falsificación de solicitudes entre sitios
        http.sessionManagement().sessionCreationPolicy(STATELESS); //politica de administración de sesiones

        http.authorizeRequests().antMatchers(POST,"/api/v1/login").permitAll();

        http.authorizeRequests().antMatchers(GET,"/api/v1/productos/**").permitAll();
        http.authorizeRequests().antMatchers(GET,"/api/v1/ciudades/**").permitAll();
        http.authorizeRequests().antMatchers(GET,"/api/v1/categorias/**").permitAll();
        http.authorizeRequests().antMatchers(POST,"/api/v1/usuarios/save").permitAll();
        http.authorizeRequests().antMatchers(GET,"/api/v1/usuarios/**").hasAnyAuthority("ROL_USUARIO","ROL_ADMIN");
        http.authorizeRequests().antMatchers(POST,"/api/v1/rol/save").hasAnyAuthority("ROL_ADMIN");
        http.authorizeRequests().antMatchers(POST,"/api/v1/rol/save").hasAnyAuthority("ROL_ADMIN");
        http.authorizeRequests().antMatchers(POST,"/api/v1/rol/addtouser").hasAnyAuthority("ROL_ADMIN");
        http.authorizeRequests().antMatchers(POST,"/api/v1/pedidos/create-pedido").hasAnyAuthority("ROL_USUARIO");
        http.authorizeRequests().antMatchers(GET,"/api/v1/pedidos/detalle/**").hasAnyAuthority("ROL_USUARIO");
        http.authorizeRequests().antMatchers(GET,"/api/v1/pedidos/detalle").hasAnyAuthority("ROL_ADMIN");
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(customAuthenticationFilter); //filtro para authenticar a los usuarios
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }



}
