package com.ibm.restaurant.infrastructure.clients;

import com.ibm.restaurant.domain.clients.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iCustomerRepositorySdj extends JpaRepository<Customer, Long> {
}
