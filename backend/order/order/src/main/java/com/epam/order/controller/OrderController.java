package com.epam.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.epam.order.dto.OrderDto;
import com.epam.order.model.Order;
import com.epam.order.model.response.Meta;
import com.epam.order.model.response.ResponseDTO;
import com.epam.order.service.OrderService;

@RestController
@CrossOrigin
public class OrderController {

	@Autowired
	OrderService orderservice;

	@PostMapping(value = "/order")
	ResponseEntity<ResponseDTO<Order>> postItem(@RequestBody OrderDto orderdto) {

		ResponseDTO<Order> responseDTO = new ResponseDTO<>();
		Meta meta = new Meta();

		Order order = null; 

		order = orderservice.save(orderdto);

		meta.setResponseCode("201");
		meta.setResponseMessage("Item Created");
		responseDTO.setMeta(meta);
		responseDTO.setBody(order);
		return new ResponseEntity<ResponseDTO<Order>>(responseDTO, HttpStatus.CREATED);

	}

}
