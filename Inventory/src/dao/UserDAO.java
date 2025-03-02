package dao;

import model.User;

public interface UserDAO {
    User findUserByName(String name, String password) throws Exception;
    // Add other methods if needed, e.g., addUser, deleteUser, updateUser, etc.

	User findUserByName(String name);
}
