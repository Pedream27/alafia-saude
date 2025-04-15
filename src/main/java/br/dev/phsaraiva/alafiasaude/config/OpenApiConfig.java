package br.dev.phsaraiva.alafiasaude.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                .title("REST API Alafia Saúde ")
                        .version("1.0")
                        .description("REST API's RESTful forom 0 with Java , Spring Boot, Kubernetes and Docker")
                        .termsOfService("https://github.com/phsaraiva/alafia-saude")
                        .license(new License().name("Apache 2.0").url("https://github.com/phsaraiva/alafia-saude")));
    }
}
