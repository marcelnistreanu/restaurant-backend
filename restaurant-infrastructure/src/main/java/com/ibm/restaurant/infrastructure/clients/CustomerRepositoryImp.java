package com.ibm.restaurant.infrastructure.clients;

import com.ibm.restaurant.domain.clients.Customer;
import com.ibm.restaurant.domain.clients.iCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;

@Repository
public class CustomerRepositoryImp implements iCustomerRepository {

    @Autowired
    private iCustomerRepositorySdj iCustomerRepositorySdj;
    @Override
    public void createCustomer(Customer customer) {
        iCustomerRepositorySdj.save(customer);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return iCustomerRepositorySdj.findById(id).orElse(null);
    }

    @Override
    public HashSet<Customer> getCustomerList() {
        return new HashSet<>(iCustomerRepositorySdj.findAll());
    }

    @Override
    public void updateCustomerById(Customer customer) {
        iCustomerRepositorySdj.save(customer);
    }

    @Override
    public void deleteCustomerById(Customer customer) {
        iCustomerRepositorySdj.delete(customer);
    }
}
