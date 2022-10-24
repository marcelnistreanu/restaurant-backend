package com.ibm.restaurant.clients;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressDto {

    @JsonProperty
    public String addressLine1;

    @JsonProperty
    public String addressLine2;

    @JsonProperty
    public String postalCode;

    @JsonProperty
    public String city;

    @JsonProperty
    public String country;

}
