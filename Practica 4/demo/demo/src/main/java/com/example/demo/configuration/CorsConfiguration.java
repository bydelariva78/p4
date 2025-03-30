package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {

    //He creado esta clase porque no me dejaba ejecutar el fetch desde mi html que estaba siendo ejecutado
    //por en mis archivos del ordenador. Me ponia que era debido a la CORS policy cuando hacia un
    // console.log() de mi json resultante del fetch
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Permitir todas las rutas
                        .allowedOrigins("*") // Permitir cualquier origen
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
                        .allowedHeaders("*") // Permitir cualquier encabezado
                        .allowCredentials(false); // No permitir credenciales
            }
        };
    }
}
