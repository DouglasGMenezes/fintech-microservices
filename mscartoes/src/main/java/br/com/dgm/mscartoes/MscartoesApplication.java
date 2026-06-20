package br.com.dgm.mscartoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.math.BigDecimal;

@SpringBootApplication
@EnableDiscoveryClient
public class MscartoesApplication {

	public static void main(String[] args) {

		SpringApplication.run(MscartoesApplication.class, args);

		BigDecimal n1 = BigDecimal.valueOf(0.5);
		System.out.println(n1);
	}

}
