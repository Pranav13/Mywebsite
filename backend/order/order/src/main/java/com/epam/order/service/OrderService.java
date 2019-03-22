package com.epam.order.service;

import com.epam.order.dto.OrderDto;
import com.epam.order.model.Order;

public interface OrderService {
	Order save(OrderDto order);

}
