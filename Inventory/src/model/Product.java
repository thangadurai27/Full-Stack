package model;

import java.util.Objects;

public class Product {
    private int id;
    private String name;
    private int minSellQuantity;
    private double price;
    private int quantityAvailable;

    // Constructor
    public Product(int id, String name, int minSellQuantity, double price, int quantityAvailable) {
        this.id = id;
        this.name = name;
        this.minSellQuantity = minSellQuantity;
        this.price = price;
        this.quantityAvailable = quantityAvailable;
    }

    // Getter and Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for minSellQuantity
    public int getMinSellQuantity() {
        return minSellQuantity;
    }

    public void setMinSellQuantity(int minSellQuantity) {
        this.minSellQuantity = minSellQuantity;
    }

    // Getter and Setter for price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Getter and Setter for quantityAvailable
    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    // Override toString for better representation of Product
    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", minSellQuantity=" + minSellQuantity + ", price=" + price
                + ", quantityAvailable=" + quantityAvailable + "]";
    }

    // Override equals to compare Product objects based on id (or other unique fields)
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Product product = (Product) o;
        return id == product.id;
    }

    // Override hashCode to maintain consistency with equals
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
