package cn.gaoyuexiang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by melo on 16-7-2.
 * boot application
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class StartBoot {
	public static void main(String[] args) {
		SpringApplication.run(StartBoot.class, args);
	}
}
