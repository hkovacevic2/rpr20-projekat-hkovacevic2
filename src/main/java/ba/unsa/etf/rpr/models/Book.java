package ba.unsa.etf.rpr.models;

import javafx.beans.property.SimpleStringProperty;

public class Book extends Item {
    private SimpleStringProperty author;

    public Book() {
        super();
        author = new SimpleStringProperty();
    }

    public Book(String name, Double purchasePrice, Double sellingPrice, String description, String barcode, String author) {
        super(name, purchasePrice, sellingPrice, description, barcode);
        this.author = new SimpleStringProperty(author);
    }

    public String getAuthor() {
        return author.get();
    }

    public SimpleStringProperty authorProperty() {
        return author;
    }

    public void setAuthor(String author) {
        this.author.set(author);
    }

    @Override
    public String toString() {
        return getName() + " by " + author.get();
    }
}
