package org.example.doctorai.service;

import lombok.AllArgsConstructor;
import org.example.doctorai.model.dto.UserDTO;
import org.example.doctorai.model.entity.User;
import org.example.doctorai.model.enums.Role;
import org.example.doctorai.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public List<UserDTO> getUsers(){
        return userRepository.findByRoleAndLetterIsTrue(Role.ROLE_USER)
                .stream()
                .map(UserDTO::new)
                .toList();
    }

}
