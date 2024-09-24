package com.andrewsmv.taskmanagerapp.controller;

import static com.andrewsmv.taskmanagerapp.testutils.Constants.USER_ID;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.andrewsmv.taskmanagerapp.domain.entity.User;
import com.andrewsmv.taskmanagerapp.domain.mapper.UserMapperImpl;
import com.andrewsmv.taskmanagerapp.service.UserService;
import com.andrewsmv.taskmanagerapp.testutils.Constants;
import com.andrewsmv.taskmanagerapp.testutils.JsonTestUtils;
import com.andrewsmv.taskmanagerapp.testutils.TestUser;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;

@Import(UserMapperImpl.class)
@WebMvcTest(controllers = UserController.class)
class UserControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserService userService;

  @Test
  void createUser_whenWorkCorrectly() throws Exception {

    User user = new User();
    user.setEmail(Constants.EMAIL);

    when(userService.create(user)).thenReturn(TestUser.getUser());

    mockMvc.perform(post("/api/users")
            .content("{\"email\": \"test@gmail.com\"}\n")
            .header("Content-Type", "application/json"))
        .andExpect(status().isCreated())
        .andExpect(content().json(JsonTestUtils.getJsonString("create_user.json"),
            true));

    verify(userService).create(user);
  }


  @Test
  void updateUser_whenWorkCorrectly() throws Exception {

    User user = new User();
    user.setEmail(Constants.EMAIL);

    when(userService.update(USER_ID, user)).thenReturn(TestUser.getUser());

    mockMvc.perform(put("/api/users/1")
            .content("{\"email\": \"test@gmail.com\"}\n")
            .header("Content-Type", "application/json"))
        .andExpect(status().isOk())
        .andExpect(content().json(JsonTestUtils.getJsonString("update_user.json"),
            true));

    verify(userService).update(USER_ID, user);
  }

  @Test
  void getUser_whenWorkCorrectly() throws Exception {
    when(userService.get(USER_ID)).thenReturn(TestUser.getUser());

    mockMvc.perform(get("/api/users/1")
            .header("Content-Type", "application/json"))
        .andExpect(status().isOk())
        .andExpect(content().json(JsonTestUtils.getJsonString("get_user.json"),
            true));

    verify(userService).get(USER_ID);
  }

  @Test
  void deleteUser_whenWorkCorrectly() throws Exception {

    mockMvc.perform(delete("/api/users/1")
            .header("Content-Type", "application/json"))
        .andExpect(status().isNoContent());

    verify(userService).delete(USER_ID);
  }

  @Test
  void getAllUsers_whenWorkCorrectly() throws Exception {
    List<User> users = List.of(TestUser.getUser());

    Pageable pageable = PageRequest.of(0, 1);
    Page<User> usersPage = new PageImpl<>(users, pageable, users.size());

    when(userService.getAll(pageable)).thenReturn(usersPage);

    mockMvc.perform(get("/api/users")
            .param("page", "0")
            .param("size", "1")
            .header("Content-Type", "application/json"))
        .andExpect(status().isOk())
        .andExpect(content().json(JsonTestUtils.getJsonString("get_all_users.json"),
            true));
    verify(userService).getAll(pageable);
  }
}
