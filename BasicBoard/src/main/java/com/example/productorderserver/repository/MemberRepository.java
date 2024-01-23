package com.example.productorderserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.productorderserver.member.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
	boolean existsByEmail(String email);
}
