package com.microblogging.backend;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.*;

import org.assertj.core.api.Assertions;

import com.microblogging.backend.models.User;
import com.microblogging.backend.repositories.UserRepository;
import com.microblogging.backend.services.UserService;

@SpringBootTest
class BackendApplicationTests {

	@Test
	void contextLoads() {
	}
}
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
    private UserService userService;

    // @Test
    // void testGetUserByEmail() {
    //     // Arrange
    //     String email = "test@example.com";
    //     User fakeUser = new User(1L, "alias", email, "password");
    //     Mockito.when(UserRepository.findByEmail(email)).thenReturn(fakeUser);

    //     // Act
    //     User result = UserService.getUserByEmail(email);

    //     // Assert avec AssertJ
    //     Assertions.assertThat(result).isEqualTo(fakeUser);
    // }
}

