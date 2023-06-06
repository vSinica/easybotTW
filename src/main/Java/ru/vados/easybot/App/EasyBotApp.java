package ru.vados.easybot.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages = "ru.vados.easybot")
@EnableWebMvc
public class EasyBotApp {
    public static void main(String[] args) {SpringApplication.run(EasyBotApp.class, args);}
}
