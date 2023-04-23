package practiseJDBC;

import java.sql.*;

public class SQL_Connection {
    private final static String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final static String USER  = "postgres";
    private final static String PASS  = "password";

    private Connection connection;

    public SQL_Connection() {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return connection;
    }

    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
