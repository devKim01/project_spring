package com.example.productorderserver.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardRequestDTO {
	private String title;
	private String content;
	private String writer;
	private char deleteYn;
}
