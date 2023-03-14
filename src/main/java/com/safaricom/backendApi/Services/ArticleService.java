package com.safaricom.backendApi.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safaricom.backendApi.Entitys.Articles;
import com.safaricom.backendApi.Repositories.ArticlesRepository;

@Service
public class ArticleService {

	
	@Autowired
	ArticlesRepository articlesRepository;

//Save articles 
	
	public List<Articles> saveArticles( List<Articles> articles) {
		
		
		return articlesRepository.saveAll(articles);
	}

// get all articles 
	
	public List<Articles> getAllArticels(){
		
		
		return articlesRepository.findAll();
	}
// update Articles
	
	public Articles udateArticles(int id ,Articles articles ) {
		
		
		Optional<Articles>findArticles= articlesRepository.findById(id);
		
		if (findArticles.isPresent()) {
			
			Articles articles2= findArticles.get();
			
			articles2.setTitle(articles.getTitle());
			articles2.setContent(articles.getContent());
		    articles2.setVisibility(articles.getVisibility());
			
			return articlesRepository.save(articles2);
		}
		else {
			
			return articles;
		}
		
	}
	
	
// delete articels
	
	public String delelteAtricels(int id) {
		
		
		Optional<Articles>findarticles=articlesRepository.findById(id);
		
		if (findarticles.isPresent()) {
			
			articlesRepository.deleteById(id);
			
			return "articles is deleted";
		}
		
		else {
			
			
			return "unable to find this article ";
		}
	}
}
