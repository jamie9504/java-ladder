package domain;

public class Participant implements Item {

    private final static int NAME_LENGTH_MORE_THAN = 1;
    private final static int NAME_LENGTH_LESS_THAN_OR_EQUAL_TO = 5;
    private final static String EXCEPTION_MESSAGE =
        "참가자 이름은 " + NAME_LENGTH_MORE_THAN + "자 ~ " + NAME_LENGTH_LESS_THAN_OR_EQUAL_TO
            + "자 이내여야 합니다.";

    private final String name;

    Participant(String name) {
        name = name.trim();
        validNameLength(name);
        this.name = name;
    }

    private static void validNameLength(String name) {
        if (name.length() < NAME_LENGTH_MORE_THAN
            || name.length() > NAME_LENGTH_LESS_THAN_OR_EQUAL_TO) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
