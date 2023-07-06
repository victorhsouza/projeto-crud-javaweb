package com.senai.quartaaplicacaoweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.zip.DataFormatException;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class QuartaaplicacaowebApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuartaaplicacaowebApplication.class, args);
	}

}
