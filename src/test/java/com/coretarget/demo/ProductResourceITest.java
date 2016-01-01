package com.coretarget.demo;

import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.test.DeploymentContext;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.ServletDeploymentContext;
import org.glassfish.jersey.test.grizzly.GrizzlyWebTestContainerFactory;
import org.glassfish.jersey.test.spi.TestContainerFactory;
import org.junit.Test;
import org.junit.Assert;

import com.ontarget.demo.AppContextListener;
import com.ontarget.demo.hibernate.model.Product;

public class ProductResourceITest extends JerseyTest {

	@Override
	protected TestContainerFactory getTestContainerFactory() {

		return new GrizzlyWebTestContainerFactory();

	}

	@Override
	protected DeploymentContext configureDeployment() {
		return ServletDeploymentContext.forPackages("com.ontarget.demo").contextPath("jersy-jdb-demo")
				.addListener(AppContextListener.class).build();
	}
	
	@Test
	public void testDB() {
		//We can check for DB columsn and fields, but need to load Database driver over network in that case.
	}

	@Test
	public void testGet() {
		WebTarget target = target("products");

		List<Product> products = target.request().get(new GenericType<List<Product>>() {
		});

		Assert.assertTrue(products.isEmpty());
		Assert.assertEquals("/jersy-jdb-demo/products", target.getUri().getRawPath());
	}

	@Test
	public void testPost() {
		WebTarget target = target("products");
		Product product = new Product("testProduct", 40.50F);
		
		Form productForm = new Form();
		productForm.param("productName", "TestProduct");
		productForm.param("productPrice", "43.56");
		
		
		
		

		Response postResponse = target.request().post(Entity.entity(productForm, MediaType.APPLICATION_FORM_URLENCODED));
		Assert.assertEquals(201,postResponse.getStatus());
		List<Object> insertedId = postResponse.getHeaders().get("id");
		Assert.assertEquals("1", insertedId.get(0));
		
		//Now total count should be 1
		List<Product> products = target.request().get(new GenericType<List<Product>>() {
		});

		Assert.assertEquals(1,products.size());


	}
	
	
	
}
