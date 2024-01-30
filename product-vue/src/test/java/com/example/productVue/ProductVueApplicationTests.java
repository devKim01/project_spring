package com.example.productVue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.productVue.repository.BoardRepository;

@SpringBootTest
@Transactional
class ProductVueApplicationTests {

	@Autowired
	private BoardRepository repository;
	
	@Test
	public void contextLoads() {

}}
