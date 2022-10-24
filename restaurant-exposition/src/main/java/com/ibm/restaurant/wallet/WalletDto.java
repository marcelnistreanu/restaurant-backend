package com.ibm.restaurant.wallet;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ibm.restaurant.domain.clients.Customer;

public class WalletDto {

    @JsonProperty
    public Long walletId;
    @JsonProperty
    public double balance;
    @JsonProperty
    public Customer customer;

//    @JsonProperty
//    public String customerName;
}
