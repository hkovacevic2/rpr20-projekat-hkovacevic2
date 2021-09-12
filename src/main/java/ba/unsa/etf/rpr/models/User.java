package ba.unsa.etf.rpr.models;

import javafx.beans.property.SimpleStringProperty;

public class User {
    private SimpleStringProperty username, password;
    private Boolean admin;

    public User(String username, String password, Boolean admin) {
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
        this.admin = admin;
    }

    public String getUsername() {
        return username.get();
    }

    public SimpleStringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getPassword() {
        return password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
}
