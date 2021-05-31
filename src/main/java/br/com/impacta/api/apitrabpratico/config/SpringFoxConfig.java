package br.com.impacta.api.apitrabpratico.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.builders.RequestHandlerSelectors;

@Configuration
public class SpringFoxConfig {
    @Bean
    public Docket clientApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.impacta.api.apitrabpratico"))
                .paths(PathSelectors.any())
                .build();
    }
}
