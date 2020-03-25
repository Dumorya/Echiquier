package com.tactfactory.monprojet.demo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tactfactory.monprojet.databases.UserRepository;
import com.tactfactory.monprojet.demo.utils.UserUtil;
import com.tactfactory.monprojet.entities.User;
import com.tactfactory.monprojet.services.UserService;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
public class UserServiceTest {

  @Autowired
  private UserService service;

  @Autowired
  private UserRepository userRepository;

  @Before
  public void before() {
    userRepository.deleteAll();
  }

  @Ignore
  @Test
  public void testSaveCreateOne() {
    long oldItems = userRepository.count();

    User user = new User();
    user.setEmail("email");
    user.setFirstname("firstname");
    user.setLastname("lastname");
    service.save(user);

    long items = userRepository.count();
    assertEquals(oldItems + 1, items);
  }

  @Ignore
  @Test
  public void testSaveWithCorrectDatas() {
    User user = new User();
    user.setEmail("email");
    user.setFirstname("firstname");
    user.setLastname("lastname");
    service.save(user);

    User dbUser = userRepository.findById(user.getId()).get();
    assertEquals(user, dbUser);
  }

  @Ignore
  @Test
  public void testUpdateWithCorrectDatas() {
    User user = new User();
    user.setEmail("email");
    user.setFirstname("firstname");
    user.setLastname("lastname");
    userRepository.save(user);

    User updateUser = new User();
    updateUser.setEmail("emailupdate");
    updateUser.setFirstname("firstnameupdate");
    updateUser.setLastname("lastnameupdate");

    updateUser.setId(user.getId());

    service.save(updateUser);

    User dbUser = userRepository.findById(user.getId()).get();

    assertTrue(UserUtil.comparerSimple(dbUser, updateUser));
  }

  @Ignore
  @Test
  public void testGetWithCorrectDatas() {
    User user = new User();
    user.setEmail("email");
    user.setFirstname("firstname");
    user.setLastname("lastname");
    userRepository.save(user);

    User serviceUser = service.get(user.getId());
    assertTrue(UserUtil.comparerSimple(user, serviceUser));
  }

  @Ignore
  @Test
  public void testGetAllWithCorrectDatas() {
    for (int i = 0; i < 10; i++) {
      User user = new User();
      user.setEmail("email" + i);
      user.setFirstname("firstname" + i);
      user.setLastname("lastname" + i);
      userRepository.save(user);
    }

    List<User> dbUsers = userRepository.findAll();

    List<User> serviceUsers = service.getAll();
    assertTrue(UserUtil.comparerListSimple(dbUsers, serviceUsers));
  }

  @Ignore
  @Test
  public void testDeleteCount() {
    for (int i = 0; i < 10; i++) {
      User user = new User();
      user.setEmail("email" + i);
      user.setFirstname("firstname" + i);
      user.setLastname("lastname" + i);
      userRepository.save(user);
    }

    List<User> dbUsers = userRepository.findAll();

    service.delete(dbUsers.get(0));

    assertEquals(userRepository.count(), dbUsers.size() - 1);
  }

  @Ignore
  @Test
  public void testDeleteCorrectValues() {
    for (int i = 0; i < 10; i++) {
      User user = new User();
      user.setEmail("email" + i);
      user.setFirstname("firstname" + i);
      user.setLastname("lastname" + i);
      userRepository.save(user);
    }

    List<User> dbUsers = userRepository.findAll();

    service.delete(dbUsers.get(0));

    assertFalse(userRepository.findAll().contains(dbUsers.get(0)));
  }


}
