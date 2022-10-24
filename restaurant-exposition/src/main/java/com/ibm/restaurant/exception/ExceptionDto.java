package com.ibm.restaurant.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExceptionDto {

    @JsonProperty
    public String message;

    @JsonProperty
    public String code;

}
