package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParticipantFactory implements ItemFactory {

    private final static String SPLIT_DELIMITER = ",";

    private final List<Participant> participants;

    public ParticipantFactory(String names) {
        List<String> splitNames = split(names);
        this.participants = makeParticipantName(splitNames);
    }

    private List<String> split(String names) {
        return Arrays.asList(names.split(SPLIT_DELIMITER));
    }

    private List<Participant> makeParticipantName(List<String> splitNames) {
        List<Participant> participants = new ArrayList<>();
        for (String splitName : splitNames) {
            participants.add(new Participant(splitName));
        }
        return participants;
    }

    @Override
    public List<String> getNames() {
        List<String> participantNames = new ArrayList<>();
        for (Participant participant : participants) {
            participantNames.add(participant.getName());
        }
        return participantNames;
    }

    @Override
    public int getCount() {
        return participants.size();
    }
}
