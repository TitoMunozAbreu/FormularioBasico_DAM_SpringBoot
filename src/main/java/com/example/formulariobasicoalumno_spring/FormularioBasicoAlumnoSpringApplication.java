package com.example.formulariobasicoalumno_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.thymeleaf.dialect.springdata.SpringDataDialect;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.formulariobasicoalumno_spring.respositorio")
public class FormularioBasicoAlumnoSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(FormularioBasicoAlumnoSpringApplication.class, args);
    }


    /** Añadir el dialecto de paginación al thymeleaf
     * This will introduce the sd namespace, and the new attribute processors that you to use in your pages
     * @return
     */
    @Bean
    public SpringDataDialect springDataDialect() {
        return new SpringDataDialect();
    }
}
