package com.epam.order.service.Impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.order.dto.OrderDto;
import com.epam.order.dto.OrderDto.Item;
import com.epam.order.model.Order;
import com.epam.order.model.Product;
import com.epam.order.model.Shipping;
import com.epam.order.repository.OrderRepository;
import com.epam.order.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public Order save(OrderDto order) {
		// TODO Auto-generated method stub
		Order orderEntity = new Order();
		Shipping shippingEntity = new Shipping();
		try {
			orderEntity.setOrderdate(new SimpleDateFormat("yy-MM-dd HH:mm:ss").parse(order.datePlaced));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		shippingEntity.setAddressLine1(order.shipping.addressLine1);
		shippingEntity.setAddressLine2(order.shipping.addressLine2);
		shippingEntity.setCity(order.shipping.city);
		shippingEntity.setName(order.shipping.name);
		
		orderEntity.setShipping(shippingEntity);
		
		orderEntity.setUserid(order.userId);
		
		List<Product> orderproduct = new ArrayList<>();
		
		
		List<Item> item = Arrays.asList(order.items);
		 for(Item eachitem:item) {
			 Product productEntity = new Product();
			 productEntity.setImageUrl(eachitem.product.imageUrl);
			 productEntity.setPrice(eachitem.product.price);
			 productEntity.setTitle(eachitem.product.title);
			 productEntity.setQuantity(eachitem.quantity);
			 productEntity.setTotalprice(eachitem.product.price * eachitem.quantity );
			 orderproduct.add(productEntity);
			 orderEntity.setOrderproduct(orderproduct);
		 }
		
		return orderRepository.save(orderEntity);	
	}
}
