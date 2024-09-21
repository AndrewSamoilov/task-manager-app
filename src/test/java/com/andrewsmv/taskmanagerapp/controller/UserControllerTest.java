package com.andrewsmv.taskmanagerapp.controller;

import com.andrewsmv.taskmanagerapp.domain.entity.User;
import com.andrewsmv.taskmanagerapp.domain.mapper.UserMapperImpl;
import com.andrewsmv.taskmanagerapp.service.UserService;
import com.andrewsmv.taskmanagerapp.testutils.Constants;
import com.andrewsmv.taskmanagerapp.testutils.TestUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

        when(userService.createUser(user)).thenReturn(TestUser.getUser());

        mockMvc.perform(post("/api/users")
                        .content("{\"email\": \"test@gmail.com\"}\n")
                        .header("Content-Type", "application/json"))
                .andExpect(status().isCreated());

        verify(userService).createUser(user);
    }
}
