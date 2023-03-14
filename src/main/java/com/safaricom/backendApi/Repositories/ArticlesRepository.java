package com.safaricom.backendApi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.safaricom.backendApi.Entitys.Articles;

@Repository
public interface ArticlesRepository extends JpaRepository<Articles, Integer>{

}
