package com.coretarget.demo;

import org.junit.Assert;
import org.junit.Test;

import com.ontarget.demo.hibernate.model.Product;

public class ProductTest {
	
	@Test
	public void publicEntityTest() {
		Product product = new Product("testProduct", 45.76f);
		Assert.assertEquals("testProduct", product.getName());
		Assert.assertEquals(45.76f, product.getPrice(),0);
	}
	

}
