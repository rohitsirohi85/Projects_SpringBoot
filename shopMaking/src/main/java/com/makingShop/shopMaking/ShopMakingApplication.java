package com.makingShop.shopMaking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopMakingApplication implements CommandLineRunner{

	@Autowired
     configuringItems cgi;


	public static void main(String[] args) {
		SpringApplication.run(ShopMakingApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
	         System.out.println(cgi.deciding());
	}

}
