package domain;

public class ParticipantName {

    private final String name;

    public ParticipantName(String name) {
        name = name.trim();
        validNameLength(name);
        this.name = name;
    }

    private static void validNameLength(String name) {
        if (name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException("참가자 이름은 1자 ~ 5자 이내여야 합니다..");
        }
    }

    public String getName() {
        return name;
    }
}
