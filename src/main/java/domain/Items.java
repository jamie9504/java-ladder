package domain;

import java.util.List;

public interface Items {

    List<String> getNames();

    int getCount();

    int getMaxNameSize();

    List<Item> getItems();
}
