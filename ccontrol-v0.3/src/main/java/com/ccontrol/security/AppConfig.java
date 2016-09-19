package com.ccontrol.security;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
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
	public UserDetailsService getUserDetailsService(){
	        return new UserDetailsServiceIMPL();
	    }
	
	 @Bean
	    public EntityManager entityManager() {
	        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ccontrol");
	        return emf.createEntityManager();
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
