package com.safaricom.backendApi.Entitys;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "articles_Table")
public class Articles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int article_Id;
	
	@NotBlank
	private String title;
	
	@NotBlank
	private String content;
	
	private String visibility;
	
	
	private int user_id;


	public int getArticle_Id() {
		return article_Id;
	}


	public void setArticle_Id(int article_Id) {
		this.article_Id = article_Id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getVisibility() {
		return visibility;
	}


	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	
}
