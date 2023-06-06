package ru.vados.easybot.Config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = {"ru.vados.easybot.Controller", "ru.vados.easybot.Service"})
@EnableJpaRepositories(basePackages = "ru.vados.easybot.Repository")
@EntityScan(basePackages = {"ru.vados.easybot.Entity"})
public class ServiceConfig {

}
