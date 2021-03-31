package com.cp.sports.PaymentServiceTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cp.sports.dao.PaymentRepository;
import com.cp.sports.entities.Card;
import com.cp.sports.entities.Payment;
import com.cp.sports.services.PaymentService;

@SpringBootTest
public class PaymentServiceTest {

	@Autowired
	private PaymentService paymentService;
	static ArrayList<Payment> list = new ArrayList<>();

	@Test
	public void addPaymentTest() {
		LocalDate expiryDate = LocalDate.parse("2025-07-01");
		Card card=new Card( 3, "pranathi", "124", expiryDate, "SBI");
		Payment payment1 = new Payment(3, "debit", "paid",card);
		assertEquals(payment1.toString(), paymentService.addPayment(payment1).toString());
		list.add(payment1);

	}

	@Test
	public void removePaymentTest() {
		LocalDate expiryDate = LocalDate.parse("2025-07-01");
		Card card=new Card(4, "pranathi", "124", expiryDate, "SBI");
		Payment payment1 = new Payment(4, "debit", "paid", card);
		assertEquals(payment1.toString(), paymentService.addPayment(payment1).toString());
		assertEquals(payment1.toString(), paymentService.removePayment(4).toString());

	}

	@Test
	public void getPaymentDetailsTest() {
		LocalDate expiryDate = LocalDate.parse("2025-07-01");
		Card card=new Card( 5, "pranathi", "124", expiryDate, "SBI");
		Payment payment1 = new Payment(5, "debit", "paid",card);
		assertEquals(payment1.toString(), paymentService.addPayment(payment1).toString());
		list.add(payment1);

		assertEquals(payment1.toString(), paymentService.getPaymentDetails(5).toString());
	}

	@Test
	public void updatePaymentTest() {
		LocalDate expiryDate = LocalDate.parse("2025-07-01");
		Card card1=new Card(6, "pranathi", "124", expiryDate, "SBI");
		Payment payment1 = new Payment(6, "debit", "paid", card1);
		assertEquals(payment1.toString(), paymentService.addPayment(payment1).toString());
		expiryDate = LocalDate.parse("2025-07-01");
		Card card2=new Card( 7, "pranathi", "124", expiryDate, "SBI");
		Payment payment2 = new Payment(6, "debit", "paid",card2);
		list.add(payment2);
		assertEquals(payment2.toString(), paymentService.updatePayment(6, payment2).toString());
	}

	@Test
	void getAllPaymentDetailsTest() {
		LocalDate expiryDate = LocalDate.parse("2025-07-01");
		Card card=new Card( 8, "pranathi", "124", expiryDate, "SBI");
		Payment payment1 = new Payment(8, "debit", "paid",card);
		assertEquals(payment1.toString(), paymentService.addPayment(payment1).toString());
		list.add(payment1);

		assertEquals(list.toString(), paymentService.getAllPaymentDetails().toString());
	}

}
