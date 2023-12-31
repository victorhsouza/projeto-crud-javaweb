package com.senai.quartaaplicacaoweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Configuration;

import java.util.zip.DataFormatException;


@Configuration
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class QuartaaplicacaowebApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuartaaplicacaowebApplication.class, args);
	}

}
