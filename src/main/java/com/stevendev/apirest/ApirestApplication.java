package com.stevendev.apirest;

import com.stevendev.apirest.domain.packages.Package;
import com.stevendev.apirest.service.packages.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;

@SpringBootApplication
public class ApirestApplication implements CommandLineRunner {

	@Autowired
	private PackageService packageService;

	public static void main(String[] args) {
		SpringApplication.run(ApirestApplication.class, args);
	}

	@Transactional
	@Override
	public void run(String... args) throws Exception {
		/*var myPackage = new Package();
		myPackage.setCode("C2023");
		myPackage.setWeight(35.0);
		myPackage.setSchedule(LocalDateTime.now());*/

		//packageService.save(myPackage);
	}
}
