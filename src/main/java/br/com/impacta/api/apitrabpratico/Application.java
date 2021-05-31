package br.com.impacta.api.apitrabpratico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
 
import br.com.impacta.api.apitrabpratico.repository.ClientRepository;

@EnableJpaRepositories(basePackageClasses = ClientRepository.class)
@SpringBootApplication
public class Application {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }
}
