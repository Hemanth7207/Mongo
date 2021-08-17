package com.pkg.sample.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
@Component
public class AuthFilter extends OncePerRequestFilter
{

	public static String SECRET_TOKEN="2021";

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException 
	{
		
		
		 
		 List<String> exempted=new ArrayList<String>();
			   exempted.add("/swagger");
			   exempted.add("/webjars");
			   exempted.add("/images");
			   exempted.add("/v2");
			   exempted.add("/csrf");
			   exempted.add("/check/token");
			  boolean isurlAllowed=false;
	     String url=request.getRequestURI();	    
	    
			for (String string : exempted) 
			{
				if(url.contains(string))
				{
				   isurlAllowed=true;
				}
			}	  
		 
	     if(isurlAllowed)
	     {
	    	 filterChain.doFilter(request, response);
	    	 response.getStatus();
	     }
	     else
	     {
	    	 if(request.getHeader("Authorization").equals(SECRET_TOKEN))
	    	 {
	    		 filterChain.doFilter(request, response);
		    	 response.getStatus();
	    	 }
	     }
	     
	          
	 }
	
}

		
	
	
	

