package com.gigistore.ordermanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gigistore.ordermanagement.entities.Order;

@Service
public class OrderService {
	
	@Autowired
	private ShippingService shippingService;
	
	public double total(Order order) {
		double discount = order.getDiscount() / 100;
		double total = order.getBasic() - ((order.getBasic() * discount));
		total = total + shippingService.shipment(order);
		return total;
	}

}
