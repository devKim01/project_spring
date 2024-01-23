package com.example.productorderserver.service;

import java.util.Map;

import org.springframework.validation.Errors;

import com.example.productorderserver.dto.MemberSaveRequestDTO;

public interface MemberService {
	Long join(MemberSaveRequestDTO memberSaveRequestDTO);
	Map<String, String> validateHandling(Errors errors);

	List<MemberResponseDTO> findMembers();
}
