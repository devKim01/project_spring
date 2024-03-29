package com.shanep.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result {
	@JsonProperty
    private ErrorResponse error;
    @JsonProperty
    private Object payload;
}