package liberty.fianzas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@EnableWebMvc
@SpringBootApplication
public class LibertyFianzasApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibertyFianzasApplication.class, args);
	}

}
