package com.pkg.sample.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pkg.sample.filters.AuthFilter;

@RestController
@RequestMapping("/check")
public class TokenController 
{
	
	@GetMapping("/token")
   public ResponseEntity<String> geToken()
   {
	   return ResponseEntity.ok(AuthFilter.SECRET_TOKEN);
   }
}
