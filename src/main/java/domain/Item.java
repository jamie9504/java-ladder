package domain;

public interface Item {

    String getName();

    int getNameSize();

    @Override
    boolean equals(Object obj);
}
