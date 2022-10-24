package com.ibm.restaurant.clients;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.ibm.restaurant.domain.wallet.Wallet;

public class CustomerDto {

    @JsonProperty
    public Long customerId;
    @JsonProperty
    public String firstName;
    @JsonProperty
    public String lastName;
    @JsonProperty
    public AddressDto addressDto;
    @JsonProperty
    public String phoneNumber;
    @JsonProperty
    public String email;

    @JsonProperty
    public Wallet wallet;

//    @JsonProperty
//    public Long walletId;
}
