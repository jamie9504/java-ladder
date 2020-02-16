package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductFactory implements ItemFactory {

    private final static String SPLIT_DELIMITER = ",";

    private final List<Product> products;

    public ProductFactory(String names, ItemFactory itemFactory) {
        List<String> splitNames = split(names);
        this.products = makeProductName(splitNames);
    }

    private List<String> split(String names) {
        return Arrays.asList(names.split(SPLIT_DELIMITER));
    }

    private List<Product> makeProductName(List<String> splitNames) {
        List<Product> products = new ArrayList<>();
        for (String splitName : splitNames) {
            products.add(new Product(splitName));
        }
        return products;
    }

    @Override
    public List<String> getNames() {
        List<String> productNames = new ArrayList<>();
        for (Product product : products) {
            productNames.add(product.getName());
        }
        return productNames;
    }

    @Override
    public int getCount() {
        return products.size();
    }
}
