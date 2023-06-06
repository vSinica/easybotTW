package ru.vados.easybot.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"ru.vados.easybot"})
@PropertySource(value = {
        "classpath:config/application-main.yml"}, factory = YamlPropertySourceFactory.class)
public class ConfigProperties {
}
