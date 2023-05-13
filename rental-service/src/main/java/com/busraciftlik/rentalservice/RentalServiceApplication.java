package com.busraciftlik.rentalservice;

import com.busraciftlik.common.util.constants.Paths;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {Paths.ConfigurationBasePackage, Paths.Rental.ServiceBaePackage})
public class RentalServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentalServiceApplication.class, args);
    }

}