package domain;

import java.util.List;

public interface ItemFactory {

    List<String> getNames();

    int getCount();

    int getMaxNameLength();
}
