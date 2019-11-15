package ru.otus.springquartzexample.config;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    XmlMapper xmlMapper() {
        return new XmlMapper();
    }
}
