package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParticipantNameFactory {

    private final static String SPLIT_DELIMITER = ",";
    private final List<ParticipantName> participantNames;

    public ParticipantNameFactory(String names) {
        List<String> splitNames = split(names);
        this.participantNames = makeParticipantName(splitNames);
    }

    private List<String> split(String names) {
        return Arrays.asList(names.split(SPLIT_DELIMITER));
    }

    private List<ParticipantName> makeParticipantName(List<String> splitNames) {
        List<ParticipantName> participantNames = new ArrayList<>();
        for(String splitName : splitNames) {
            participantNames.add(new ParticipantName(splitName));
        }
        return participantNames;
    }

    public List<ParticipantName> getNames() {
        return participantNames;
    }
}
