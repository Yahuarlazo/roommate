package com.isil.roommate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.isil.roommate.service.UserDetailsServiceImpl;

/**
 * Configuración de seguridad para la aplicación.
 *
 * <p>
 * Esta clase configura la seguridad de la aplicación utilizando Spring Security.
 * Define reglas de autorización y autenticación, así como un bean para la codificación
 * de contraseñas. Se basa en la extensión de WebSecurityConfigurerAdapter.
 * </p>
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    /**
     * Configura las reglas de autorización y autenticación.
     *
     * @param http El objeto HttpSecurity para configurar la seguridad web.
     * @throws Exception Si hay un error durante la configuración.
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin()
                .loginPage("/login").permitAll()
            .and()
                .authorizeRequests()
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .antMatchers("/recep/**").hasRole("RECEPCIONISTA")
                    .antMatchers("/**").authenticated()
            .and()
                .logout()
                    .logoutSuccessUrl("/login")
            .and()
                .csrf()
                    .disable();
    }

    /**
     * Configura el codificador de contraseñas como un bean.
     *
     * @return El objeto PasswordEncoder para codificar y verificar contraseñas.
     */
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Configura el servicio de detalles de usuario y el codificador de contraseñas.
     *
     * @param auth El objeto AuthenticationManagerBuilder para configurar la autenticación.
     * @throws Exception Si hay un error durante la configuración.
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(encoder());
    }

}
