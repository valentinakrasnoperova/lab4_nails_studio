package nailsstudio.mapper;

import nailsstudio.DTO.UserDTO;
import nailsstudio.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDTOMapper {
    public User toEntity(final UserDTO userDTO) {
        final User user = new User();

        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setEmail(userDTO.getEmail());
        user.setBirthDate(userDTO.getBirthDate());
        user.setRole(userDTO.getRole());


        return user;
    }

    public UserDTO toDTO(final User user) {
        final UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setEmail(user.getEmail());
        userDTO.setBirthDate(user.getBirthDate());
        userDTO.setRole(user.getRole());

        return userDTO;
    }
}