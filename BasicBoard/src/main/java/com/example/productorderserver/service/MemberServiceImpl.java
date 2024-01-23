package com.example.productorderserver.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import com.example.productorderserver.config.SecurityConfig;
import com.example.productorderserver.dto.MemberResponseDTO;
import com.example.productorderserver.dto.MemberSaveRequestDTO;
import com.example.productorderserver.member.Member;
import com.example.productorderserver.repository.MemberRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //memberRepo 생성자 안쓰기 위해
public class MemberServiceImpl implements MemberService {
	private final MemberRepository memberRepository;
	private final SecurityConfig passwordEncoder;
	
	@Override
	public Long join(MemberSaveRequestDTO memberSaveRequestDTO) {
		memberSaveRequestDTO.setPassword(passwordEncoder.encode(memberSaveRequestDTO.getPassword()));
		
		Member member = Member.builder()
				.email(memberSaveRequestDTO.getEmail())
				.username(memberSaveRequestDTO.getUsername())
				.password(memberSaveRequestDTO.getPassword())
				.build();
		return memberRepository.save(member).getId();
	}
	
	@Transactional(readOnly= true)
	@Override
	public Map<String, String> validateHandling(Errors errors){
		Map<String, String> validatorResult = new HashMap<>();
		
		for(FieldError error : errors.getFieldErrors()) {
			String validKeyName = String.format("valid_%s", error.getField());
			validatorResult.put(validKeyName, error.getDefaultMessage());
		}
		return validatorResult;
	}
	
	@Override
	public List<MemberResponseDTO> findMembers(){
		List<Member> all = memberRepository.findAll();
		List<MemberResponseDTO> members = new ArrayList<>();
		
		for(Member member: all) {
			MemberResponseDTO build = MemberResponseDTO.builder()
					.member(member)
					.build();
			members.add(build);
		}
		return members;
	}
}
