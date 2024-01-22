package com.shanep.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
	@JsonProperty
	private Integer code;
    @JsonProperty
    private String message;
    
    public ErrorResponse(String message) {
        this.message = message;
    }

}
