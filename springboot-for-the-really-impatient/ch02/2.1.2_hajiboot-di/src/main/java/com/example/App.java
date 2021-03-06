package com.example;

import com.example.app.Argument;
import com.example.app.ArgumentResolver;
import com.example.app.Calculator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import java.util.Scanner;

@EnableAutoConfiguration
@Import(AppConfig.class)
public class App {

	public static void main(String[] args) {
		try (ConfigurableApplicationContext context = SpringApplication.run(App.class, args)) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter 2 numbers like 'a b': ");
			ArgumentResolver argumentResolver = context.getBean(ArgumentResolver.class);
			Argument argument = argumentResolver.resolve(System.in);
			Calculator calculator = context.getBean(Calculator.class);
			int result = calculator.calc(argument.getA(), argument.getB());
			System.out.println("result = " + result);
		}
	}
}
