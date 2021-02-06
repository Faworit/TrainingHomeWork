package com.epam.hibernate.oneToMany.DAO;

import com.epam.hibernate.oneToMany.entity.Comment;

public interface CommentDAO {
    void saveComment(Comment comment);
    Comment getComment(int id);
    void deleteComment(Comment comment);
}
