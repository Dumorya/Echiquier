package com.tactfactory.monprojet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tactfactory.monprojet.databases.ArticleRepository;
import com.tactfactory.monprojet.entities.Article;

@Service
public class ArticleService implements BaseService<Article, Long> {

  @Autowired
  private ArticleRepository articleRepository;

  @Override
  public Article save(Article item) {
    return this.articleRepository.save(item);
  }

  @Override
  public void delete(Article item) {
    this.articleRepository.delete(item);
  }

  @Override
  public Article get(Long id) {
    return this.articleRepository.findById(id).get();
  }

  @Override
  public List<Article> getAll() {
    return this.articleRepository.findAll();
  }
}
