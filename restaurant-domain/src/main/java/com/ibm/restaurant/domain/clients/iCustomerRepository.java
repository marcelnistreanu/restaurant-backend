package com.ibm.restaurant.domain.clients;

import java.util.HashSet;

public interface iCustomerRepository {

    void createCustomer(Customer customer);

    Customer getCustomerById(Long id);

    HashSet<Customer> getCustomerList();

    void updateCustomerById(Customer customer);

    void deleteCustomerById(Customer customer);
}
