package ba.unsa.etf.rpr.models;

import javafx.beans.property.SimpleStringProperty;

public class Employee extends User {
    private SimpleStringProperty name;
    private SimpleStringProperty surname;
    private SimpleStringProperty phoneNumber;

    public Employee() {
        super();
    }

    public Employee(Integer id, String username, String password, Boolean admin, String name, String surname, String phoneNumber) {
        super(id, username, password, admin);
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSurname() {
        return surname.get();
    }

    public SimpleStringProperty surnameProperty() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public SimpleStringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    @Override
    public String toString() {
        return getName() + " " + getSurname();
    }
}
