package com.ibm.restaurant.clients;

import com.ibm.restaurant.application.clients.CustomerService;
import com.ibm.restaurant.domain.clients.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;

@RestController
@RequestMapping("api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerMapperService customerMapperService;

    @PostMapping
    public ResponseEntity<Void> createCustomer(@RequestBody CustomerDto customerDto){
        Customer customer = customerMapperService.mapToDomain(customerDto);
        customerService.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Long id){
        Customer customer = customerService.getCustomerById(id);
        return ResponseEntity.ok(customerMapperService.mapFromDomain(customer));
    }

    @GetMapping
    public ResponseEntity<HashSet<CustomerDto>> getCustomerList(){
        HashSet<Customer> customerList = customerService.getCustomerList();
        HashSet<CustomerDto> customerDtos = customerMapperService.mapFromDomain(customerList);
        return ResponseEntity.status(HttpStatus.OK).body(customerDtos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCustomerById(@PathVariable Long id, @RequestBody CustomerDto customerDto){
        Customer customer = customerMapperService.mapToDomain(customerDto);
        customerService.updateCustomerById(id, customer);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable Long id){
        customerService.deleteCustomerById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
