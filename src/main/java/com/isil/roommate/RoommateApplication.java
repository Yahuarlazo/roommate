package com.isil.roommate;

import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

/**
 * Clase principal de la aplicación Spring Boot para Roommate.
 */
@SpringBootApplication
public class RoommateApplication {

    /**
     * Método principal que inicia la aplicación Spring Boot.
     *
     * @param args Argumentos de línea de comandos proporcionados al iniciar la aplicación.
     */
	public static void main(String[] args) {
		SpringApplication.run(RoommateApplication.class, args);
	}

    /**
     * Configuración de un bean Thymeleaf para integrar el dialecto de seguridad de Spring.
     *
     * @return Instancia de SpringSecurityDialect para su uso en las plantillas Thymeleaf.
     */
    @Bean
    public SpringSecurityDialect springSecurityDialect() {
        return new SpringSecurityDialect();
    }
}
