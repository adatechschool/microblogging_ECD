package com.microblogging.backend;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.microblogging.backend.models.User;
import com.microblogging.backend.repositories.UserRepository;
import com.microblogging.backend.services.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
        
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testGetUserById() {
        Long userId = 1L;
        User fakeUser = new User(userId, null, "Fake description", null); // Assuming User and LocalDateTime are handled elsewhere
        // Mocking the behavior of the repository to return the fake user when findById is called
        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(fakeUser));

        User result = userService.getUserById(userId);

        Assertions.assertThat(result).isEqualTo(fakeUser);
    }

    @Test
    void testGetAllUsers() {
        // Assuming you have a method to create a list of fake users
        List<User> fakeUsers = List.of(new User(1L, null, "Fake description 1", null),
                                        new User(2L, null, "Fake description 2", null));
        Mockito.when(userRepository.findAll()).thenReturn(fakeUsers);

        List<User> result = userService.getAllUsers();

        Assertions.assertThat(result).isEqualTo(fakeUsers);
    }

    @Test
    void testCreateUser() {
        User newUser = new User(null, null, "New user description", null); // Assuming User and LocalDateTime are handled elsewhere
        User savedUser = new User(1L, null, "New user description", null); // Mocked saved user with ID
        Mockito.when(userRepository.save(newUser)).thenReturn(savedUser);

        User result = userService.createUser(newUser);

        Assertions.assertThat(result).isEqualTo(savedUser);
    }
}