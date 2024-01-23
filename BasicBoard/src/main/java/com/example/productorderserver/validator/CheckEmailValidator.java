package com.example.productorderserver.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.example.productorderserver.dto.MemberSaveRequestDTO;
import com.example.productorderserver.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CheckEmailValidator extends AbstractValidator<MemberSaveRequestDTO>{
	private final MemberRepository memberRepository;
	
	@Override
	protected void doValidate(MemberSaveRequestDTO dto, Errors errors) {
		if(memberRepository.existsByEmail(dto.getEmail())) {
			errors.rejectValue("email","이메일 중복 오류", "이미 사용중인 이메일 입니다.");
		}
	}
}
