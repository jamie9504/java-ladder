package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Products implements ItemFactory {

    private final static String SPLIT_DELIMITER = ",";
    private final static String EXCEPTION_MESSAGE_FORMAT_MORE_THAN = "상품(%d개)이 참가인원(%d명)보다 많습니다.";

    private final List<Product> products;

    public Products(String names, ItemFactory itemFactory) {
        List<String> splitNames = split(names);
        validCountLessThanOrEqualTo(splitNames, itemFactory);
        this.products = makeProductName(splitNames);
    }

    private void validCountLessThanOrEqualTo(List<String> splitNames, ItemFactory itemFactory) {
        if (splitNames.size() > itemFactory.getCount()) {
            throw new IllegalArgumentException(String
                .format(EXCEPTION_MESSAGE_FORMAT_MORE_THAN, splitNames.size(),
                    itemFactory.getCount()));
        }
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

    public boolean isLessThan(ItemFactory itemFactory) {
        return products.size() < itemFactory.getCount();
    }

    @Override
    public int getMaxNameSize() {
        List<Integer> nameSizes = new ArrayList<>();
        for (Product product : products) {
            nameSizes.add(product.getNameSize());
        }
        return Collections.max(nameSizes);
    }

    @Override
    public List<Item> getItems() {
        List<Item> items = new ArrayList<>();
        for (Product product : products) {
            items.add(product);
        }
        return items;
    }
}
