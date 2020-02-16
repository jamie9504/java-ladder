package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductFactory implements ItemFactory {

    private final static String SPLIT_DELIMITER = ",";
    private final static String EXCEPTION_MESSAGE_FORMAT_MORE_THAN = "상품(%d개)이 참가인원(%d명)보다 많습니다.";

    private final List<Product> products;

    public ProductFactory(String names, ItemFactory itemFactory) {
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
}
