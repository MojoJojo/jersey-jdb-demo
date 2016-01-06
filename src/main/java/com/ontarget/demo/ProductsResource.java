package com.ontarget.demo;

import java.util.List;

import javax.persistence.EntityManager;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ontarget.demo.hibernate.UserException;
import com.ontarget.demo.hibernate.model.Product;

/**
 * Root resource (exposed at "products" path)
 */
@Path("products")
public class ProductsResource {

	@Context
	private HttpServletRequest httpRequest;

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to
	 * the client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)

	public Product[] getProducts() {

		EntityManager entityManager = (EntityManager) httpRequest.getServletContext()
				.getAttribute("ProductEntityManager");
		entityManager.getTransaction().begin();
		List<Product> result = entityManager.createQuery("from Product", Product.class).getResultList();

		entityManager.getTransaction().commit();

		return result.toArray(new Product[result.size()]);

	}

	@POST
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
	@Produces({ MediaType.TEXT_HTML })

	public Response createProductFromApplicationFormURLencoded(@FormParam("productName") String productName,
			@FormParam("productPrice") float productPrice) {
		EntityManager entityManager = (EntityManager) httpRequest.getServletContext()
				.getAttribute("ProductEntityManager");

		if (productPrice < 0) {
			throw new UserException(100, 401, "www.google.com",
					"productPrice cannot be negative. Please supply valid value and try again.");
		}
		if ((productName == null) || productName.isEmpty() || productName.trim().isEmpty()) {
			throw new UserException(100, 401, "www.google.com",
					"productName cannot be null. Please supply valid value and try again.");
		}
		Product product = new Product(productName, productPrice);

		entityManager.getTransaction().begin();
		entityManager.persist(product);

		entityManager.flush();
		entityManager.getTransaction().commit();



		return Response.status(Response.Status.CREATED)// 201
				.entity("A new product has been created at /jersy-jdb-demo/products/" + product.getId())
				.header("Location", "http://localhost:8080/jersy-jdb-demo/products/" + product.getId())
				.header("id", product.getId()).build();

	}
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_HTML })

	public Response createProductFromJSON(Product product) {
		
		System.out.println("Creating prodict from JSON");
		EntityManager entityManager = (EntityManager) httpRequest.getServletContext()
				.getAttribute("ProductEntityManager");

		if (product.getPrice() < 0) {
			throw new UserException(100, 401, "www.google.com",
					"productPrice cannot be negative. Please supply valid value and try again.");
		}
		if ((product.getName() == null) || product.getName().isEmpty() || product.getName().trim().isEmpty()) {
			throw new UserException(100, 401, "www.google.com",
					"productName cannot be null. Please supply valid value and try again.");
		}
		

		entityManager.getTransaction().begin();
		entityManager.persist(product);

		entityManager.flush();
		entityManager.getTransaction().commit();



		return Response.status(Response.Status.CREATED)// 201
				.entity("A new product has been created at /jersy-jdb-demo/products/" + product.getId())
				.header("Location", "http://localhost:8080/jersy-jdb-demo/products/" + product.getId())
				.header("id", product.getId()).build();

	}
}
