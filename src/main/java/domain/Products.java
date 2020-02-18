package domain;

import static util.SplitAndRefine.splitExceptJustBlankWithDelimiter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Products implements Items {

    private final static String EXCEPTION_MESSAGE_FORMAT_MORE_THAN = "상품(%d개)이 참가인원(%d명)보다 많습니다.";

    private final List<Product> products;

    public Products(String names, Items items) {
        List<String> splitNames = splitExceptJustBlankWithDelimiter(names);
        validCountLessThanOrEqualTo(splitNames, items);
        this.products = makeProductName(splitNames);
    }

    private void validCountLessThanOrEqualTo(List<String> splitNames, Items items) {
        if (splitNames.size() > items.getCount()) {
            throw new IllegalArgumentException(String
                .format(EXCEPTION_MESSAGE_FORMAT_MORE_THAN, splitNames.size(),
                    items.getCount()));
        }
        if (splitNames.size() < items.getCount()) {
            inputDummy(splitNames, items.getCount() - splitNames.size());
        }
    }

    private void inputDummy(List<String> splitNames, int count) {
        for (int i = 0; i < count; i++) {
            splitNames.add("X");
        }
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
