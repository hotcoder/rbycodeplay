package demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@RestController
@ConfigurationProperties(prefix="mine")
public class Application {

	@Value("${name}")
	private String name;
	
	private String location ;
	

	@RequestMapping("/")
	public String sayHI() {
		return "How Are you" + this.location;
	}

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

}
