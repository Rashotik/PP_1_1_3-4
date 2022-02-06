package jm.task.core.jdbc.service;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
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
        try {
            Statement stmt = connect.createStatement( );
            stmt.execute("INSERT INTO Users (`name`, `lastName`, `age`) values ('" +
                    name + "','" +
                    lastName + "','" +
                    age + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("User with name: " + name + " is added to database");
    }

    public void removeUserById(long id) {
        try {
            Statement stmt = connect.createStatement( );
            stmt.execute("DELETE FROM Users WHERE `id` = '" + id + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            Statement stmt = connect.createStatement( );
            ResultSet set = stmt.executeQuery("SELECT * FROM my.Users;");
            ResultSetMetaData meta = set.getMetaData();
            while(set.next()) {
                    User u = new User(
                            set.getString("name"),
                            set.getString("lastName"),
                            set.getByte("age"));
                    u.setId(set.getLong("id"));
                    users.add(u);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void cleanUsersTable() {
        try {
            Statement stmt = connect.createStatement( );
            stmt.execute("DELETE FROM my.Users;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteUsersTable(){
        try {
            Statement stmt = connect.createStatement( );
            stmt.execute("DROP TABLE my.Users;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
