package com.cp.sports.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cp.sports.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Long> {

}
