package com.cp.sports.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cp.sports.entities.Payment;
import com.cp.sports.exceptions.PaymentServiceException;
import com.cp.sports.services.PaymentService;

import io.swagger.annotations.Api;

@Api(value = "Swagger2DemoRestController")
@RestController
@RequestMapping("/")
public class PaymentController {

	@Autowired

	private PaymentService paymentService;

	@PostMapping("/addPayment")
	public ResponseEntity<Payment> addPayment(@RequestBody Payment payment) {
		Payment resultpayment = paymentService.addPayment(payment);
		return new ResponseEntity<Payment>(resultpayment, HttpStatus.OK);
	}

	@DeleteMapping("/removePayment/{id}")
	public ResponseEntity<Payment> removePayment(@PathVariable long id){
		Payment resultpayment =paymentService.removePayment(id);
		return new ResponseEntity<Payment>(resultpayment, HttpStatus.OK);
	}

	@PutMapping("/updatePayment/{id}")
	public ResponseEntity<Payment> updatePayment(@RequestBody long id,Payment payment) {
		Payment resultPayment = paymentService.updatePayment(id, payment);
		return new ResponseEntity<Payment>(resultPayment, HttpStatus.OK);
	}

	@GetMapping("/getPaymentDetails/{id}")
	public ResponseEntity<Payment> GetPaymentDetails(@PathVariable long id){
		Payment resultPayment = paymentService.getPaymentDetails(id);
		return new ResponseEntity<Payment>(resultPayment, HttpStatus.OK);
	}

	@GetMapping("/getAllPaymentDetails/all")
	public ResponseEntity<List<Payment>> getAllPayment() {
		List<Payment> resultPayment = paymentService.getAllPaymentDetails();
		return new ResponseEntity<List<Payment>>(resultPayment, HttpStatus.OK);
	}

}
