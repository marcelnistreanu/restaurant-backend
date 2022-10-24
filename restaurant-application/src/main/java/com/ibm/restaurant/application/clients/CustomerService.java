package com.ibm.restaurant.application.clients;

import com.ibm.restaurant.domain.clients.Address;
import com.ibm.restaurant.domain.clients.Customer;
import com.ibm.restaurant.domain.clients.iCustomerRepository;
import com.ibm.restaurant.domain.exception.BusinessException;
import com.ibm.restaurant.domain.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CustomerService {

    @Autowired
    private iCustomerRepository iCustomerRepository;

    public void createCustomer(Customer customer) {

        if (validationCriteria(customer)) {
            iCustomerRepository.createCustomer(customer);
        }

//        HashSet<String> emailList = new HashSet<>();
//        for (String email : emailList) {
//            if (email.equals(customer.getEmail())) {
//                throw new BusinessException("Email already used", "BAD_REQUEST");
//            } else {
//                iCustomerRepository.createCustomer(customer);
//                emailList.add(customer.getEmail());
//            }
//        }
    }

    public Customer getCustomerById(Long id) {
        Customer customer = iCustomerRepository.getCustomerById(id);
        if (checkIfCustomerExists(customer, id)) {
            return customer;
        }
        return null;
    }

    public HashSet<Customer> getCustomerList() {
        return iCustomerRepository.getCustomerList();
    }

    public void updateCustomerById(Long id, Customer customer) {
        if (validationCriteria(customer)) {
            Customer customerFromDb = getCustomerById(id);
            if (checkIfCustomerExists(customerFromDb, id)) {
                customerFromDb.setFirstName(customer.getFirstName());
                customerFromDb.setLastName(customer.getLastName());
                customerFromDb.setAdress(customer.getAddress());
                customerFromDb.setPhoneNumber(customer.getPhoneNumber());
                customerFromDb.setEmail(customer.getEmail());
                customerFromDb.setWallet(customer.getWallet());
                iCustomerRepository.updateCustomerById(customerFromDb);
            }
        }
    }

    public void deleteCustomerById(Long id) {
        Customer customer = getCustomerById(id);

        if (checkIfCustomerExists(customer, id)) {
            iCustomerRepository.deleteCustomerById(customer);
        }
    }

    private boolean validateName(Customer customer) {
        String regex = "\\w+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(customer.getFirstName());
        return matcher.matches();
    }

    private boolean validateLastName(Customer customer) {
        String regex = "\\w+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(customer.getLastName());
        return matcher.matches();
    }

    private boolean validateZipCode(Customer customer) {
        String zipCode = customer.getAddress().getPostalCode();
        String regex = "\\d{6}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(zipCode);
        return matcher.matches();
    }

    private boolean validatePhoneNumber(Customer customer) {
        String regex = "^0\\d{9}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(customer.getPhoneNumber());
        return matcher.matches();
    }

    private boolean validationCriteria(Customer customer) {

        if (!(validateName(customer)) || !(validateLastName(customer))) {
            String message = "First name and last name must contain only characters " +
                    "of the Latin alphabet";
            String code = "BAD_REQUEST";
            throw new BusinessException(message, code);
        } else if (!validateZipCode(customer)) {
            String message = "The zip code must have exactly 6 digits";
            String code = "BAD_REQUEST";
            throw new BusinessException(message, code);

        } else if (!validatePhoneNumber(customer)) {
            String message = "The phone number must start with 0 and have exactly 10 digits";
            String code = "BAD_REQUEST";
            throw new BusinessException(message, code);
        }
        return true;

    }

    private boolean checkIfCustomerExists(Customer customer, Long id) {
        if (customer == null) {
            throw new NotFoundException("Customer with id " + id + " not found.");
        }
        return true;
    }

}
