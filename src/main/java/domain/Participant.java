package domain;

public class Participant {

    private final ParticipantName name;
    private final int number;

    public Participant(ParticipantName name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return this.name.getName();
    }

    public int getNumber() {
        return this.number;
    }
}
