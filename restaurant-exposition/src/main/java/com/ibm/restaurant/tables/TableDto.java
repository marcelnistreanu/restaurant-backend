package com.ibm.restaurant.tables;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TableDto {

    @JsonProperty
    public String capacity;
    @JsonProperty
    public String status;
}
