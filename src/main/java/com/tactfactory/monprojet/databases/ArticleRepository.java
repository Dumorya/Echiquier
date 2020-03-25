package com.tactfactory.monprojet.databases;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tactfactory.monprojet.entities.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
