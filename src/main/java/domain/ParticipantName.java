package domain;

public class ParticipantName {

    private final String name;

    public ParticipantName(String name) {
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }
}
