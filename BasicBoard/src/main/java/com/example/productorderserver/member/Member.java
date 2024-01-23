package com.example.productorderserver.member;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Data				//get set
@Builder			//dto->entity
@AllArgsConstructor //모든 컬럼 생성자 생성
@NoArgsConstructor //기본 생성자
@Table(name="membering")
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique=true)
	private String email;
	
	@Column
	private String username;

	@Column(nullable = false)
	private String password;
}
