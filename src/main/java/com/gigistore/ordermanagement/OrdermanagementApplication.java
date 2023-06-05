package com.gigistore.ordermanagement;

import java.util.Locale;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gigistore.ordermanagement.entities.Order;
import com.gigistore.ordermanagement.services.OrderService;

@SpringBootApplication
public class OrdermanagementApplication implements CommandLineRunner {
	
	@Autowired
	private OrderService orderService;
	
	public static void main(String[] args) {
		SpringApplication.run(OrdermanagementApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Order order = new Order();
		order.setCode(1034);
		order.setBasic(150.);
		order.setDiscount(20.);

		System.out.println("Pedido código " + order.getCode());
		Locale.setDefault(Locale.US);
		System.out.printf("Valor total: R$ %.2f" , orderService.total(order));

	}

}
