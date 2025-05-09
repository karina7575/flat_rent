package com.javaacademy.demo.repository;

import com.javaacademy.demo.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository <Client, Integer> {
}
