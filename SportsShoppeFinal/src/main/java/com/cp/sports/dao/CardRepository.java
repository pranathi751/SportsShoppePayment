package com.cp.sports.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cp.sports.entities.Card;

public interface CardRepository extends JpaRepository<Card,Long> {

}
