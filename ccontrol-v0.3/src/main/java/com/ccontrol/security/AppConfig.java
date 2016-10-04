package com.ccontrol.security;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.instrument.classloading.ReflectiveLoadTimeWeaver;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@ComponentScan("com.ccontrol")
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter  {
	
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	    
	}
	
	@Bean
    public UrlBasedViewResolver setupViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/WEB-INF/views/");        
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        resolver.setOrder(1);
        return resolver;
    }
	
	@Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver mr = new CommonsMultipartResolver();
        mr.setDefaultEncoding("utf-8");
        return mr;
    }
	
	 @Bean
	    public EntityManager entityManager() {
		 
		 Map<String,String> props = new HashMap<String,String>();
			props.put("javax.persistence.jdbc.url","jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7138736");
			props.put("javax.persistence.jdbc.user","sql7138736");
			props.put("javax.persistence.jdbc.password","FRdCQQqqlz");
			props.put("javax.persistence.jdbc.driver","com.mysql.jdbc.Driver");
			props.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
			props.put("hibernate.hbm2ddl.auto","update");
			props.put("hibernate.show_sql","true");

		    LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		    emf.setPersistenceProviderClass(org.hibernate.jpa.HibernatePersistenceProvider.class); //If your using eclipse or change it to whatever you're using
		    emf.setPackagesToScan("com.ccontrol"); //The packages to search for Entities, line required to avoid looking into the persistence.xml
		    emf.setPersistenceUnitName("control");
		    emf.setJpaPropertyMap(props);
		    emf.setLoadTimeWeaver(new ReflectiveLoadTimeWeaver()); //required unless you know what your doing
		    emf.afterPropertiesSet();
		 
		 
	      // EntityManagerFactory emf = Persistence.createEntityManagerFactory("ccontrol");
		   
		    if (emf.getObject() == null){
		    	System.out.println("EMF IS NULL!!!");
		    }
	        return emf.getObject().createEntityManager();
	}
	
	@Bean
	public UserDetailsService getUserDetailsService(){
	        return new UserDetailsServiceIMPL();
	    }
	
	

	  
	/*@Bean
	public XmlViewResolver xml(){
		XmlViewResolver resolver = new XmlViewResolver();
		Resource resource = new ClassPathResource("/WEB-INF/classes/excel-config.xml");  
		resolver.setLocation(resource);
		resolver.setOrder(0);
	    return resolver;  
		
	}*/
}
