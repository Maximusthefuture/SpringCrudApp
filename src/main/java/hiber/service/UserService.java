package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void delete(long id);
    List<User> listUsers();
    void update(User user);
    User findById(long id);
}
