package com.tactfactory.monprojet.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tactfactory.monprojet.databases.ArticleRepository;
import com.tactfactory.monprojet.databases.RoleRepository;
import com.tactfactory.monprojet.databases.UserRepository;
import com.tactfactory.monprojet.entities.Article;
import com.tactfactory.monprojet.entities.Role;
import com.tactfactory.monprojet.entities.User;
import com.tactfactory.monprojet.services.UserService;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
public class UserServiceAdvanceTest {

  @Autowired
  private UserService service;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private ArticleRepository articleRepository;

  @Before
  public void before() {
    userRepository.deleteAll();
  }

  @Test
  public void testSaveCreateOneWithNewRole() {
    long oldRoleItems = roleRepository.count();

    User user = new User();
    user.setEmail("email");
    user.setFirstname("firstname");
    user.setLastname("lastname");

    Role role = new Role();
    role.setName("role");
    user.getRoles().add(role);
    service.save(user);

    long roleItems = roleRepository.count();

    assertEquals(oldRoleItems + 1, roleItems);
  }

  @Test
  public void testSaveCreateOneWithNewRoles() {
    long oldRoleItems = roleRepository.count();

    User user = new User();
    user.setEmail("email");
    user.setFirstname("firstname");
    user.setLastname("lastname");

    for (int i = 0; i < 10; i++) {
      Role role = new Role();
      role.setName("role" + i);
      user.getRoles().add(role);
    }

    service.save(user);

    long roleItems = roleRepository.count();

    assertEquals(oldRoleItems + 10, roleItems);
  }

  @Test
  public void testSaveCreateOneWithNewArticle() {
    long oldArticleItems = articleRepository.count();

    User user = new User();
    user.setEmail("email");
    user.setFirstname("firstname");
    user.setLastname("lastname");

    Article article = new Article();
    article.setName("article");
    article.setPrice(10f);
    user.getArticles().add(article);
    service.save(user);

    long articleItems = articleRepository.count();

    assertEquals(oldArticleItems + 1, articleItems);
  }

  @Test
  public void testSaveCreateOneWithNewArticles() {
    long oldArticleItems = articleRepository.count();

    User user = new User();
    user.setEmail("email");
    user.setFirstname("firstname");
    user.setLastname("lastname");

    for (int i = 0; i < 10; i++) {
      Article article = new Article();
      article.setName("article" + i);
      article.setPrice(10f);
      user.getArticles().add(article);
      service.save(user);
    }

    long articleItems = articleRepository.count();

    assertEquals(oldArticleItems + 10, articleItems);
  }

  @Test
  public void testSaveCreateOneWithNewRolesAndArticles() {
    long oldRoleItems = roleRepository.count();
    long oldArticleItems = articleRepository.count();

    User user = new User();
    user.setEmail("email");
    user.setFirstname("firstname");
    user.setLastname("lastname");

    for (int i = 0; i < 10; i++) {
      Role role = new Role();
      role.setName("role" + i);
      user.getRoles().add(role);
    }

    for (int i = 0; i < 10; i++) {
      Article article = new Article();
      article.setName("article" + i);
      article.setPrice(10f);
      user.getArticles().add(article);
    }

    service.save(user);

    long roleItems = roleRepository.count();
    long articleItems = articleRepository.count();

    assertEquals(oldArticleItems + oldRoleItems + 20, articleItems + roleItems);
  }
}
