package jcliew.sb_service_discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SbServiceDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbServiceDiscoveryApplication.class, args);
	}

}
