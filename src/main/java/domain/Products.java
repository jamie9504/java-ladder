package domain;

import static util.SplitAndRefine.splitExceptJustBlankWithDelimiter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        return splitNames.stream()
            .map(Product::new)
            .collect(Collectors.toList());
    }

    @Override
    public List<String> getNames() {
        return products.stream()
            .map(Product::getName)
            .collect(Collectors.toList());
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public int getMaxNameSize() {
        return products.stream()
            .map(Product::getNameSize)
            .max(Integer::compareTo)
            .orElse(0);
    }

    @Override
    public List<Item> getItems() {
        return new ArrayList<>(products);
    }
}
