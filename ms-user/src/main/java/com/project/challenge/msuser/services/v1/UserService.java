package com.project.challenge.msuser.services.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.challenge.msuser.DTOs.user.v1.UserBalanceDTO;
import com.project.challenge.msuser.DTOs.user.v1.UserDTO;
import com.project.challenge.msuser.entities.User;
import com.project.challenge.msuser.infra.exceptions.UserNotFound;
import com.project.challenge.msuser.mappers.user.v1.MapperUser;
import com.project.challenge.msuser.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public UserDTO getUserByUuid(String uuid) {
        return MapperUser
                .getInstance()
                .toDTO(findUserByUuid(uuid));
    }

    public UserDTO getUserByCommonUserUuid(String uuid) {
        return MapperUser
                .getInstance()
                .toDTO(findUserByCommonUserUuid(uuid));
    }

    public UserDTO getUserByShopKeeperUuid(String uuid) {
        return MapperUser
                .getInstance()
                .toDTO(findUserByShopKeeperUuid(uuid));
    }

    public UserDTO saveBalanceToUser(UserBalanceDTO userBalanceDTO) {
        User user = findUserByUuid(userBalanceDTO.getUuid());
        user.setBalance(userBalanceDTO.getBalance());
        saveUser(user);
        return MapperUser
                .getInstance()
                .toDTO(user);
    }

    private void saveUser(User user) {
        repo.save(user);
    }

    private User findUserByUuid(String uuid) {
        return repo.findByUuid(uuid)
                .orElseThrow(() -> new UserNotFound(String.format("User with UUID (%s) not found.", uuid)));
    }

    private User findUserByCommonUserUuid(String uuid) {
        return repo.findByCommonUserUuid(uuid)
                .orElseThrow(() -> new UserNotFound(String.format("User with Common User UUID (%s) not found.", uuid)));
    }

    private User findUserByShopKeeperUuid(String uuid) {
        return repo.findByShopKeeperUuid(uuid)
                .orElseThrow(() -> new UserNotFound(String.format("User with Shopkeeper UUID (%s) not found.", uuid)));
    }

}
