package com.epam.hibernate.oneToMany.DAO;

import com.epam.hibernate.oneToMany.entity.User;

public interface UserDAO {
    void saveUser(User user);
    User getUser(int id);
    void deleteUser(User user);
}
