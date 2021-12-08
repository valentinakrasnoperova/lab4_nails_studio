package nailsstudio.service.impl;

import nailsstudio.DTO.UserDTO;
import nailsstudio.entity.User;
import nailsstudio.mapper.UserToUserDTOMapper;
import nailsstudio.repository.UserRepository;
import nailsstudio.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    final private UserToUserDTOMapper userMapper;

    final private UserRepository userRepository;

    public UserServiceImpl(final UserToUserDTOMapper userMapper, final UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.getAllUsers().stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(final long id) {
        return userMapper.toDTO(userRepository.getUserById(id));
    }

    @Override
    public UserDTO saveUser(final UserDTO userDTO) {

        final User user = userMapper.toEntity(userDTO);

        userRepository.saveUser(user);

        return userMapper.toDTO(user);
    }

    @Override
    public UserDTO updateUser(final UserDTO userDTO) {

        final User user = userMapper.toEntity(userDTO);

        return userMapper.toDTO(userRepository.updateUser(user));
    }

    @Override
    public void deleteUserById(final long id) {
        userRepository.deleteUserById(id);
    }
}