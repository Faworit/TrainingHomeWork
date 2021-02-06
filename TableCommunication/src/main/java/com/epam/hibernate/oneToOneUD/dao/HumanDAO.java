package com.epam.hibernate.oneToOneUD.dao;

import com.epam.hibernate.oneToOneUD.Human;

public interface HumanDAO {
    void save(Human human);
    Human getHuman(int id);
    void deleteHuman(Human human);
    void updateHuman(Human human);
}
