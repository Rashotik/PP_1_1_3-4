package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao dao = new UserDaoJDBCImpl();
    static public Connection connect = Util.getConnect();
    public void createUsersTable() {
        try {
            Statement stmt = connect.createStatement( );
            stmt.execute("CREATE TABLE IF NOT EXISTS `my`.`Users` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `name` varchar(45)," +
                    "  `lastName` varchar(45)," +
                    "  `age` int," +
                    "  PRIMARY KEY (`id`));");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try {
            Statement stmt = connect.createStatement( );
            stmt.execute("DROP TABLE If EXISTS Users");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        dao.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        dao.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    public void cleanUsersTable() {
        dao.cleanUsersTable();
    }
}
