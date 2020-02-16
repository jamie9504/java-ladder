package domain;

public class Product {

    private final String name;

    public Product(String name) {
        name = name.trim();
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
