package music.microservices.musicinfoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MusicInfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicInfoServiceApplication.class, args);
	}

}
