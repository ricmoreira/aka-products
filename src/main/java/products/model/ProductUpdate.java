package products.model;

public class ProductUpdate {
    private String name;
    private double price;

    public ProductUpdate(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
