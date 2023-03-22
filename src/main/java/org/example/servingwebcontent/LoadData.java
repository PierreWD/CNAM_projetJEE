package org.example.servingwebcontent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadData {
    private static final Logger log = LoggerFactory.getLogger(ServingWebContentApplication.class);
    @Bean
    CommandLineRunner initData(ContactRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Contact("Joel")));
            log.info("Preloading " + repository.save(new Contact("Elie")));
            log.info("Preloading " + repository.save(new Contact("Michel","Strasbourg","michel@hotmail.com")));
        };
    }
}
