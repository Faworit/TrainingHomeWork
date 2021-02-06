package com.epam.hibernate.oneToMany;

import com.epam.hibernate.oneToMany.DAO.CommentDAO;
import com.epam.hibernate.oneToMany.DAO.UserDAO;
import com.epam.hibernate.oneToMany.DAO.impl.CommentDAOImpl;
import com.epam.hibernate.oneToMany.DAO.impl.UserDAOImpl;
import com.epam.hibernate.oneToMany.entity.Comment;
import com.epam.hibernate.oneToMany.entity.User;

public class StartOneToMany {
    private static CommentDAO commentDAO = new CommentDAOImpl();
    private static UserDAO userDAO = new UserDAOImpl();

    public static void main(String[] args) {
        //createUser();
        //createComment(84);
        getUser(84);
    }

    private static User getUser(int id) {
        User user = userDAO.getUser(id);
        if (user.getComments() != null) {
            for (Comment comment : user.getComments()) {
                System.out.println(comment.getText());
            }
        }
        return user;
    }

    private static void createUser() {
        User user = new User();
        user.setName("Ivan");
        user.setLogin("Fire");

        userDAO.saveUser(user);
    }

    private static void createComment(int userId) {
        User user = getUser(userId);
        Comment comment = new Comment();
        comment.setText("hello guys");
        comment.setUser(user);
        commentDAO.saveComment(comment);
    }

    private static Comment getComment(int id) {
        Comment comment = commentDAO.getComment(id);

        return comment;
    }

    private static void deleteComment(int id) {
        Comment comment = getComment(id);
        commentDAO.deleteComment(comment);
    }

}
