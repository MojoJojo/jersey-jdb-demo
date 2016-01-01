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
		
		EntityManager entityManager = (EntityManager) httpRequest.getServletContext().getAttribute("ProductEntityManager");
		entityManager.getTransaction().begin();
		List<Product> result = entityManager.createQuery( "from Product", Product.class ).getResultList();
		
		entityManager.getTransaction().commit();
		
		
		return result.toArray(new Product[result.size()]);
		
	
	}

	@POST
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
	@Produces({ MediaType.TEXT_HTML })

	public Response createProductFromApplicationFormURLencoded(@FormParam("productName") String productName,
			@FormParam("productPrice") float productPrice) {
		EntityManager entityManager = (EntityManager) httpRequest.getServletContext().getAttribute("ProductEntityManager");
		
		
		
		
		
		

		Product product = new Product(productName, productPrice);
		
		entityManager.getTransaction().begin();
		entityManager.persist(product);
		
		entityManager.flush();
		entityManager.getTransaction().commit();
		
		
		
		
		

		// Long createPodcastid = podcastService.createPodcast(podcast);

		return Response.status(Response.Status.CREATED)// 201
				.entity("A new product has been created at /jersy-jdb-demo/products/" + product.getId())
				.header("Location",
						"http://localhost:8080/jersy-jdb-demo/products/" + product.getId())
				.header("id", product.getId()).build();
						
				
	}
}
