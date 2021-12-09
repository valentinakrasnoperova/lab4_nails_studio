package nailsstudio.repository;

import nailsstudio.entity.User;
import nailsstudio.exception.ServiceException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class UserRepository {
    private List<User> users = new ArrayList<>();

    private long id = 1;


    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    public User getUserById(final long id) {
        return users.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "user with id {" + id + "} not found"));
    }

    public User saveUser(final User user) {
        user.setId(id);

        ++id;

        users.add(user);
        return user;
    }

    public User updateUser(final User user) {

        final User savedUser = getUserById(user.getId());

        savedUser.setName(user.getName());
        savedUser.setSurname(user.getSurname());
        savedUser.setEmail(user.getEmail());
        savedUser.setBirthDate(user.getBirthDate());

        return savedUser;
    }

    public void deleteUserById(final long id) {
        users = users.stream()
                .filter(e -> e.getId() != id)
                .collect(Collectors.toList());
    }

    public int count(){
        return users.size();
    }
}