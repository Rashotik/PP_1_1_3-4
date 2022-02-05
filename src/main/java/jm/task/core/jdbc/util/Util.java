package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    static public Connection connect;

    static {
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost/my?"
                            + "user=root&password=rashot-8937561" );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
