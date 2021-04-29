package ru.ekhlusov.bill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Evgeniy Khlusov
 * 28.04.2021
 */

@SpringBootApplication
@EnableDiscoveryClient
public class BillApplication {
	public static void main(String[] args) {
		SpringApplication.run(BillApplication.class, args);
	}
}
