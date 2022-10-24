package com.ibm.restaurant.clients;

import com.ibm.restaurant.domain.clients.Address;
import com.ibm.restaurant.domain.clients.Customer;
import com.ibm.restaurant.domain.wallet.Wallet;
import com.ibm.restaurant.wallet.WalletDto;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class CustomerMapperService {

    public Customer mapToDomain(CustomerDto customerDto) {
        if (customerDto != null) {
            Address address = null;
            if (customerDto.addressDto != null) {
                address = mapAddressDtoToDomain(customerDto.addressDto);
            }
            Customer customer = new Customer();
            customer.setCustomerId(customerDto.customerId);
            customer.setFirstName(customerDto.firstName);
            customer.setLastName(customerDto.lastName);
            customer.setAdress(address);
            customer.setPhoneNumber(customerDto.phoneNumber);
            customer.setEmail(customerDto.email);
            customer.setWallet(customerDto.wallet);
            return customer;
        }
        return null;
    }

    public CustomerDto mapFromDomain(Customer customer) {
        if (customer != null) {
            CustomerDto dto = new CustomerDto();
            dto.customerId = customer.getCustomerId();
            dto.firstName = customer.getFirstName();
            dto.lastName = customer.getLastName();
            dto.addressDto = mapAddressFromDomain(customer.getAddress());
            dto.phoneNumber = customer.getPhoneNumber();
            dto.email = customer.getEmail();
            dto.wallet = customer.getWallet();
//            dto.walletId = customer.getWallet().getWalletId();
            return dto;
        }
        return null;
    }

    public HashSet<CustomerDto> mapFromDomain(HashSet<Customer> customerList) {
        HashSet<CustomerDto> list = new HashSet<>();
        for (Customer customer : customerList) {
            list.add(mapFromDomain(customer));
        }
        return list;
    }

    private AddressDto mapAddressFromDomain(Address address) {
        if (address != null) {
            AddressDto dto = new AddressDto();
            dto.addressLine1 = address.getAddressLine1();
            dto.addressLine2 = address.getAddressLine2();
            dto.postalCode = address.getPostalCode();
            dto.city = address.getCity();
            dto.country = address.getCountry();
            return dto;
        }
        return null;
    }

    private Address mapAddressDtoToDomain(AddressDto addressDto) {
        Address address = new Address();
        address.setAddressLine1(addressDto.addressLine1);
        address.setAddressLine2(addressDto.addressLine2);
        address.setPostalCode(addressDto.postalCode);
        address.setCity(addressDto.city);
        address.setCountry(addressDto.country);
        return address;
    }

}
