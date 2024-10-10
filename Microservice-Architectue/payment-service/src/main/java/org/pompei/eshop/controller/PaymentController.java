package org.pompei.eshop.controller;

import org.pompei.eshop.dto.CustomerOrder;
import org.pompei.eshop.dto.OrderEvent;
import org.pompei.eshop.dto.Payment;
import org.pompei.eshop.dto.PaymentEvent;
import org.pompei.eshop.dto.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class PaymentController {

	@Autowired
	PaymentRepository paymentRepository;

	@Autowired
	KafkaTemplate<String, PaymentEvent> kafkaTemplate;

	@Autowired
	KafkaTemplate<String, OrderEvent> orderKafkaTemplate;

	@KafkaListener(topics = "new-order", groupId = "orders-group")
	public void processPayment(String event) throws Exception {

		System.out.println("processing payment for order event" + event);
		OrderEvent orderEvent = new ObjectMapper().readValue(event, OrderEvent.class);
		CustomerOrder customerOrder = orderEvent.getCustomerOrder();
		Payment payment = new Payment();
		payment.setAmount(customerOrder.getAmount());
		payment.setMode(customerOrder.getPaymentMethod());
		payment.setOrderId(customerOrder.getOrderId());
		payment.setStatus("SUCCESS");

		try {
			
			orderKafkaTemplate.send("reversed-orders", orderEvent);
			
			/*
			 * paymentRepository.save(payment); PaymentEvent paymentEvent = new
			 * PaymentEvent(); paymentEvent.setCustomerOrder(customerOrder);
			 * paymentEvent.setType("SUCCESS"); kafkaTemplate.send("new-payment",
			 * paymentEvent);
			 */
		} catch (Exception e) {
			payment.setOrderId(customerOrder.getOrderId());
			payment.setStatus("FAILED");
			paymentRepository.save(payment);
			OrderEvent oe = new OrderEvent();
			orderEvent.setCustomerOrder(customerOrder);
			orderEvent.setType("ORDER_REVERSED");
			orderKafkaTemplate.send("reveresed-order", oe);
		}

	}

	private void testRollback() {
		// TODO Auto-generated method stub
		
	}

}
