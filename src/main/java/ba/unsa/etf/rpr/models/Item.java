package ba.unsa.etf.rpr.models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Item {
    private SimpleStringProperty name;
    private SimpleDoubleProperty purchasePrice, sellingPrice;
    private SimpleStringProperty description;
    private SimpleStringProperty barcode;

    public Item() {
        this.name = new SimpleStringProperty();
        this.purchasePrice = new SimpleDoubleProperty();
        this.sellingPrice = new SimpleDoubleProperty();
        this.description = new SimpleStringProperty();
        this.barcode = new SimpleStringProperty();
    }

    public Item(String name, Double purchasePrice, Double sellingPrice, String description, String barcode) {
        this.name = new SimpleStringProperty(name);
        this.purchasePrice = new SimpleDoubleProperty(purchasePrice);
        this.sellingPrice = new SimpleDoubleProperty(sellingPrice);
        this.description = new SimpleStringProperty(description);
        this.barcode = new SimpleStringProperty(barcode);
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

    public double getPurchasePrice() {
        return purchasePrice.get();
    }

    public SimpleDoubleProperty purchasePriceProperty() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice.set(purchasePrice);
    }

    public double getSellingPrice() {
        return sellingPrice.get();
    }

    public SimpleDoubleProperty sellingPriceProperty() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice.set(sellingPrice);
    }

    public String getDescription() {
        return description.get();
    }

    public SimpleStringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public String getBarcode() {
        return barcode.get();
    }

    public SimpleStringProperty barcodeProperty() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode.set(barcode);
    }

    @Override
    public String toString() {
        return name.get();
    }
}
