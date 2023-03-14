package com.safaricom.backendApi.Controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safaricom.backendApi.Entitys.Articles;

import com.safaricom.backendApi.Services.ArticleService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


@RestController
@RequestMapping("/api/v1/articles")
public class ArticleController {

	@Autowired
	ArticleService articleService;
	
	@PostMapping("/")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
	
	public ResponseEntity<?>saveArticles(@RequestBody @Valid List<Articles> articles){
	
		
		
		try {
		
		
			return new ResponseEntity<Object>(articleService.saveArticles(articles),HttpStatus.CREATED);
			
		} catch (Exception e) {
			// TODO: handle exception
		

			 return new ResponseEntity<String>("Error ",HttpStatus.BAD_REQUEST);
		
		}
		
		}
	
	@GetMapping("/")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
	public ResponseEntity<?>getallArticle(){
		
		try {
		
			return new  ResponseEntity<Object>(articleService.getAllArticels(),HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
			 return new ResponseEntity<String>("SERVICE UNAVAILABLE",HttpStatus.SERVICE_UNAVAILABLE);

		}
		}
	
	@PatchMapping("/{id}")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
	public ResponseEntity<?>updatearticle( @PathVariable("id") int id,@RequestBody Articles articles){
		
		
		try {
			return new ResponseEntity<Object>(articleService.udateArticles(id, articles),HttpStatus.OK);
				
		} catch (Exception e) {
			// TODO: handle exception
			 return new ResponseEntity<String>("SERVICE UNAVAILABLE",HttpStatus.SERVICE_UNAVAILABLE);

		}
		
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
	public ResponseEntity<?>deleteArtcles(@NotNull @PathVariable int id){
		
		
		try {
			articleService.delelteAtricels(id);
			return new  ResponseEntity<String>("Article is now deleted",HttpStatus.NO_CONTENT);
				
		} catch (Exception e) {
			// TODO: handle exception
		
			return new  ResponseEntity<String>("unable to find this article",HttpStatus.NOT_FOUND);
			
		}
		}
}
