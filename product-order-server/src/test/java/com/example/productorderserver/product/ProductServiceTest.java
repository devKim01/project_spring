package com.example.productorderserver.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

class ProductServiceTest {

	private ProductService productService;
	
	@BeforeEach
	void setup() {
		productService = new ProductService();
	}
	@Test
	void addProduct() {
		final String name = "상품명";
		final int price =1000;
		final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
		final AddProductRequest request = new AddProductRequest(name, price, discountPolicy);
		productService.addProduct(request);
	}
	
	private class ProductService { 
		public void addProduct(final AddProductRequest request) {
			throw new UnsupportedOperationException("Unspported addProduct");
		}
	}
	
	private record AddProductRequest(String name, int price, DiscountPolicy discountPolicy){
		public AddProductRequest {
			Assert.hasText(name, "상품명은 필수입니다.");
			Assert.isTrue(price, "상품 가격은 0보다 커야 합니다.");
			Assert.notNull(discountPolicy, "할인 정책은 필수입니다.");
		}
	}
	
	private enum DiscountPolicy{
		NONE
	}
}
