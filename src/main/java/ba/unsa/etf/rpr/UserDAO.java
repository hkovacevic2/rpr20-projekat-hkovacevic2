package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.models.User;
import javafx.beans.value.ObservableObjectValue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class UserDAO {
    private static UserDAO instance = null;
    private Connection cnctn;
    private PreparedStatement getUserStatement, getAllUsersStatement, getAllWorkersStatement;
    private ObservableObjectValue<User> loggedUser;

    private UserDAO() throws SQLException {
        String url = "jdbc:sqlite:bbb.db";
        try {
            cnctn = DriverManager.getConnection(url);
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            regenerateDB();
            cnctn = DriverManager.getConnection(url);
        }
        getUserStatement = cnctn.prepareStatement("SELECT * FROM user WHERE username=? AND password=?");
        getAllUsersStatement = cnctn.prepareStatement("SELECT * FROM user");
        getAllWorkersStatement = cnctn.prepareStatement("SELECT * FROM user WHERE admin=0");
    }

    private void regenerateDB() {
        Scanner in;
        try {
            in = new Scanner(new FileInputStream("resources/db/bbb.sql"));
            StringBuilder statement = new StringBuilder();
            while(in.hasNext()) {
                statement.append(in.nextLine());
                if(statement.charAt(statement.length() - 1) == ';') {
                    try {
                        Statement stmt = cnctn.createStatement();
                        stmt.execute(String.valueOf(statement));
                        stmt.close();
                        statement = new StringBuilder("");
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static UserDAO getInstance() throws SQLException {
        if (instance == null) instance = new UserDAO();
        return instance;
    }

    public User getUser(String username, String password) {
        User user = null;
        try {
            getUserStatement.setString(1,username);
            getUserStatement.setString(2,password);
            ResultSet rs = getUserStatement.executeQuery();
            if(rs.next())
                user = new User(rs.getString(2),rs.getString(3),rs.getInt(4) == 1);
        }catch (SQLException e) {
            return user;
        }
        return user;
    }

}
