package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        try {

            Statement statement = Util.getMySQLConnection().createStatement();
            UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();

            userDaoJDBC.createUsersTable();
            userDaoJDBC.saveUser("Ivanov", "Ivan", (byte) 60);
            userDaoJDBC.saveUser("Petrov", "Petr", (byte) 30);
            userDaoJDBC.saveUser("Vasilev", "Vasiliy", (byte) 15);
            userDaoJDBC.saveUser("Nickolaev", "Nickolay", (byte) 45);
            userDaoJDBC.getAllUsers();
            userDaoJDBC.cleanUsersTable();
            userDaoJDBC.dropUsersTable();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
