package com.epam.hibernate.manyToMany.dao;

import com.epam.hibernate.manyToMany.entity.Author;

public interface AuthorDAO {
    void saveAuthor(Author author);
    void deleteAuthor(Author author);
    Author getAuthor(int id);
    void updateAuthor(Author author);
}
