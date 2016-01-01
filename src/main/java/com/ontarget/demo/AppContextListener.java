package com.ontarget.demo;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.jboss.logging.Logger;

@WebListener
public class AppContextListener implements ServletContextListener {

	public final Logger logger = Logger.getLogger(AppContextListener.class);
	private static final EntityManager entityManager = Persistence.createEntityManagerFactory("productManager").createEntityManager();
	

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		logger.info("******************Servlet Context being Destroyed************************* ");
		
		logger.info("******************Servlet Context Destroyed************************* ");
	}

	public void contextInitialized(ServletContextEvent servletContextEvent) {
		logger.info("Servlet Context Initialized. Creating Entity Manager ");
		logger.info("Checking if Entity Manager has already been initialized ");
		if (servletContextEvent.getServletContext().getAttribute("ProductEntityManager") == null) {
			logger.info("******************Entity Manager has not been initialized************************* ");
			
			
			
			servletContextEvent.getServletContext().setAttribute("ProductEntityManager",
					entityManager);
			logger.info("******************Entity Manager has been initialized************************* ");

		}

	}

}
