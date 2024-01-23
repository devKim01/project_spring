package com.example.productorderserver.dto;

import com.example.productorderserver.member.Member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberResponseDTO {
	private String email;
	private String username;
	
	@Builder
	public MemberResponseDTO(Member member) {
		this.email = member.getEmail();
		this.username = member.getUsername();
	}
}
