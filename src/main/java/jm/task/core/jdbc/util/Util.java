package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {

    static public Connection getConnect (){
        Connection connect = null;
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost/my?"
                            + "user=root&password=rashot-8937561" );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connect;
    }
}
