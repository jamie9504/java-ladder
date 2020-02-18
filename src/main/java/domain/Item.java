package domain;

public interface Item {

    String getName();

    default int getSize(String itemName) {
        String[] names = itemName.split("");
        double result = 0.0;
        for(String name : names) {
            if(name.matches("^[ㄱ-ㅎㅏ-ㅣ가-힣]*$")) {
                result += 20.0 / 14;
                continue;
            }
            result += 1.0;
        }
        return (int) Math.round(result);
    };

    int getNameSize();

    @Override
    boolean equals(Object obj);
}
