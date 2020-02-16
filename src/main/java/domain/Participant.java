package domain;

public class Participant {

    private final ParticipantName name;
    private final LadderNumber number;

    public Participant(ParticipantName name, LadderNumber number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return this.name.getName();
    }

    public boolean isSameNumber(int number) {
        return this.number.equals(number);
    }
}
