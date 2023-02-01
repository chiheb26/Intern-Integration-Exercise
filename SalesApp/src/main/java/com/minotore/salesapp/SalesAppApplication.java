package com.minotore.salesapp;

import com.minotore.salesapp.models.Sale;
import com.minotore.salesapp.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.UUID;

@SpringBootApplication
public class SalesAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SalesAppApplication.class, args);
	}

	@Autowired
	private SaleService saleService;
	@Override
	public void run(String... args) throws Exception {
		if (saleService.getAllSales().isEmpty()){
			Sale sale1= Sale.builder().id(UUID.randomUUID().toString()).bookName("book1")
					.libraryName("lib1").bookPrice(20.0).unitsSold(40L).build();

			Sale sale2= Sale.builder().id(UUID.randomUUID().toString()).bookName("book2")
					.libraryName("lib2").bookPrice(23.0).unitsSold(44L).build();
			Sale sale3= Sale.builder().id(UUID.randomUUID().toString()).bookName("book3")
					.libraryName("lib2").bookPrice(87.0).unitsSold(71L).build();
			saleService.createSale(sale1);
			saleService.createSale(sale2);
			saleService.createSale(sale3);
		}


	}
}
