package domain;

public class Participant implements Item {

    private final static int NAME_LENGTH_MORE_THAN_NUMBER = 1;
    private final static int NAME_LENGTH_LESS_THAN_OR_EQUAL_TO_NUMBER = 5;
    private final static String EXCEPTION_MESSAGE =
        "참가자 이름은 " + NAME_LENGTH_MORE_THAN_NUMBER + "자 ~ "
            + NAME_LENGTH_LESS_THAN_OR_EQUAL_TO_NUMBER
            + "자 이내여야 합니다.";

    private final String name;

    Participant(String name) {
        name = name.trim();
        validNameLength(name);
        this.name = name;
    }

    private static void validNameLength(String name) {
        if (name.length() < NAME_LENGTH_MORE_THAN_NUMBER
            || name.length() > NAME_LENGTH_LESS_THAN_OR_EQUAL_TO_NUMBER) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }

    @Override
    public String getName() {
        return name;
    }

    public int getNameSize() {
        return getSize(name);
    }
}
