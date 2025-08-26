package ing.store_management.models;

public class Product {
    private long id;
    private String name;
    private float price;
    private long quantity;

    public Product() {
    }

    public Product(String name, float price, long quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(long id, String name, float price, long quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
