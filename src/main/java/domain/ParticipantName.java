package domain;

public class ParticipantName {

    private final String name;

    public ParticipantName(String name) {
        name = name.trim();
        vaildNameLength(name);
        this.name = name;
    }

    private static void vaildNameLength(String name) {
        if (name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException("참가자 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
