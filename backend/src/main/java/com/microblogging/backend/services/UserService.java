package com.microblogging.backend.services;


import com.microblogging.backend.models.User;
import com.microblogging.backend.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // public static User getUserByEmail(String email) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'getUserByEmail'");
    // }
    

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        // Vérifier que l'alias est fourni
        if (user.getAlias() == null || user.getAlias().trim().isEmpty()) {
            throw new IllegalArgumentException("L'alias de l'utilisateur est requis et ne peut pas être vide.");
        }
    
        // Vérifier que l'email est fourni et valide
        if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("L'email de l'utilisateur est requis.");
        }
    
        // Vérifier que le mot de passe est fourni
        if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            throw new IllegalArgumentException("Le mot de passe est requis.");
        }
    
        // Enregistrement dans la base via le repository
        return userRepository.save(user);
    }
    
}
